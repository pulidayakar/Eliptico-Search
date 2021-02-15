package com.test.eliptico;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class CityViewModel extends ViewModel {
    private MediatorLiveData<List<FeaturedList>> listMutableLiveData;
    private CityRepository cityRepository;
    public CityViewModel(String city){
        listMutableLiveData = new MediatorLiveData<>();
        cityRepository = new CityRepository(city);
    }

    public MutableLiveData<List<FeaturedList>> getListMutableLiveData(){
        listMutableLiveData.addSource(cityRepository.getDataFromApiCall(), cityList -> listMutableLiveData.setValue(cityList.getFeatures()));
        return listMutableLiveData;
    }
}
