package com.github.matvapps.testtask.model.tomtomresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Alexandr
 */
public class Summary {
    @SerializedName("queryTime")
    @Expose
    private int queryTime;

    @SerializedName("numResults")
    @Expose
    private int numResults;

    public Summary(int queryTime, int numResults) {
        this.queryTime = queryTime;
        this.numResults = numResults;
    }

    public int getQueryTime() {
        return queryTime;
    }

    public void setQueryTime(int queryTime) {
        this.queryTime = queryTime;
    }

    public int getNumResults() {
        return numResults;
    }

    public void setNumResults(int numResults) {
        this.numResults = numResults;
    }
}
