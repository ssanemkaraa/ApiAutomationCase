package tests.negativeCases;

import io.qameta.allure.*;
import methods.EndpointsVerifyMethods;
import org.junit.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;

@Epic("This Epic includes endpoints with userId")
@Feature("Get, Patch, Put, Delete")

public class GuidFormatButCharacterTests {
    EndpointsVerifyMethods endpointsVerifyMethods;
    String id = "!!!!!!!!-!!!!-!!!!-!!!!-!!!!!!!!!!!!";

    public GuidFormatButCharacterTests() throws IOException {
        endpointsVerifyMethods = new EndpointsVerifyMethods();
    }

    @Story("GET - Get User By Id")
    @Description("This response includes one user with id,username,firstName,lastName,isActive keys")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void formatCharacterGuidGetUserById() {

        // Verify response failed
        assertFalse(endpointsVerifyMethods.verifyGetUserById(id));

    }

    @Story("PATCH - Switch User Activity")
    @Description("This response includes userId and isActive keys")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void formatCharacterGuidPatchUserActivity() {

        // Verify response failed
        assertFalse(endpointsVerifyMethods.verifyPatchUserActivity(id,true));

    }

    @Story("PUT - Update User Info")
    @Description("This response includes userId key")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void formatCharacterGuidPutUpdateUserInfo() {

        String firstName = "jane";
        String lastName = "doe";

        // Verify response failed
        assertFalse(endpointsVerifyMethods.verifyPutUpdateUserInfo(id,firstName,lastName));

    }

    @Story("DELETE - Remove User")
    @Description("This response just return status code")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void formatCharacterGuidDeleteUser() {

        // Verify response failed
        assertFalse(endpointsVerifyMethods.verifyDeleteUser(id));

    }
}