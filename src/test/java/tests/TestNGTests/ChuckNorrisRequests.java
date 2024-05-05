package tests.TestNGTests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.annotations.Test;


import java.util.Random;

public class ChuckNorrisRequests {
    private static final Logger LOGGER = (Logger) LogManager.getLogger(ChuckNorrisRequests.class);

    RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri("https://api.chucknorris.io/jokes")
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    @Test
    public void randomJoke() {
        String chuckNorrisRandomJoke = RestAssured
                .given()
                .spec(requestSpec)
                .when()
                .get("/random")
                .then()
                .extract().body().asString();
        LOGGER.info(chuckNorrisRandomJoke);
    }

    @Test
    public void jokesCategoriesList() {
        String chuckNorrisJokesCategoriesList = RestAssured
                .given()
                .spec(requestSpec)
                .when()
                .get("/categories")
                .then()
                .extract().body().asString();
        LOGGER.info(chuckNorrisJokesCategoriesList);
        int chuckNorrisJokesCategoriesListLength = chuckNorrisJokesCategoriesList.length();

        String convert1 = chuckNorrisJokesCategoriesList.substring(2, chuckNorrisJokesCategoriesListLength - 2);

        String[] jokeCategories = convert1.split("\",\"");
        Random rand = new Random();
        int n = rand.nextInt(jokeCategories.length);
        String category = jokeCategories[n];

        String chuckNorrisJokeFromRandomCategory = RestAssured
                .given()
                .spec(requestSpec)
                .param("category", category)
                .when()
                .get("/random")
                .then()
                .extract().body().asString();
        LOGGER.info(chuckNorrisJokeFromRandomCategory);
    }
    @Test
    public void freeTextSearch() {
        String freeTextSearchForJoke = RestAssured
                .given()
                .spec(requestSpec)
                .param("query", "shoe")
                .when()
                .get("/search")
                .then()
                .extract().body().asString();
        LOGGER.info(freeTextSearchForJoke);
    }
}
