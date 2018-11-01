package com.github.matvapps.testtask.model.tomtomresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Alexandr
 */
public class Address {

    @SerializedName("address")
    @Expose
    private AddressResponse address;
    @SerializedName("position")
    @Expose
    private String position;

    public AddressResponse getAddress() {
        return address;
    }

    public void setAddress(AddressResponse address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

}
