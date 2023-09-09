package utils;

import io.restassured.RestAssured;


public class Login {
    public static void token(){
        entities.Login login = new entities.Login();
        login.setEmail("alicia@email.com");
        login.setSenha("senha123");

        String token = RestAssured
                .given()
                .body(login)
                .when()
                .post("signin")
                .then()
                .statusCode(200)
                .extract()
                .path("token");

        RestAssured.requestSpecification.header("Authorization", "JWT " + token);
    }
}
