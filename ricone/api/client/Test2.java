package org.ricone.api.client;

import org.ricone.api.client.authentication.Authenticator;
import org.ricone.api.client.authentication.Endpoint;
import org.ricone.api.client.request2.*;
import org.ricone.api.client.request2.exception.InvalidPathException;
import org.ricone.api.client.request2.exception.MissingArgumentException;
import org.ricone.api.client.response.XResponse;
import org.ricone.api.client.response.model.XLea;

import java.util.Optional;

/**
 * @project: client
 * @author: Dan on 6/28/2018.
 */
public class Test2 {
    private static final String authUrl = System.getenv("url");
    private static final String username = System.getenv("username");
    private static final String password = System.getenv("password");
    private static final String providerId = System.getenv("provider");

    public static void main(String[] args) throws InvalidPathException, MissingArgumentException {

        Authenticator authenticator = Authenticator.getInstance();
        authenticator.authenticate(authUrl, username, password);

        if(authenticator.isAuthenticated()) {
            Optional<Endpoint> endpoint = authenticator.getEndpoint(providerId);

            if(endpoint.isPresent()) {
                XPress xPress = new XPress(endpoint.get());

                testGenericBuilder(xPress);
            }
        }
        else {
            System.out.println("Auth Failed");
        }
    }

    private static void testGenericBuilder(XPress xPress) throws MissingArgumentException, InvalidPathException {
        XRequest request = new XRequestBuilder(ServicePath.GET_XLEA_BY_REFID).id("5776DEB4-A6C8-43B1-AB08-CD5B95983177").idType(IdType.REF_ID).build();
        XResponse<XLea> response = xPress.getXLea(request);
        System.out.println(response.getData().getRefId() + " - " + response.getData().getLeaName());
    }
}
