package com.github.matvapps.testtask.main;

import android.util.Log;

import com.github.matvapps.testtask.api.ApiUtils;
import com.github.matvapps.testtask.api.TestTaskApi;
import com.github.matvapps.testtask.base.Presenter;
import com.github.matvapps.testtask.model.Location;
import com.github.matvapps.testtask.model.bingresponse.BingResponse;
import com.github.matvapps.testtask.model.tomtomresponse.TomTomResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Alexandr.
 */
public class MainPresenter implements Presenter<MainView> {

    public final String TAG = MainPresenter.class.getSimpleName();

    private TestTaskApi api;
    private MainView view;

    private final String JSON = "json";
    private final String BASE_TOMTOM_URL = "https://api.tomtom.com/search/2/reverseGeocode/";
    private final String BASE_BING_URL = "http://dev.virtualearth.net/REST/v1/Locations/";

    @Override
    public void attachView(MainView view) {
        this.view = view;
        api = ApiUtils.getTestTaskApi();
    }

    public void getAddress(String latlng, String key, int serviceId) {
        view.showLoading(true);
        String url;

        switch (serviceId) {
            case 2:
                url = String.format("%s%s", BASE_BING_URL, latlng);
                api.getAddressFromBing(url, JSON, key).enqueue(new Callback<BingResponse>() {
                    @Override
                    public void onResponse(Call<BingResponse> call, Response<BingResponse> response) {
                        view.showLoading(false);
                        if (response.code() == 200) {
                            BingResponse bingResponse = response.body();
                            if (bingResponse != null) {
                                Log.d(TAG, "onResponse: " + response.raw().request().url());

                                if (bingResponse.getResourceSets() != null &&
                                        bingResponse.getResourceSets().get(0).getResources() != null) {

                                    String country = bingResponse.getResourceSets()
                                            .get(0)
                                            .getResources()
                                            .get(0)
                                            .getAddress()
                                            .getCountryRegion();
                                    String city = bingResponse.getResourceSets()
                                            .get(0)
                                            .getResources()
                                            .get(0)
                                            .getAddress()
                                            .getLocality();
                                    String street = bingResponse.getResourceSets()
                                            .get(0)
                                            .getResources()
                                            .get(0)
                                            .getAddress()
                                            .getAddressLine();

                                    view.onGetAddress(new Location(country, city, street), latlng);
                                }
                            } else {
                                view.showError("No results");
                            }
                        } else {
                            view.showError("Code = " + String.valueOf(response.code()));
                        }
                    }

                    @Override
                    public void onFailure(Call<BingResponse> call, Throwable t) {
                        Log.d(TAG, "onFailure: " + t.getMessage());
                        view.showLoading(false);
                        view.showError(t.getMessage());
                    }
                });
                break;
            case 3:
                url = String.format("%s%s.%s", BASE_TOMTOM_URL, latlng, JSON);
                api.getAddressFromTomTom(url, key).enqueue(new Callback<TomTomResponse>() {
                    @Override
                    public void onResponse(Call<TomTomResponse> call, retrofit2.Response<TomTomResponse> response) {
                        view.showLoading(false);
                        if (response.code() == 200) {
                            TomTomResponse tomTomResponse = response.body();
                            if (tomTomResponse != null) {
                                Log.d(TAG, "onResponse: " + response.raw().request().url());

                                if (tomTomResponse.getSummary().getNumResults() > 0) {
                                    String position = tomTomResponse.getAddresses().get(0).getPosition();

                                    String country = tomTomResponse.getAddresses()
                                            .get(0)
                                            .getAddress()
                                            .getCountry();
                                    String city = tomTomResponse.getAddresses()
                                            .get(0)
                                            .getAddress()
                                            .getMunicipality();
                                    String street = tomTomResponse.getAddresses()
                                            .get(0)
                                            .getAddress()
                                            .getStreetNameAndNumber();

                                    view.onGetAddress(new Location(country, city, street), position);
                                } else {
                                    view.showError("No results");
                                }
                            }

                        } else {
                            view.showError("Code = " + String.valueOf(response.code()));
                        }
                    }

                    @Override
                    public void onFailure(Call<TomTomResponse> call, Throwable t) {
                        Log.d(TAG, "onFailure: " + t.getMessage());
                        view.showLoading(false);
                        view.showError(t.getMessage());
                    }
                });
                break;
        }
    }


    @Override
    public void detachView() {

    }
}
