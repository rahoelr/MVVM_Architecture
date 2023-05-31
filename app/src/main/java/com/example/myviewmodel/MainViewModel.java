package com.example.myviewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private MutableLiveData<Integer> _result = new MutableLiveData<>();
    public LiveData<Integer> result = _result;

    public void calculate(String length, String width, String height){
        int result = Integer.parseInt(length) * Integer.parseInt(width) * Integer.parseInt(height);
        _result.setValue(result);
    }
}
