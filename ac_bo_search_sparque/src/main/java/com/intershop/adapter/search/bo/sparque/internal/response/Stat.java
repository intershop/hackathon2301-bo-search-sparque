
package com.intershop.adapter.search.bo.sparque.internal.response;

import java.util.HashMap;
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
    "cutoff",
    "numResults"
})
@Generated("jsonschema2pojo")
public class Stat {

    @JsonProperty("cutoff")
    private String cutoff;
    @JsonProperty("numResults")
    private Integer numResults;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("cutoff")
    public String getCutoff() {
        return cutoff;
    }

    @JsonProperty("cutoff")
    public void setCutoff(String cutoff) {
        this.cutoff = cutoff;
    }

    @JsonProperty("numResults")
    public Integer getNumResults() {
        return numResults;
    }

    @JsonProperty("numResults")
    public void setNumResults(Integer numResults) {
        this.numResults = numResults;
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
