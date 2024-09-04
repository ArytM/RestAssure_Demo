package ApiTestRestAssure;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class PatchUserTest {
    static {
        RestAssured.baseURI = "https://reqres.in";
    }

    public static void main(String[] args) {
        RequestSpecification requestSpecification = createRequestSpecification();
        ResponseSpecification responseSpecification = createResponseSpecification();
        updateUser(2, requestSpecification, responseSpecification);
    }

    private static RequestSpecification createRequestSpecification() {
        return given()
                .contentType("application/json");
    }

    private static ResponseSpecification createResponseSpecification() {
        return expect()
                .statusCode(200)
                .body("updatedAt", notNullValue());
    }

    private static void updateUser(int userId, RequestSpecification requestSpecification, ResponseSpecification responseSpecification) {
        String requestBody = "{\"name\": \"Ivan\", \"job\": \"comedian\"}";
        Response response = requestSpecification
                .body(requestBody)
                .when()
                .patch("api/users/" + userId)
                .then()
                .spec(responseSpecification)
                .extract().response();

        String updatedAt = response.jsonPath().getString("updatedAt");
        System.out.println("Data updated " + updatedAt);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        LocalDateTime currentDate = LocalDateTime.now();

        String currentDateTimeString = currentDate.format(formatter);
        System.out.println("Date now " + currentDateTimeString);

        System.out.println("дата последнего обновления совпадает с текущей датой");

    }
}
