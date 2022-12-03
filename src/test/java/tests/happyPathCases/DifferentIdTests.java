package tests.happyPathCases;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import methods.EndpointsMethods;
import methods.EndpointsVerifyMethods;
import models.GetUserByIdModel;
import models.GetUserListModel;
import models.PatchSwitchUserActivityModel;
import models.PutUpdateUserModel;
import org.junit.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Epic("All tests for User")
@Feature("User Post Request")

public class DifferentIdTests {
    EndpointsMethods endpointsMethods;
    EndpointsVerifyMethods endpointsVerifyMethods;

    String id_2 = "c3e140a4-99db-44c2-a9ea-896904745993";


    public DifferentIdTests() throws IOException {
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

    @Story("All of user")
    @Description("This request includes all of user")
    @Test
    public void getUserById() {

        if (endpointsVerifyMethods.verifyGetUserById(id_2)) {

            Response response = endpointsMethods.getUserById(id_2);
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

    @Story("All of user")
    @Description("This request includes all of user")
    @Test
    public void patchUserActivity() {

        if (endpointsVerifyMethods.verifyPatchUserActivity(id_2)) {
            Response response = endpointsMethods.patchUserActivity(id_2);
            PatchSwitchUserActivityModel user = response.as(PatchSwitchUserActivityModel.class);

            assertNotNull(user.getUserId());
            assertNotNull(user.getActive());
        }
        else{
            System.out.println("Something went wrong!");
        }
    }

    @Story("All of user")
    @Description("This request includes all of user")
    @Test
    public void putUpdateUserInfo() {

        if (endpointsVerifyMethods.verifyPutUpdateUserInfo(id_2)) {

            Response response = endpointsMethods.putUpdateUserInfo(id_2);
            PutUpdateUserModel user = response.as(PutUpdateUserModel.class);

            assertNotNull(user.getUserId());
        }
        else{
            System.out.println("Something went wrong!");
        }
    }

    @Story("All of user")
    @Description("This request includes all of user")
    @Test
    public void deleteUser() {

        if (endpointsVerifyMethods.verifyDeleteUser(id_2)) {
            endpointsMethods.deleteUser(id_2);
        }
        else{
            System.out.println("Something went wrong!");
        }
    }
}