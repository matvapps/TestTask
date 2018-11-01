package com.github.matvapps.testtask.model.tomtomresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.tomtom.online.sdk.common.location.BoundingBox;

import java.util.List;

/**
 * Created by Alexandr
 */
public class AddressResponse {

    @SerializedName("buildingNumber")
    @Expose
    private String buildingNumber;
    @SerializedName("streetNumber")
    @Expose
    private String streetNumber;
    @SerializedName("routeNumbers")
    @Expose
    private List<Object> routeNumbers = null;
    @SerializedName("street")
    @Expose
    private String street;
    @SerializedName("streetName")
    @Expose
    private String streetName;
    @SerializedName("streetNameAndNumber")
    @Expose
    private String streetNameAndNumber;
    @SerializedName("countryCode")
    @Expose
    private String countryCode;
    @SerializedName("countrySubdivision")
    @Expose
    private String countrySubdivision;
    @SerializedName("countrySecondarySubdivision")
    @Expose
    private String countrySecondarySubdivision;
    @SerializedName("municipality")
    @Expose
    private String municipality;
    @SerializedName("municipalitySubdivision")
    @Expose
    private String municipalitySubdivision;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("countryCodeISO3")
    @Expose
    private String countryCodeISO3;
    @SerializedName("freeformAddress")
    @Expose
    private String freeformAddress;
    @SerializedName("boundingBox")
    @Expose
    private BoundingBox boundingBox;

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public List<Object> getRouteNumbers() {
        return routeNumbers;
    }

    public void setRouteNumbers(List<Object> routeNumbers) {
        this.routeNumbers = routeNumbers;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNameAndNumber() {
        return streetNameAndNumber;
    }

    public void setStreetNameAndNumber(String streetNameAndNumber) {
        this.streetNameAndNumber = streetNameAndNumber;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountrySubdivision() {
        return countrySubdivision;
    }

    public void setCountrySubdivision(String countrySubdivision) {
        this.countrySubdivision = countrySubdivision;
    }

    public String getCountrySecondarySubdivision() {
        return countrySecondarySubdivision;
    }

    public void setCountrySecondarySubdivision(String countrySecondarySubdivision) {
        this.countrySecondarySubdivision = countrySecondarySubdivision;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getMunicipalitySubdivision() {
        return municipalitySubdivision;
    }

    public void setMunicipalitySubdivision(String municipalitySubdivision) {
        this.municipalitySubdivision = municipalitySubdivision;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCodeISO3() {
        return countryCodeISO3;
    }

    public void setCountryCodeISO3(String countryCodeISO3) {
        this.countryCodeISO3 = countryCodeISO3;
    }

    public String getFreeformAddress() {
        return freeformAddress;
    }

    public void setFreeformAddress(String freeformAddress) {
        this.freeformAddress = freeformAddress;
    }

    public BoundingBox getBoundingBox() {
        return boundingBox;
    }

    public void setBoundingBox(BoundingBox boundingBox) {
        this.boundingBox = boundingBox;
    }

}
