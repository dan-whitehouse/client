package org.ricone.api.client;

import org.ricone.api.client.authentication.Authenticator;
import org.ricone.api.client.authentication.Endpoint;
import org.ricone.api.client.request3.*;
import org.ricone.api.client.request3.exception.InvalidPathException;
import org.ricone.api.client.request3.exception.MissingArgumentException;
import org.ricone.api.client.response.XResponse;
import org.ricone.api.client.response.model.XLea;
import org.ricone.api.client.response.model.XLeas;
import org.ricone.api.client.response.model.XStaff;
import org.ricone.api.client.response.model.XStaffs;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @project: client
 * @author: Dan on 6/28/2018.
 */
public class Test3 {
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

                //testXRequestBuilder(xPress);
                //testXRequestLastPageBuilder(xPress);
                //testXRequestIdBuilder(xPress);
                //testXRequestChangesSinceBuilder(xPress);
                testXRequestProvisioningBuilder(xPress);
            }
        }
        else {
            System.out.println("Auth Failed");
        }
    }

    private static void testXRequestBuilder(XPress xPress) throws MissingArgumentException, InvalidPathException {
        XRequest request = new XRequestBuilder(ServicePath.GET_XLEA_BY_REFID).id("5776DEB4-A6C8-43B1-AB08-CD5B95983177").build();
        XResponse<XLea> response = xPress.getXLea(request);
        System.out.println(response.getResponseStatus());
        System.out.println(response.getData().getRefId() + " - " + response.getData().getLeaName());
    }

    private static void testXRequestLastPageBuilder(XPress xPress) throws MissingArgumentException, InvalidPathException {
        XRequest request = new XRequestLastPageBuilder(ServicePath.GET_XCOURSES).pagingInfo(20).build();
        Integer response = xPress.getLastPage(request);
        System.out.println(response);
    }

    private static void testXRequestIdBuilder(XPress xPress) throws MissingArgumentException, InvalidPathException {
        XRequest request = new XRequestIdBuilder(ServicePath.GET_XLEA_BY_ID).id("111111130777").idType(IdType.BEDS).build();
        XResponse<XLea> response = xPress.getXLea(request);
        System.out.println(response.getResponseStatus());
        System.out.println(response.getData().getRefId() + " - " + response.getData().getLeaName());
    }

    private static void testXRequestChangesSinceBuilder(XPress xPress) throws MissingArgumentException, InvalidPathException {
        XRequest request = new XRequestChangesSinceBuilder(ServicePath.GET_XLEAS).changesSince(LocalDateTime.now()).build();
        XResponse<XLeas> response = xPress.getXLeas(request);
        System.out.println(response.getResponseStatus());
        for (XLea xLea : response.getData().getXLea()) {
            System.out.println(xLea.getRefId() + " - " + xLea.getLeaName());
        }
    }

    private static void testXRequestProvisioningBuilder(XPress xPress) throws MissingArgumentException, InvalidPathException {
        XRequest request = new XRequestProvisioningBuilder(ServicePath.GET_XSTAFFS_BY_XSCHOOL_REFID).id("114345B6-744B-43FE-9979-2BDC67EC273E").auppType(AUPPType.GET).build();
        XResponse<XStaffs> response = xPress.getXStaffs(request);
        System.out.println(response.getResponseStatus());
        for (XStaff xStaff : response.getData().getXStaff()) {
            System.out.println(xStaff.getRefId() + " - " + xStaff.getAppProvisioningInfo().getLoginId());
        }
    }
}
