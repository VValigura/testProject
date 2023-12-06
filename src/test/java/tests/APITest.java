package tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.CoreMatchers.is;

public class APITest {
    @Test
    public void logUnTest(){

        String bodyEmailAndPass = "{ \"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\" }";

        given()
                .contentType(JSON)
                .body(bodyEmailAndPass)
                .log().uri()
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .log().body()
                .body("token", is("QpwL5tke4Pnpja7X4"));
    }
}
