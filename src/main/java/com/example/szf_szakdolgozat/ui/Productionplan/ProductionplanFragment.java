package com.example.szf_szakdolgozat.ui.Productionplan;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.szf_szakdolgozat.R;
import com.example.szf_szakdolgozat.databinding.FragmentMaintenanceBinding;
import com.example.szf_szakdolgozat.databinding.FragmentProductionplanBinding;
import com.example.szf_szakdolgozat.ui.maintenance.MaintenanceViewModel;

public class ProductionplanFragment extends Fragment {

    private FragmentProductionplanBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ProductionplanViewModel productionplanViewModel =
                new ViewModelProvider(this).get(ProductionplanViewModel.class);

        binding = FragmentProductionplanBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textProductionplan;
       productionplanViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
