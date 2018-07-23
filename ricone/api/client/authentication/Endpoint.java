package org.ricone.api.client.authentication;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"name", "href", "provider_id", "token"})
public class Endpoint implements Serializable {
    @JsonProperty("name")
    private String name;
    @JsonProperty("href")
    private String href;
    @JsonProperty("provider_id")
    private String providerId;
    @JsonProperty("token")
    private String token;
    private final static long serialVersionUID = -3410519710831695918L;

    public Endpoint() {
    }

    public Endpoint(String name, String href, String providerId, String token) {
        super();
        this.name = name;
        this.href = href;
        this.providerId = providerId;
        this.token = token;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("href")
    public String getHref() {
        return href;
    }

    @JsonProperty("href")
    public void setHref(String href) {
        this.href = href;
    }

    @JsonProperty("provider_id")
    public String getProviderId() {
        return providerId;
    }

    @JsonProperty("provider_id")
    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    @JsonProperty("token")
    public String getToken() {
        return Authenticator.getInstance().getToken();
    }

    @JsonProperty("token")
    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        Endpoint endpoint = (Endpoint) o;

        if(name != null ? !name.equals(endpoint.name) : endpoint.name != null) return false;
        if(href != null ? !href.equals(endpoint.href) : endpoint.href != null) return false;
        return providerId != null ? providerId.equals(endpoint.providerId) : endpoint.providerId == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (href != null ? href.hashCode() : 0);
        result = 31 * result + (providerId != null ? providerId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Endpoint{" + "name='" + name + '\'' + ", href='" + href + '\'' + ", providerId='" + providerId + '\'' + ", token='" + token + '\'' + '}';
    }
}