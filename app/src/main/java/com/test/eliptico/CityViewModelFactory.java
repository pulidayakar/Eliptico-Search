package com.test.eliptico;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class CityViewModelFactory implements ViewModelProvider.Factory {
    private String cityName;
    public CityViewModelFactory(String cityName){
        this.cityName = cityName;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new CityViewModel(cityName);
    }
}
