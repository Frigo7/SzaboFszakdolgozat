package com.example.szf_szakdolgozat.ui.maintenance;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;



public class MaintenanceViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public MaintenanceViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is maintenance fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}