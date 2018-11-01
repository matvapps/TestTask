package com.github.matvapps.testtask.api;

import com.github.matvapps.testtask.model.bingresponse.BingResponse;
import com.github.matvapps.testtask.model.tomtomresponse.TomTomResponse;

import io.reactivex.annotations.NonNull;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by Alexandr.
 */
public interface TestTaskApi {

//    //https://maps.googleapis.com/maps/api/geocode/json
//    @GET
//    Call<Response> getAddressFromGoogle(@Url String url,
//                                    @NonNull @Query("latlng") String latlng,
//                                    @NonNull @Query("key") String key);

    //http://dev.virtualearth.net/REST/v1/Locations/47.64054,-122.12934?o=json&key=AvwAHfGDafysP3AYyo5zaOT1-o1zuG-YuVBo1ZphUOLUCzaxHIi1z13fiJ3IaE45
    @GET
    Call<BingResponse> getAddressFromBing(@Url String url,
                                          @NonNull @Query("o") String responseType,
                                          @NonNull @Query("key") String key);

    //https://api.tomtom.com/search/2/reverseGeocode/37.8328,-122.27669.json?key=*****
    @GET
    Call<TomTomResponse> getAddressFromTomTom(@Url String url,
                                              @NonNull @Query("key") String key);

}
