package com.example.szf_szakdolgozat.ui.Productionplan;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProductionplanViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ProductionplanViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is production plan fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}