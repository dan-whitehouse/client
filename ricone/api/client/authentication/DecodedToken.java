package org.ricone.api.client.authentication;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"application_id", "iat", "exp", "iss"})
public class DecodedToken implements Serializable {
    @JsonProperty("application_id")
    private String applicationId;
    @JsonProperty("iat")
    private Integer iat;
    @JsonProperty("exp")
    private Integer exp;
    @JsonProperty("iss")
    private String iss;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 9033040468688496163L;

    /**
     * No args constructor for use in serialization
     */
    public DecodedToken() {
    }

    /**
     * @param exp
     * @param iss
     * @param applicationId
     * @param iat
     */
    public DecodedToken(String applicationId, Integer iat, Integer exp, String iss) {
        super();
        this.applicationId = applicationId;
        this.iat = iat;
        this.exp = exp;
        this.iss = iss;
    }

    @JsonProperty("application_id")
    public String getApplicationId() {
        return applicationId;
    }

    @JsonProperty("application_id")
    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    @JsonProperty("iat")
    public Integer getIat() {
        return iat;
    }

    @JsonProperty("iat")
    public void setIat(Integer iat) {
        this.iat = iat;
    }

    @JsonProperty("exp")
    public Integer getExp() {
        return exp;
    }

    @JsonProperty("exp")
    public void setExp(Integer exp) {
        this.exp = exp;
    }

    @JsonProperty("iss")
    public String getIss() {
        return iss;
    }

    @JsonProperty("iss")
    public void setIss(String iss) {
        this.iss = iss;
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
