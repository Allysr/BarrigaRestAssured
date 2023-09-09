package tests;

import data.MovimentacaoData;
import utils.BaseTestes;
import utils.Login;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MovimentacoesTest {

    @BeforeEach()
    public void test() {
        BaseTestes.setup();
        Login.token();
    }

    @Test
    @DisplayName("Deve inserir movimentação com sucesso.")
    public void deveInserirMovimentacaoComSucesso(){
        MovimentacaoData movimentacao = new MovimentacaoData();

        RestAssured
                .given()
                .body(movimentacao.novaMovimentacao())
                .when()
                .post("transacoes")
                .then()
                .statusCode(201);
    }

    @Test
    @DisplayName("Não deve inserir movimentação sem conteudo.")
    public void naoDeveInserirMovimentacaoSemConteudo(){
        RestAssured
                .given()
                .body("{}")
                .when()
                .post("transacoes")
                .then()
                .statusCode(400);
    }
}
