package ApiTestRestAssure;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.core.Every.everyItem;

public class UserTest {
    static {
        RestAssured.baseURI = "https://reqres.in/";
    }

    public static void main(String[] args) {
        testGiveUser();
    }

    public static void testGiveUser(){
        given()
                .contentType("application/json")
                .when()
                .get("/api/users?page=2")
                .then()
                .statusCode(200)
                .body("data.email", everyItem(endsWith("@reqres.in")))
                .log().all();
        System.out.println("все окончания: @reqres.in");
    }
}
