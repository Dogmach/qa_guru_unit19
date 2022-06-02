package tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;

public class BookstoreTests {
    @BeforeAll
    static void beforeAll() {
        RestAssured.baseURI = "https://demoqa.com/";
    }

    @Test
    void getBooksTest() {
        get("BookStore/v1/Books")
                .then()
                .body("books", hasSize(greaterThan(0)));
    }

    @Test
    void getBooksWithAllLogsTest() {
        given()
                .log().all()
                .when()
                .get("BookStore/v1/Books")
                .then()
                .log().all()
                .body("books", hasSize(greaterThan(0)));
    }

    @Test
    void getBooksWithSomeLogsTest1() {
        given()
                .log().uri()
                .log().body()
                .when()
                .get("BookStore/v1/Books")
                .then()
                .log().status()
                .log().body()
                .body("books", hasSize(greaterThan(0)));
    }
}
