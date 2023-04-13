package tests;

import model.AddToFaforiteResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static specs.SpecDrom.*;

public class ApiSearchCar {

    @Test
    @DisplayName("Проверка запроса поиска всех автомобилей")
    void searchAllCar() {
        step("Отправить запрос GET 'https://auto.drom.ru/all'", () -> {

            given(requestSpecDrom)
                    .log().uri()
                    .when()
                    .get("/all")
                    .then()
                    .spec(responseSpecSuccessfulDrom);
        });
    }

    @Test
    @DisplayName("Добавление объявления о продаже автомобиля в избранное")
    void addToFavorites() {
        step("Отправить запрос POST 'https://www.drom.ru/api/sales/bull/favorite/add'", () -> {

            AddToFaforiteResponseModel userResponse = given(requestSpecDromSale)
                    .log().uri()
                    .when()
                    .post("/api/sales/bull/favorite/add?bull_id=49072502")
                    .then()
                    .spec(responseSpecSuccessfulDrom)
                    .extract().as(AddToFaforiteResponseModel.class);

                    assertThat(userResponse.getStatus()).isEqualTo("true");
                    assertThat(userResponse.getCode()).isEqualTo("0");
                    assertThat(userResponse.getResult().getMessage()).isEqualTo("ok");
        });
    }

    @Test
    @DisplayName("Удаление объявления о продаже автомобиля из избранного")
    void removeFromFavorites() {
        step("Отправить запрос POST 'https://www.drom.ru/api/sales/bull/favorite/delete", () -> {

            AddToFaforiteResponseModel userResponse = given(requestSpecDromSale)
                    .log().uri()
                    .when()
                    .post("/api/sales/bull/favorite/delete?bull_id=50332627")
                    .then()
                    .spec(responseSpecSuccessfulDrom)
                    .extract().as(AddToFaforiteResponseModel.class);

            assertThat(userResponse.getStatus()).isEqualTo("true");
            assertThat(userResponse.getCode()).isEqualTo("0");
            assertThat(userResponse.getResult().getMessage()).isEqualTo("ok");
        });
    }

}

