package org.ricone.api.client.authentication;

import com.auth0.jwt.JWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

public class Authenticator {
    private RestTemplate restTemplate;
    private ObjectMapper mapper;
    private String url;
    private String username;
    private String password;
    private String token;
    private DecodedToken decodedToken;
    private List<Endpoint> endpoints;

    private Authenticator() {
        restTemplate = new RestTemplate();
        mapper = new ObjectMapper();
    }

    private static class SingletonHelper {
        private static final Authenticator INSTANCE = new Authenticator();
    }

    public static Authenticator getInstance() {
        return SingletonHelper.INSTANCE;
    }

    /**
     * Establish connection to authenticate to authentication server.
     *
     * @param url      the authentication server url.
     * @param username the username for the application.
     * @param password the password for the application.
     */
    public void authenticate(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("username", username);
        body.add("password", password);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<?> entity = new HttpEntity<Object>(body, headers);

        try {
            ResponseEntity<Login> login = restTemplate.exchange(url, HttpMethod.POST, entity, Login.class);
            if(login.hasBody()) {
                token = login.getBody().getToken();
                endpoints = login.getBody().getEndpoints();
                decodedToken = mapper.readValue(new String(Base64.getDecoder().decode(JWT.decode(token).getPayload())), DecodedToken.class);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * A list of all endpoints an application is associated with and it's details.
     *
     * @return a list of type Endpoint.
     */
    public List<Endpoint> getEndpoints() {
        if(endpoints != null) {
            return endpoints;
        }
        return new ArrayList<>();
    }

    /**
     * Details of a specific endpoint by providerId.
     *
     * @param providerId the providerId to be returned.
     * @return an Endpoint by specified providerId.
     */
    public Optional<Endpoint> getEndpoint(String providerId) {
        if(endpoints != null) {
            return endpoints.stream().filter(endpoint -> endpoint.getProviderId().equalsIgnoreCase(providerId)).findFirst();
        }
        return Optional.empty();
    }

    /**
     * Determine if authentication was successful.
     *
     * @return value of type boolean.
     */
    public boolean isAuthenticated() {
        return !isTokenExpired();
    }

    String getToken() {
        if(isTokenExpired() || willTokenExpire()) {
            authenticate(url, username, password);
        }
        return token;
    }

    private boolean isTokenExpired() {
        try {
            LocalDateTime expiryDate = LocalDateTime.ofInstant(Instant.ofEpochSecond(decodedToken.getExp()), ZoneId.systemDefault());
            return expiryDate.isBefore(LocalDateTime.now());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    private boolean willTokenExpire() {
        try {
            LocalDateTime expiryDate = LocalDateTime.ofInstant(Instant.ofEpochSecond(decodedToken.getExp()), ZoneId.systemDefault()).plusMinutes(5);
            return expiryDate.isBefore(LocalDateTime.now());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}