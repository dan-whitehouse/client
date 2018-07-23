package org.ricone.api.client.response;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

public interface XResponse<T> {
    T getData();

    String getRequestPath();

    void setRequestPath(String requestPath);

    HttpHeaders getRequestHeaders();

    void setRequestHeaders(HttpHeaders requestHeaders);

    HttpStatus getResponseStatus();

    void setResponseStatus(HttpStatus status);

    String getResponseStatusText();

    void setResponseStatusText(String statusText);

    HttpHeaders getResponseHeaders();

    void setResponseHeaders(HttpHeaders responseHeaders);

    String getJSON();

    String getXML();
}
