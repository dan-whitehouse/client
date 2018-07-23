package org.ricone.api.client;

import org.ricone.api.client.authentication.Authenticator;
import org.ricone.api.client.authentication.Endpoint;
import org.ricone.api.client.request.*;
import org.ricone.api.client.request.exception.InvalidPathException;
import org.ricone.api.client.request.exception.MissingArgumentException;
import org.ricone.api.client.response.XResponse;
import org.ricone.api.client.response.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @project: client
 * @author: Dan on 6/28/2018.
 */
public class Test {
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

                //getInvalidPathException();
                //getChangesSinceException();

                getXLeaById(xPress);
                //getXLea(xPress);
                //getXLeas(xPress);
                //getXLeasWithPaging(xPress);
                //getXSchools(xPress);
                //getXStaffsAUPP(xPress);
            }
        }
        else {
            System.out.println("Authentication Failed");
        }
    }


    private static void getInvalidPathException() throws InvalidPathException, MissingArgumentException {
        XPressRequestID request = new XPressRequestID.Builder(ServicePath.GET_XLEAS_BY_XSCHOOL_REFID).build();
    }

    private static void getMissingArgumentException() throws InvalidPathException, MissingArgumentException {
        XPressRequest request = new XPressRequest.Builder(ServicePath.GET_XLEA_BY_REFID).build();
    }

    private static void getXLeaById(XPress xPress) throws MissingArgumentException, InvalidPathException {
        XPressRequestID request = new XPressRequestID.Builder(ServicePath.GET_XLEA_BY_ID).id("111111130777").idType(IdType.STATE).build();
        XResponse<XLea> response = xPress.getXLea(request);
        System.out.println(response.getRequestPath());
        System.out.println(response.getRequestHeaders());
        System.out.println(response.getResponseStatus() + " " + response.getResponseStatusText());
        System.out.println(response.getResponseHeaders());

        System.out.println(response.getData());
        System.out.println(response.getJSON());
    }

    private static void getXLea(XPress xPress) throws InvalidPathException, MissingArgumentException {
        //Example Basic Requests
        XPressRequest request = new XPressRequest.Builder(ServicePath.GET_XLEA_BY_REFID).refId("5776DEB4-A6C8-43B1-AB08-CD5B95983177").build();
        //XLeaResponse response = xPress.getXLea(request);
        //System.out.println(response.getXLea().getRefId() + " - " + response.getXLea().getLeaName());

        //System.out.println("-----------");

        XResponse<XLea> response1 = xPress.getXLea(request);
        //System.out.println(response1.getData().getRefId() + " - " + response1.getData().getLeaName());
        //System.out.println(response1.getJSON());
        //System.out.println(response1.getXML());

        //System.out.println("-----------");
    }

    private static void getXLeas(XPress xPress) throws InvalidPathException, MissingArgumentException {
        //Example Basic Requests
        XPressRequest request = new XPressRequest.Builder(ServicePath.GET_XLEAS).build();

        XResponse<XLeas> response = xPress.getXLeas(request);
        for (XLea xLea : response.getData().getXLea()) {
            //System.out.println(xLea.getRefId() + " - " + xLea.getLeaName());
        }
        //System.out.println(response.getJSON());
        //System.out.println(response.getXML());
        //System.out.println("-----------");

        XResponse<XLeas> response2 = xPress.getXLeas(request);
        for (XLea xLea : response2.getData().getXLea()) {
            //System.out.println(xLea.getRefId() + " - " + xLea.getLeaName());
        }
        //System.out.println(response.getJSON());
        //System.out.println(response.getXML());
        //System.out.println("-----------");
    }

    private static void getXLeasWithPaging(XPress xPress) throws InvalidPathException, MissingArgumentException {
        //Example Basic Request With Paging
        int pageSize = 2;
        int lastPage = xPress.getLastPage(new XPressRequestLastPage.Builder(ServicePath.GET_XLEAS).pagingInfo(1, pageSize).build());

        List<XLea> xLeas = new ArrayList<>();
        for (int pageNumber = 1; pageNumber <= lastPage; pageNumber++) {
            XPressRequest request = new XPressRequest.Builder(ServicePath.GET_XLEAS).pagingInfo(pageNumber, pageSize).build();
            XResponse<XLeas> response = xPress.getXLeas(request);

            if(response != null) {
                //System.out.println(response.getJSON());
                xLeas.addAll(response.getData().getXLea());
            }
        }

        for (XLea xLea : xLeas) {
            //System.out.println(xLea.getRefId() + " - " + xLea.getLeaName());
        }
        //System.out.println("-----------");
    }

    private static void getXSchools(XPress xPress) throws InvalidPathException, MissingArgumentException {
        //Example Basic Requests
        XPressRequest request = new XPressRequest.Builder(ServicePath.GET_XSCHOOLS).pagingInfo(1, 2).build();

        XResponse<XSchools> response = xPress.getXSchools(request);
        for (XSchool instance : response.getData().getXSchool()) {
            //System.out.println(instance.getRefId() + " - " + instance.getSchoolName());
        }
        //System.out.println(response.getResponseStatus().value());
        //System.out.println(response.getJSON());
        //System.out.println(response.getXML());
        //System.out.println("-----------");
    }


    public static void getXStaffsAUPP(XPress xPress) throws InvalidPathException, MissingArgumentException {
        XPressRequestAUPP request = new XPressRequestAUPP.Builder(ServicePath.GET_XSTAFFS_BY_XSCHOOL_REFID).refId("114345B6-744B-43FE-9979-2BDC67EC273E").auppType(AUPPType.GET).build();
        XResponse<XStaffs> response = xPress.getXStaffs(request);
        for (XStaff instance : response.getData().getXStaff()) {
            //System.out.println(instance.getRefId() + " - " + instance.getAppProvisioningInfo().getLoginId());
        }
        //System.out.println(response.getJSON());
        //System.out.println(response.getXML());
    }
}
