package tests.negativeCases;

import io.qameta.allure.*;
import io.restassured.response.Response;
import methods.EndpointsMethods;
import methods.EndpointsVerifyMethods;
import models.*;
import org.junit.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@Epic("This Epic includes all of endpoints")
@Feature("Get, Post, Patch, Put, Delete")


public class BlankBodyTests {


    EndpointsMethods endpointsMethods;
    EndpointsVerifyMethods endpointsVerifyMethods;

    String id_1 = "c4f6c088-f91b-494e-b7f0-a08f48df3180";
    String id_2 = "c3e140a4-99db-44c2-a9ea-896904745993";
    String firstName = "";
    String lastName = "";
    String username = "";
    String password = "";


    public BlankBodyTests() throws IOException {
        endpointsMethods = new EndpointsMethods();
        endpointsVerifyMethods = new EndpointsVerifyMethods();
    }


    @Story("POST - Create new user")
    @Description("This response includes one userId")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void postCreateUserTest() {

        assertFalse(endpointsVerifyMethods.verifyPostCreateUser(firstName, lastName, username, password));

    }

    @Story("PUT - Update User Info")
    @Description("This response includes userId key")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void putUpdateUserInfo() {

        assertFalse(endpointsVerifyMethods.verifyPutUpdateUserInfo(id_1, firstName, lastName));

    }

    @Story("PUT - Update User Info 2")
    @Description("This response includes userId key")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void putUpdateUserInfo2() {
        assertFalse(endpointsVerifyMethods.verifyPutUpdateUserInfo(id_2, firstName, lastName));
    }

}