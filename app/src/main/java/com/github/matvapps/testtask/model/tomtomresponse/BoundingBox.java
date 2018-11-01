package com.github.matvapps.testtask.model.tomtomresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Alexandr
 */
public class BoundingBox {

    @SerializedName("northEast")
    @Expose
    private String northEast;
    @SerializedName("southWest")
    @Expose
    private String southWest;
    @SerializedName("entity")
    @Expose
    private String entity;

    public String getNorthEast() {
        return northEast;
    }

    public void setNorthEast(String northEast) {
        this.northEast = northEast;
    }

    public String getSouthWest() {
        return southWest;
    }

    public void setSouthWest(String southWest) {
        this.southWest = southWest;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

}
