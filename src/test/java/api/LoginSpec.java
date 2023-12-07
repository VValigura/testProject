package api;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.CoreMatchers.notNullValue;

public class LoginSpec {
    public static RequestSpecification loginRequestSpec =
           with()
            .filter(new AllureRestAssured())
            .log().uri()
            .log().headers()
            .log().body()
            .contentType(JSON)
            .baseUri("https://reqres.in/api");

    public static ResponseSpecification loginResponseSpec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .expectBody("token", notNullValue())
            .build();
}
