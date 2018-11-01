package com.github.matvapps.testtask.model.tomtomresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Alexandr
 */


public class TomTomResponse {

    @SerializedName("summary")
    @Expose
    private Summary summary;
    @SerializedName("addresses")
    @Expose
    private List<Address> addresses = null;

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

}