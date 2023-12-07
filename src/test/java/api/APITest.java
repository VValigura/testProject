package api;

import api.lombokModel.LoginDataModel;
import api.lombokModel.TokenDataModel;
import io.qameta.allure.restassured.AllureRestAssured;
import org.junit.jupiter.api.Test;

import static api.LoginSpec.loginRequestSpec;
import static api.LoginSpec.loginResponseSpec;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.assertj.core.api.Assertions.assertThat;

public class APITest {
    @Test
    public void logUnTest(){
        LoginDataModel loginDataModel = new LoginDataModel();
        loginDataModel.setEmail("eve.holt@reqres.in");
        loginDataModel.setPassword("cityslicka");

        TokenDataModel tokenDataModel =
                step("get authorization data", () -> given(loginRequestSpec)
                .body(loginDataModel)
                .when()
                .post("/login")
                .then()
                .spec(loginResponseSpec)
                .extract().as(TokenDataModel.class));

        step("verify response", () ->
                assertThat(tokenDataModel.getToken()).isEqualTo("QpwL5tke4Pnpja7X4"));

    }
}
