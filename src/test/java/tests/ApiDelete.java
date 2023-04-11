package tests;

import model.DeleteResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static specs.SpecDrom.*;

public class ApiDelete {

    @Test
    @DisplayName("Проверка запроса поиска всех автомобилей'")
    void searchAllCar() {
        step("Отправить запрос GET 'https://auto.drom.ru/all'", () -> {

            DeleteResponseModel userResponse = given(requestSpecDelete)
                    .log().uri()
                    .when()
                    .get("/users/2")
                    .then()
                    .spec(responseSpecDelete)
                    .extract().as(DeleteResponseModel.class);

            assertThat(userResponse.getData().getId()).isEqualTo("2");
            assertThat(userResponse.getData().getEmail()).isEqualTo("janet.weaver@reqres.in");
            assertThat(userResponse.getData().getFirst_name()).isEqualTo("Janet");
            assertThat(userResponse.getData().getLast_name()).isEqualTo("Weaver");
            assertThat(userResponse.getData().getAvatar()).isEqualTo("https://reqres.in/img/faces/2-image.jpg");
            assertThat(userResponse.getSupport().getUrl()).isEqualTo("https://reqres.in/#support-heading");
            assertThat(userResponse.getSupport().getText()).isEqualTo("To keep ReqRes free, contributions towards server costs are appreciated!");
        });
    }

}
