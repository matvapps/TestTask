
package com.github.matvapps.testtask.model.bingresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Address {

    @SerializedName("addressLine")
    @Expose
    private String addressLine;
    @SerializedName("adminDistrict")
    @Expose
    private String adminDistrict;
    @SerializedName("adminDistrict2")
    @Expose
    private String adminDistrict2;
    @SerializedName("countryRegion")
    @Expose
    private String countryRegion;
    @SerializedName("formattedAddress")
    @Expose
    private String formattedAddress;
    @SerializedName("locality")
    @Expose
    private String locality;
    @SerializedName("postalCode")
    @Expose
    private String postalCode;

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getAdminDistrict() {
        return adminDistrict;
    }

    public void setAdminDistrict(String adminDistrict) {
        this.adminDistrict = adminDistrict;
    }

    public String getAdminDistrict2() {
        return adminDistrict2;
    }

    public void setAdminDistrict2(String adminDistrict2) {
        this.adminDistrict2 = adminDistrict2;
    }

    public String getCountryRegion() {
        return countryRegion;
    }

    public void setCountryRegion(String countryRegion) {
        this.countryRegion = countryRegion;
    }

    public String getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

}
