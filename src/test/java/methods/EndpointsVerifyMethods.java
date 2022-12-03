package methods;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.Utils;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class EndpointsVerifyMethods {
    private Utils utils;

    public EndpointsVerifyMethods() throws IOException {
        utils = new Utils();
        RestAssured.baseURI = utils.readUrlFromFile();
    }

    public Boolean verifyGetUserList() {
        try {
            given()
                    .contentType("application/json")
                    .when()
                    .get("/users")
                    .then()
                    .assertThat()
                    .statusCode(200)
                    .extract().response();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public Boolean verifyPostCreateUser() {
        try {
            given()
                    .body("")
                    .when()
                    .post("/users")
                    .then()
                    .assertThat()
                    .statusCode(200)
                    .extract().response();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public Boolean verifyGetUserById(String userId) {
        try {
            given()
                    .contentType("application/json")
                    .when()
                    .get("/users/" + userId)
                    .then()
                    .assertThat()
                    .statusCode(200)
                    .extract().response();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean verifyDeleteUser(String userId) {
        try {
            given()
                    .contentType("application/json")
                    .when()
                    .delete("/users/" + userId)
                    .then()
                    .assertThat()
                    .statusCode(200)
                    .extract().response();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean verifyPatchUserActivity(String userId) {
        try {
            given()
                    .contentType("application/json")
                    .body("{\r\n    \"isActive\": true\r\n}")
                    .when()
                    .patch("/users/" + userId + "/activity")
                    .then()
                    .assertThat()
                    .statusCode(200)
                    .extract().response();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean verifyPutUpdateUserInfo(String userId) {
        try {
            given()
                    .contentType("application/json")
                    .body("{\r\n    \"firstName\" : \"jane\",\r\n    \"lastName\" : \"doe\"\r\n}")
                    .when()
                    .put("/users/" + userId)
                    .then()
                    .assertThat()
                    .statusCode(200)
                    .extract().response();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
