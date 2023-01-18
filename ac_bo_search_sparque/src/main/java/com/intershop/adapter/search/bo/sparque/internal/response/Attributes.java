
package com.intershop.adapter.search.bo.sparque.internal.response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "image-ref",
    "manufacturer-name",
    "name",
    "short-description",
    "sku",
    "supplier-sku",
    "price"
})
@Generated("jsonschema2pojo")
public class Attributes {

    @JsonProperty("image-ref")
    private List<String> imageRef = null;
    @JsonProperty("manufacturer-name")
    private String manufacturerName;
    @JsonProperty("name")
    private Map<String,String> names;
    @JsonProperty("short-description")
    private Map<String,String> shortDescriptions;
    @JsonProperty("sku")
    private String sku;
    @JsonProperty("supplier-sku")
    private String supplierSku;
    @JsonProperty("price")
    private Double price;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("image-ref")
    public List<String> getImageRef() {
        return imageRef;
    }

    @JsonProperty("image-ref")
    public void setImageRef(List<String> imageRef) {
        this.imageRef = imageRef;
    }

    @JsonProperty("manufacturer-name")
    public String getManufacturerName() {
        return manufacturerName;
    }

    @JsonProperty("manufacturer-name")
    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    @JsonProperty("name")
    public Map<String,String> getNames() {
        return names;
    }

    @JsonProperty("name")
    public void setNames(Map<String,String> names) {
        this.names = names;
    }

    @JsonProperty("short-description")
    public Map<String,String> getShortDescriptions() {
        return shortDescriptions;
    }

    @JsonProperty("short-description")
    public void setShortDescription(Map<String,String> shortDescriptions) {
        this.shortDescriptions = shortDescriptions;
    }

    @JsonProperty("sku")
    public String getSku() {
        return sku;
    }

    @JsonProperty("sku")
    public void setSku(String sku) {
        this.sku = sku;
    }

    @JsonProperty("supplier-sku")
    public String getSupplierSku() {
        return supplierSku;
    }

    @JsonProperty("supplier-sku")
    public void setSupplierSku(String supplierSku) {
        this.supplierSku = supplierSku;
    }

    @JsonProperty("price")
    public Double getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(Double price) {
        this.price = price;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
