package utils.restassured;

import org.hamcrest.core.Is;

import static org.hamcrest.Matchers.is;

import model.User;

import static io.restassured.RestAssured.given;

public class RestAssuredUtils {

    public static void post(Object body, int expectedStatus, String expectedField, String expectedValue) {
        given()
            .body(body)
        .when()
            .post()
        .then()
            .statusCode(expectedStatus)
            .body(expectedField, is(expectedValue));
    }

    public static User get(String paramName, String paramValue) {
        return given()
                     .param(paramName, paramValue)
                .when()
                    .get()
                        .as(User.class);
    }

    public static void put(Object body, int expectedStatus, String expectedField, String expectedValue) {
        given()
            .body(body)
        .when()
            .put()
        .then()
            .statusCode(expectedStatus)
            .body(expectedField, Is.is(expectedValue));
    }

    public static void delete(String paramName, String paramValue, String expectedField, String expectedValue) {
        given()
            .param(paramName, paramValue)
        .when()
            .delete()
        .then()
            .statusCode(200)
            .body(expectedField, is(expectedValue));
    }
}
