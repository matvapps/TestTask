
package com.github.matvapps.testtask.model.bingresponse;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Resource {

    @SerializedName("__type")
    @Expose
    private String type;
    @SerializedName("bbox")
    @Expose
    private List<Double> bbox = null;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("point")
    @Expose
    private Point point;
    @SerializedName("address")
    @Expose
    private Address address;
    @SerializedName("confidence")
    @Expose
    private String confidence;
    @SerializedName("entityType")
    @Expose
    private String entityType;
    @SerializedName("geocodePoints")
    @Expose
    private List<GeocodePoint> geocodePoints = null;
    @SerializedName("matchCodes")
    @Expose
    private List<String> matchCodes = null;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Double> getBbox() {
        return bbox;
    }

    public void setBbox(List<Double> bbox) {
        this.bbox = bbox;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getConfidence() {
        return confidence;
    }

    public void setConfidence(String confidence) {
        this.confidence = confidence;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public List<GeocodePoint> getGeocodePoints() {
        return geocodePoints;
    }

    public void setGeocodePoints(List<GeocodePoint> geocodePoints) {
        this.geocodePoints = geocodePoints;
    }

    public List<String> getMatchCodes() {
        return matchCodes;
    }

    public void setMatchCodes(List<String> matchCodes) {
        this.matchCodes = matchCodes;
    }

}
