package methods;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.Utils;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class EndpointsMethods {
    private Utils utils;

    public EndpointsMethods() throws IOException {
        utils = new Utils();
        RestAssured.baseURI = utils.readUrlFromFile();
    }

    public Response getUserList() {
        return
                given()
                        .contentType("application/json")
                        .when()
                        .get("/users")
                        .then()
                        .assertThat()
                        .statusCode(200)
                        .extract().response();
    }

    public Response postCreateUser() {
        return
                given()
                        .body("")
                        .when()
                        .post("/users")
                        .then()
                        .assertThat()
                        .statusCode(200)
                        .extract().response();
    }

    public Response getUserById(String userId) {
        return
                given()
                        .contentType("application/json")
                        .when()
                        .get("/users/" + userId)
                        .then()
                        .assertThat()
                        .statusCode(200)
                        .extract().response();
    }

    public Response deleteUser(String userId) {
        return
                given()
                        .contentType("application/json")
                        .when()
                        .delete("/users/" + userId)
                        .then()
                        .assertThat()
                        .statusCode(200)
                        .extract().response();
    }

    public Response patchUserActivity(String userId) {
            return
                    given()
                    .contentType("application/json")
                    .body("{\r\n    \"isActive\": true\r\n}")
                    .when()
                    .patch("/users/" + userId + "/activity")
                    .then()
                    .assertThat()
                    .statusCode(200)
                    .extract().response();
    }


    public Response putUpdateUserInfo(String userId) {
        return
                given()
                .contentType("application/json")
                .body("{\r\n    \"firstName\" : \"jane\",\r\n    \"lastName\" : \"doe\"\r\n}")
                .when()
                .put("/users/"+userId)
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response();
    }
}
