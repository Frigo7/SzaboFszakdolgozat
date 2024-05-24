package com.example.szf_szakdolgozat.ui.production;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.szf_szakdolgozat.R;
import com.example.szf_szakdolgozat.databinding.FragmentProductionBinding;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class ProductionFragment extends Fragment {

    private FragmentProductionBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ProductionViewModel productionViewModel =
                new ViewModelProvider(this).get(ProductionViewModel.class);

        binding = FragmentProductionBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textProduction;
        productionViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        // Spinner setup
        Spinner spinner = binding.spinner;
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.example_items, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            user.getIdToken(false).addOnSuccessListener(result -> {
                if (Boolean.TRUE.equals(result.getClaims().get("admin"))) {
                    initializePieChart();
                }
            }).addOnFailureListener(e -> {

            });
        }

        return root;
    }

    private void initializePieChart() {
        PieChart pieChart = binding.pieChart;
        ArrayList<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(18.5f, "Gyártott mennyiség"));
        entries.add(new PieEntry(26.7f, "Kamera adat"));
        entries.add(new PieEntry(24.0f, "Zárt ajtó jel"));
        entries.add(new PieEntry(30.8f, "Label4"));
        entries.add(new PieEntry(50.2f, "Label5"));

        PieDataSet dataSet = new PieDataSet(entries, "Your DataSet Label");
        dataSet.setColors(new int[] { Color.GREEN, Color.BLUE, Color.MAGENTA, Color.CYAN, Color.RED });
        PieData data = new PieData(dataSet);

        pieChart.setData(data);
        pieChart.invalidate();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
