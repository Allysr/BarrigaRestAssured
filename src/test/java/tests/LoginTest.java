package tests;

import data.LoginData;
import utils.BaseTestes;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoginTest {

    @BeforeEach()
    public void test() {
        BaseTestes.setup();
    }

    @Test
    @DisplayName("Deve realizar o login com sucesso")
    public void deveRealizarLoginComSucesso(){
        LoginData login = new LoginData();

       RestAssured
                .given()
                    .body(login.loginUsuario())
                .when()
                    .post("signin")
                .then()
                    .statusCode(200);
    }

    @Test
    @DisplayName("Não deve realizar o login com sucesso")
    public void naoDeveRealizarLoginComSucesso(){
        LoginData login = new LoginData();

        RestAssured
                .given()
                    .body(login.loginIncorreto())
                .when()
                    .post("signin")
                .then()
                    .statusCode(400);

    }
}
