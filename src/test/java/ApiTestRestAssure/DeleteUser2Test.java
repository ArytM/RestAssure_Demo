package ApiTestRestAssure;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class DeleteUser2Test {

    static {
        RestAssured.baseURI = "https://reqres.in/";
    }

    public static void main(String[] args) {
        delete2UserSC204(2);

}
    public static void delete2UserSC204(int userId){
    given()
            .contentType("application/json")
            .when()
            .delete("api/users/" + userId)
            .then()
            .statusCode(204);
        System.out.println("пользователь " + userId + " удален");

    }
}
