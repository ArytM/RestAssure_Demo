package ApiTestRestAssure;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class RegistrationTests {
    static {
        RestAssured.baseURI = "https://reqres.in/";
    }

    public static void main(String[] args) {
        testSuccessfulRegistration();
        testFailRegistration400();
    }

    public static void testSuccessfulRegistration() {
        given()
                .contentType("application/json")
                .body("{\"email\": \"eve.holt@reqres.in\", \"password\": \"pistol\"}")
                .when()
                .post("api/register")
                .then()
                .statusCode(200)
                .body("id", notNullValue())
                .body("token", notNullValue());
        System.out.println("успешная регистрация с валидными данными");
        System.out.println();
    }

    public static void testFailRegistration400() {
        given()
                .contentType("application/json")
                .body("{\"email\": \"eve.holt@reqres.in\"}")
                .when()
                .post("api/register")
                .then()
                .statusCode(400)
                .body("error", equalTo("Missing password"));
        System.out.println("Регистрация с ошибкой из-за отсутствия пароля, статус-код в ответе 400");
    }
}