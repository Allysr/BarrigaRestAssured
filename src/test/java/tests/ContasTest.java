package tests;

import data.ContaData;
import utils.BaseTestes;
import utils.Login;
import io.restassured.RestAssured;
import io.restassured.specification.FilterableRequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ContasTest extends BaseTestes {

    private static Integer idConta;

    @BeforeEach()
    public void test() {
        BaseTestes.setup();
        Login.token();
    }

    @Test
    @DisplayName("Não deve acessar a Api sem Token")
    public void naoDeveAcessarApiSemToken(){
        FilterableRequestSpecification req = (FilterableRequestSpecification) RestAssured.requestSpecification;
        req.removeHeader("Authorization");

        RestAssured
                .given()
                .when()
                .get("contas")
                .then()
                .statusCode(401);
    }

    @Test
    @DisplayName("Deve acessar a Api com sucesso")
    public void deveAcessarApiComToken(){

        RestAssured
                .given()
                .when()
                .get("contas")
                .then()
                .statusCode(200);
    }
    @Test
    @DisplayName("Não deve cadastrar uma conta com nome existente")
    public void naoDeveCadastrarContaComNomeExistente(){
        ContaData conta = new ContaData();

        RestAssured
                .given()
                .body(conta.contaFixa())
                .when()
                .post("contas")
                .then()
                .statusCode(400);
    }

    @Test
    @DisplayName("Deve inserir a conta com sucesso")
    public void deveInserirContaComSucesso(){
        ContaData conta = new ContaData();

        idConta = RestAssured
                .given()
                .body(conta.contaReutilizavel())
                .when()
                .post("contas")
                .then()
                .statusCode(201)
                .extract()
                .path("id");
    }

    @Test
    @DisplayName("Deve atualizar a conta com sucesso")
    public void deveAtualizarContaExistenteComSucesso(){
        ContaData conta = new ContaData();


        RestAssured
                .given()
                .pathParam("id", idConta)
                .body(conta.contaAtualizada())
                .when()
                .put("contas/{id}")
                .then()
                .statusCode(200);
    }


}


