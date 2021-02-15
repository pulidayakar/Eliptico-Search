package com.test.eliptico;

import androidx.lifecycle.MutableLiveData;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CityRepository {
    private static final String TOKEN = "pk.eyJ1IjoiYXNoaXNwIiwiYSI6ImNqcWo1Z2gzbzBzMTg0MnF5bDllbWE1eW0ifQ.v5ycPxqKlE4vqRNC19wjvw";
    ApiEndPoint apiEndPoint;
    private String city;
    public CityRepository(String city){
        apiEndPoint = RetrofitUtils.getInstance();
        this.city = city;
    }

    public MutableLiveData<CityList> getDataFromApiCall(){
        MutableLiveData<CityList> mutableLiveData = new MutableLiveData<>();
        Call<CityList> call = apiEndPoint.getListOfPlaces(city, TOKEN);
        call.enqueue(new Callback<CityList>() {
            @Override
            public void onResponse(@NotNull Call<CityList> call, @NotNull Response<CityList> response) {
                if (response.isSuccessful() && response.body() != null)
                    mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(@NotNull Call<CityList> call, @NotNull Throwable t) {
                mutableLiveData.setValue(null);
            }
        });
        return mutableLiveData;
    }
}
