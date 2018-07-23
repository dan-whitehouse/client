/*
 * RIC One File Bridge
 * Version: 1.0.0 Build 20170604-1
 * Copyright © 2017 New York State Education Department
 * Created At Northeastern Regional Information Center By Daniel Whitehouse
 */

package org.ricone.api.client.response;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.ricone.api.client.response.model.XCourse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"xCourse"})
public class XCourseResponse implements XResponse<XCourse> {
    @JsonProperty("xCourse")
    private XCourse xCourse;
    @JsonIgnore
    private String requestPath;
    @JsonIgnore
    private HttpHeaders requestHeaders;
    @JsonIgnore
    private HttpStatus responseStatus;
    @JsonIgnore
    private String responseStatusText;
    @JsonIgnore
    private HttpHeaders responseHeaders;

    public XCourseResponse() {
        xCourse = new XCourse();
    }

    public XCourseResponse(XCourse xCourse) {
        super();
        this.xCourse = xCourse;
    }

    @JsonProperty("xCourse")
    public XCourse getXCourse() {
        return xCourse;
    }

    @JsonProperty("xCourse")
    public void setXCourse(XCourse xCourse) {
        this.xCourse = xCourse;
    }

    @Override
    public XCourse getData() {
        return xCourse;
    }

    @Override
    public String getRequestPath() {
        return requestPath;
    }

    @Override
    public void setRequestPath(String requestPath) {
        this.requestPath = requestPath;
    }

    @Override
    public HttpHeaders getRequestHeaders() {
        return requestHeaders;
    }

    @Override
    public void setRequestHeaders(HttpHeaders requestHeaders) {
        this.requestHeaders = requestHeaders;
    }

    @Override
    public HttpStatus getResponseStatus() {
        return responseStatus;
    }

    @Override
    public void setResponseStatus(HttpStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    @Override
    public String getResponseStatusText() {
        return responseStatusText;
    }

    @Override
    public void setResponseStatusText(String responseStatusText) {
        this.responseStatusText = responseStatusText;
    }

    @Override
    public HttpHeaders getResponseHeaders() {
        return responseHeaders;
    }

    @Override
    public void setResponseHeaders(HttpHeaders responseHeaders) {
        this.responseHeaders = responseHeaders;
    }

    @Override
    public String getJSON() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        try {
            return writer.writeValueAsString(xCourse);
        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getXML() {
        XmlMapper mapper = new XmlMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            return mapper.writeValueAsString(xCourse);
        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return "XCourseResponse{" + "xCourse=" + xCourse + '}';
    }
}