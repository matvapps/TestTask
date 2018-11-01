
package com.github.matvapps.testtask.model.bingresponse;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GeocodePoint {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("coordinates")
    @Expose
    private List<Double> coordinates = null;
    @SerializedName("calculationMethod")
    @Expose
    private String calculationMethod;
    @SerializedName("usageTypes")
    @Expose
    private List<String> usageTypes = null;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Double> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Double> coordinates) {
        this.coordinates = coordinates;
    }

    public String getCalculationMethod() {
        return calculationMethod;
    }

    public void setCalculationMethod(String calculationMethod) {
        this.calculationMethod = calculationMethod;
    }

    public List<String> getUsageTypes() {
        return usageTypes;
    }

    public void setUsageTypes(List<String> usageTypes) {
        this.usageTypes = usageTypes;
    }

}
