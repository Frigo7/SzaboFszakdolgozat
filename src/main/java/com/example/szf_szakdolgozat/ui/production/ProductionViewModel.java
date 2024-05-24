package com.example.szf_szakdolgozat.ui.production;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProductionViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ProductionViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is production fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}