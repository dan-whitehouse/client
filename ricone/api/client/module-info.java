/**
 * @project: APIClient
 * @author: Dan on 6/28/2018.
 */
module org.ricone.api {
    requires com.fasterxml.jackson.annotation;
    requires spring.web;
    requires spring.core;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.dataformat.xml;
    requires java.jwt;

    opens org.ricone.api.client.response.model to com.fasterxml.jackson.databind;
    opens org.ricone.api.client.authentication to com.fasterxml.jackson.databind;

    exports org.ricone.api.client.authentication to com.fasterxml.jackson.databind;
    exports org.ricone.api.client.response to com.fasterxml.jackson.databind;
    exports org.ricone.api.client.response.model to com.fasterxml.jackson.databind;
}