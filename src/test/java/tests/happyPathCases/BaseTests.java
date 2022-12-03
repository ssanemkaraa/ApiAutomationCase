package tests.happyPathCases;

import io.qameta.allure.*;
import io.restassured.response.Response;
import methods.EndpointsMethods;
import methods.EndpointsVerifyMethods;
import models.*;
import org.junit.*;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

@Epic("All tests for User")
@Feature("User Post Request")


public class BaseTests {


    EndpointsMethods endpointsMethods;
    EndpointsVerifyMethods endpointsVerifyMethods;

    String id_1 = "c4f6c088-f91b-494e-b7f0-a08f48df3180";

    //String id_2 = "c3e140a4-99db-44c2-a9ea-896904745993";

    //String idUserModel = endpointsMethods.postCreateUser().as(UserActivityModel.class).getUserId();


    public BaseTests() throws IOException {
        endpointsMethods = new EndpointsMethods();
        endpointsVerifyMethods = new EndpointsVerifyMethods();
    }

    @Story("All of user")
    @Description("This request includes all of user")
    @Test
    public void getUserListTest() {

        if (endpointsVerifyMethods.verifyGetUserList()) {

            Response response = endpointsMethods.getUserList();
            GetUserListModel[] users = response.as(GetUserListModel[].class);

            for (GetUserListModel user : users) {
                assertNotNull(user.getid());
                assertNotNull(user.getFirstName());
                assertNotNull(user.getLastName());
                assertNotNull(user.getActive());
            }
        }
        else{
            System.out.println("Something went wrong!");
        }
    }

    @Story("List of UserName")
    @Description("This request includes userNames")
    @Test
    public void getUserById() {

        if (endpointsVerifyMethods.verifyGetUserById(id_1)) {

            Response response = endpointsMethods.getUserById(id_1);
            GetUserByIdModel user = response.as(GetUserByIdModel.class);

            assertNotNull(user.getid());
            assertNotNull(user.getFirstName());
            assertNotNull(user.getLastName());
            assertNotNull(user.getActive());
        }
        else{
            System.out.println("Something went wrong!");
        }
    }

    @Story("List of UserName")
    @Description("This request includes userNames")
    @Test
    public void postCreateUserTest() {

        if (endpointsVerifyMethods.verifyPostCreateUser()) {
            Response response = endpointsMethods.postCreateUser();
            PostCreateUserModel user = response.as(PostCreateUserModel.class);
            assertNotNull(user.getuserId());
        }
        else{
            System.out.println("Something went wrong!");
        }

    }

    @Story("List of UserName")
    @Description("This request includes userNames")
    @Test
    public void patchUserActivity() {

        if (endpointsVerifyMethods.verifyPatchUserActivity(id_1)) {
            Response response = endpointsMethods.patchUserActivity(id_1);
            PatchSwitchUserActivityModel user = response.as(PatchSwitchUserActivityModel.class);

            assertNotNull(user.getUserId());
            assertNotNull(user.getActive());
        }
        else{
            System.out.println("Something went wrong!");
        }
    }

    @Story("List of UserName")
    @Description("This request includes userNames")
    @Test
    public void putUpdateUserInfo() {

        if (endpointsVerifyMethods.verifyPutUpdateUserInfo(id_1)) {

            Response response = endpointsMethods.putUpdateUserInfo(id_1);
            PutUpdateUserModel user = response.as(PutUpdateUserModel.class);

            assertNotNull(user.getUserId());
        }
        else{
            System.out.println("Something went wrong!");
        }
    }

    @Story("List of UserName")
    @Description("This request includes userNames")
    @Test
    public void deleteUser() {

        if (endpointsVerifyMethods.verifyDeleteUser(id_1)) {
            endpointsMethods.deleteUser(id_1);
        }
        else{
            System.out.println("Something went wrong!");
        }
    }
}