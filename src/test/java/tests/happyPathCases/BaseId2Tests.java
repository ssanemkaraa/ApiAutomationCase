package tests.happyPathCases;

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


public class BaseId2Tests {

    EndpointsMethods endpointsMethods;
    EndpointsVerifyMethods endpointsVerifyMethods;

    String id_2 = "c3e140a4-99db-44c2-a9ea-896904745993";


    public BaseId2Tests() throws IOException {
        endpointsMethods = new EndpointsMethods();
        endpointsVerifyMethods = new EndpointsVerifyMethods();
    }

    @Story("GET - List of User")
    @Description("This response includes all user with id,username,firstName,lastName,isActive keys")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void getUserListTest() {

        if (endpointsVerifyMethods.verifyGetUserList()) {

            Response response = endpointsMethods.getUserList();
            GetUserListModel[] users = response.as(GetUserListModel[].class);

            for (GetUserListModel user : users) {

                // Verify response model is not null
                assertNotNull(user.getid());
                assertNotNull(user.getFirstName());
                assertNotNull(user.getLastName());
                assertNotNull(user.getActive());

            }
        } else {
            System.out.println("Something went wrong!");
        }
    }

    @Story("GET - Get User By Id")
    @Description("This response includes one user with id,username,firstName,lastName,isActive keys")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void getUserById() {

        if (endpointsVerifyMethods.verifyGetUserById(id_2)) {

            Response response = endpointsMethods.getUserById(id_2);
            GetUserByIdModel user = response.as(GetUserByIdModel.class);

            // Verify response model is not null
            assertNotNull(user.getid());
            assertNotNull(user.getFirstName());
            assertNotNull(user.getLastName());
            assertNotNull(user.getActive());

        } else {
            System.out.println("Something went wrong!");
        }
    }

    @Story("POST - Create new user")
    @Description("This response includes one userId")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void postCreateUserTest() {

        String firstName = "jane";
        String lastName = "doe";
        String username = "doejj";
        String password = "123456Aa*";

        if (endpointsVerifyMethods.verifyPostCreateUser(firstName,lastName,username,password)) {

            Response response = endpointsMethods.postCreateUser(firstName,lastName,username,password);
            PostCreateUserModel user = response.as(PostCreateUserModel.class);

            // Verify response model is not null
            assertNotNull(user.getuserId());

            // -----------------------------------------------------------------------------------

            // Verify response id is created
            assertTrue(endpointsVerifyMethods.verifyGetUserById(user.getuserId()));

        } else {
            System.out.println("Something went wrong!");
        }

    }

    @Story("PATCH - Switch User Activity True")
    @Description("This response includes userId and isActive keys")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void patchUserActivityTrue() {

        if (endpointsVerifyMethods.verifyPatchUserActivity(id_2,true)) {

            Response response = endpointsMethods.patchUserActivity(id_2,true);
            PatchSwitchUserActivityModel user = response.as(PatchSwitchUserActivityModel.class);

            // Verify response model is not null
            assertNotNull(user.getUserId());
            assertNotNull(user.getActive());

            // -----------------------------------------------------------------------------------

            Response getUserByIdResponse = endpointsMethods.getUserById(id_2);
            GetUserByIdModel userDetailById = getUserByIdResponse.as(GetUserByIdModel.class);

            // Verify response model isActive: true
            assertEquals(userDetailById.getActive(), true);

        } else {
            System.out.println("Something went wrong!");
        }
    }

    @Story("PATCH - Switch User Activity False")
    @Description("This response includes userId and isActive keys")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void patchUserActivityFalse() {

        if (endpointsVerifyMethods.verifyPatchUserActivity(id_2,false)) {

            Response response = endpointsMethods.patchUserActivity(id_2,false);
            PatchSwitchUserActivityModel user = response.as(PatchSwitchUserActivityModel.class);

            // Verify response model is not null
            assertNotNull(user.getUserId());
            assertNotNull(user.getActive());

            // -----------------------------------------------------------------------------------

            Response getUserByIdResponse = endpointsMethods.getUserById(id_2);
            GetUserByIdModel userDetailById = getUserByIdResponse.as(GetUserByIdModel.class);

            // Verify response model isActive: false
            assertEquals(userDetailById.getActive(), false);

        } else {
            System.out.println("Something went wrong!");
        }
    }

    @Story("PUT - Update User Info")
    @Description("This response includes userId key")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void putUpdateUserInfo() {

        String firstName = "jane";
        String lastName = "doe";

        if (endpointsVerifyMethods.verifyPutUpdateUserInfo(id_2,firstName,lastName)) {

            Response response = endpointsMethods.putUpdateUserInfo(id_2, firstName, lastName);
            PutUpdateUserModel user = response.as(PutUpdateUserModel.class);

            // Verify response model is not null
            assertNotNull(user.getUserId());

            // -----------------------------------------------------------------------------------

            Response getUserByIdResponse = endpointsMethods.getUserById(id_2);
            GetUserByIdModel userDetailById = getUserByIdResponse.as(GetUserByIdModel.class);

            // Verify response model equal to sended data
            assertEquals(userDetailById.getFirstName(), firstName);
            assertEquals(userDetailById.getLastName(), lastName);

        } else {
            System.out.println("Something went wrong!");
        }
    }

    @Story("PUT - Update User Info 2")
    @Description("This response includes userId key")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void putUpdateUserInfo2() {
        String firstName = "test";
        String lastName = "test";

        if (endpointsVerifyMethods.verifyPutUpdateUserInfo(id_2,firstName,lastName)) {

            Response response = endpointsMethods.putUpdateUserInfo(id_2, firstName, lastName);
            PutUpdateUserModel user = response.as(PutUpdateUserModel.class);

            // Verify response model is not null
            assertNotNull(user.getUserId());

            // -----------------------------------------------------------------------------------

            Response getUserByIdResponse = endpointsMethods.getUserById(id_2);
            GetUserByIdModel userDetailById = getUserByIdResponse.as(GetUserByIdModel.class);

            // Verify response model equal to sended data
            assertEquals(userDetailById.getFirstName(), firstName);
            assertEquals(userDetailById.getLastName(), lastName);

        } else {
            System.out.println("Something went wrong!");
        }
    }

    @Story("DELETE - Remove User")
    @Description("This response just return status code")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void deleteUser() {

        if (endpointsVerifyMethods.verifyDeleteUser(id_2)) {

            // Verify user list has not deleted user
            assertFalse(endpointsVerifyMethods.verifyGetUserById(id_2));

        } else {
            System.out.println("Something went wrong!");
        }
    }
}