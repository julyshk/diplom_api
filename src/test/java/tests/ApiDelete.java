package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static specs.SpecDrom.*;

public class ApiDelete {

    @Test
    @DisplayName("Проверка запроса удаления пользователя")
    void searchAllCar() {
        step("Отправить запрос GET 'https://reqres.in/api/users/2'", () -> {

            given(requestSpecDelete)
                    .log().uri()
                    .when()
                    .delete("/users/2")
                    .then()
                    .spec(responseSpecDelete);
        });
    }

}
