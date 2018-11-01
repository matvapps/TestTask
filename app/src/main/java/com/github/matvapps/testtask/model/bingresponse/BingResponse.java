
package com.github.matvapps.testtask.model.bingresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BingResponse {

    @SerializedName("authenticationResultCode")
    @Expose
    private String authenticationResultCode;
    @SerializedName("brandLogoUri")
    @Expose
    private String brandLogoUri;
    @SerializedName("copyright")
    @Expose
    private String copyright;
    @SerializedName("resourceSets")
    @Expose
    private List<ResourceSet> resourceSets = null;
    @SerializedName("statusCode")
    @Expose
    private Integer statusCode;
    @SerializedName("statusDescription")
    @Expose
    private String statusDescription;
    @SerializedName("traceId")
    @Expose
    private String traceId;

    public String getAuthenticationResultCode() {
        return authenticationResultCode;
    }

    public void setAuthenticationResultCode(String authenticationResultCode) {
        this.authenticationResultCode = authenticationResultCode;
    }

    public String getBrandLogoUri() {
        return brandLogoUri;
    }

    public void setBrandLogoUri(String brandLogoUri) {
        this.brandLogoUri = brandLogoUri;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public List<ResourceSet> getResourceSets() {
        return resourceSets;
    }

    public void setResourceSets(List<ResourceSet> resourceSets) {
        this.resourceSets = resourceSets;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

}
