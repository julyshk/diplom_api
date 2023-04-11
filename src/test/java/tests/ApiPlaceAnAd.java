package tests;

import model.PlaceAnAdResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static specs.SpecDrom.requestSpecDrom;
import static specs.SpecDrom.responseSpecSuccessfulDrom;

public class ApiPlaceAnAd {

    @Test
    @DisplayName("Переход к заполнению формы подачи объявления")
    void placeAnAdSuccessfull() {
        step("Отправить запрос GET 'https://auto.drom.ru/ajax''", () -> {

            PlaceAnAdResponseModel userResponse = given(requestSpecDrom)
                    .when()
                    .get("/ajax/?mode=auto_markets_by_city&city_id=92&crossdomain_ajax_request=3")
                    .then()
                    .spec(responseSpecSuccessfulDrom)
                    .extract().as(PlaceAnAdResponseModel.class);

            assertThat(userResponse.getStatus()).isEqualTo("true");
            assertThat(userResponse.getFrom_cache()).isEqualTo("0");
            assertThat(userResponse.getMemkey()).isEqualTo("auto_markets_by_city-UTF8-C92");
        });
    }

    @Test
    @DisplayName("Ошибка при переходе к заполнению формы подачи объявления")
    void placeAnAdError() {
        step("Отправить запрос GET 'https://auto.drom.ru/ajax''", () -> {

            PlaceAnAdResponseModel userResponse = given(requestSpecDrom)
                    .when()
                    .get("/ajax/?mode=ajax_recognize_vin&frame=00000000000000000&crossdomain_ajax_request=3")
                    .then()
                    .spec(responseSpecSuccessfulDrom)
                    .extract().as(PlaceAnAdResponseModel.class);

            assertThat(userResponse.getStatus()).isEqualTo("false");
            assertThat(userResponse.getData()).isEqualTo(null);
            assertThat(userResponse.getError().getCode()).isEqualTo("103");
            assertThat(userResponse.getError().getMessage()).isEqualTo("Пожалуйста, введите ваш реальный VIN");
        });
    }
}
