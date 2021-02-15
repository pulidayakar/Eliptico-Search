package com.test.eliptico;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiEndPoint {
    @GET("geocoding/v5/mapbox.places/{search_input}.json")
    Call<CityList> getListOfPlaces(@Path("search_input") String search_input,
                                   @Query("access_token") String token
                                   );
}
