package utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import org.hamcrest.Matchers;

public class BaseTestes implements Constantes {
    public static void setup(){
        System.out.println("Passou aqui");
        RestAssured.baseURI = url;
        RestAssured.port = 443;

        RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
        reqBuilder.setContentType(contentType);
        RestAssured.requestSpecification = reqBuilder.build();

        ResponseSpecBuilder resBuilder = new ResponseSpecBuilder();
        resBuilder.expectResponseTime(Matchers.lessThan(maxTimeOut));
        RestAssured.responseSpecification = resBuilder.build();


        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

    }
}
