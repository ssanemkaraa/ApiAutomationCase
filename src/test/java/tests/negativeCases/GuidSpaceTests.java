package tests.negativeCases;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import methods.EndpointsVerifyMethods;
import org.junit.Test;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

@Epic("All tests for User")
@Feature("User Post Request")

public class GuidSpaceTests {
    EndpointsVerifyMethods endpointsVerifyMethods;
    String id = " ";

    public GuidSpaceTests() throws IOException {
        endpointsVerifyMethods = new EndpointsVerifyMethods();
    }

    @Story("All of user")
    @Description("This request includes all of user")
    @Test
    public void spaceGuidGetUserById() {

        assertFalse(endpointsVerifyMethods.verifyGetUserById(id));
    }

    @Story("All of user")
    @Description("This request includes all of user")
    @Test
    public void spaceGuidPatchUserActivity() {

        assertFalse(endpointsVerifyMethods.verifyPatchUserActivity(id));
    }

    @Story("All of user")
    @Description("This request includes all of user")
    @Test
    public void spaceGuidPutUpdateUserInfo() {

        assertFalse(endpointsVerifyMethods.verifyPutUpdateUserInfo(id));

    }

    @Story("All of user")
    @Description("This request includes all of user")
    @Test
    public void spaceGuidDeleteUser() {

        assertFalse(endpointsVerifyMethods.verifyDeleteUser(id));
    }
}