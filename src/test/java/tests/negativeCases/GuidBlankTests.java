package tests.negativeCases;

import io.qameta.allure.*;
import methods.EndpointsVerifyMethods;
import org.junit.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;

@Epic("This Epic includes endpoints with userId")
@Feature("Get, Patch, Put, Delete")

public class GuidBlankTests {
    EndpointsVerifyMethods endpointsVerifyMethods;
    String id = "";

    public GuidBlankTests() throws IOException {
        endpointsVerifyMethods = new EndpointsVerifyMethods();
    }

    @Story("GET - Get User By Id")
    @Description("This response includes one user with id,username,firstName,lastName,isActive keys")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void blankGuidGetUserById() {

        // Verify response failed
        assertFalse(endpointsVerifyMethods.verifyGetUserById(id));

    }

    @Story("PATCH - Switch User Activity")
    @Description("This response includes userId and isActive keys")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void blankGuidPatchUserActivity() {

        // Verify response failed
        assertFalse(endpointsVerifyMethods.verifyPatchUserActivity(id,true));

    }

    @Story("PUT - Update User Info")
    @Description("This response includes userId key")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void blankGuidPutUpdateUserInfo() {

        String firstName = "";
        String lastName = "";

        // Verify response failed
        assertFalse(endpointsVerifyMethods.verifyPutUpdateUserInfo(id,firstName,lastName));

    }

    @Story("DELETE - Remove User")
    @Description("This response just return status code")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void blankGuidDeleteUser() {

        // Verify response failed
        assertFalse(endpointsVerifyMethods.verifyDeleteUser(id));

    }
}