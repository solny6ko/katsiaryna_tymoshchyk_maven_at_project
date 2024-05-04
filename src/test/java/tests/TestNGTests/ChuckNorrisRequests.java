package tests.TestNGTests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.annotations.Test;
import tests.BaseStepsTestNG;

public class ChuckNorrisRequests {
    private static final Logger LOGGER = (Logger) LogManager.getLogger(ChuckNorrisRequests.class);

        RequestSpecification requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://api.chucknorris.io/jokes/random")
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();

        @Test
                public void randomJoke(){
            String chuckNorrisRandomJoke = RestAssured
                    .given()
                    .spec(requestSpec)
                    .when()
                    .get()
                    .then()
                    .extract().body().asString();
            LOGGER.info(chuckNorrisRandomJoke);
        }


}
