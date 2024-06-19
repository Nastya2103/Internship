package API;

import API.Specifications;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.equalTo;

public class LIB2_3806_GetProduct {
    private final static String URL = "http://172.17.1.79:30303";

    @Test(testName = "Проверка ответа. Валидный productTypeId")
    public void testGetFields() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOk200());
        given()
                .when()
                .get("/card-service/api/v1/card-products/1edb77c4-b6ac-4562-af4d-fbd6fb78ec34")
                .then().log().all()
                .assertThat().body("id", equalTo("1edb77c4-b6ac-4562-af4d-fbd6fb78ec34"))
                .assertThat().body("typeName", equalTo("Liberty Card Classic"))
                .assertThat().body("paymentSystem", equalTo("MIR"))
                .assertThat().body("credit", equalTo(false))
                .assertThat().body("active", equalTo(true))
                .assertThat().body("transferFee.ourClient", notNullValue())
                .assertThat().body("transferFee.partnerClient", notNullValue())
                .assertThat().body("transferFee.anotherClientRu", notNullValue())
                .assertThat().body("transferFee.anotherClientWorld", notNullValue())
                .assertThat().body("transferFee.onBankAccount", notNullValue())
                .assertThat().body("transferFee.byPhoneNumber", notNullValue())
                .assertThat().body("transferFee.minFeeWorld", notNullValue())
                .assertThat().body("withdrawalCashFee.ourBank", notNullValue())
                .assertThat().body("withdrawalCashFee.partnersBank", notNullValue())
                .assertThat().body("withdrawalCashFee.anotherBankRu", notNullValue())
                .assertThat().body("withdrawalCashFee.anotherBankWorld", notNullValue())
                .assertThat().body("withdrawalCashFee.minCashFeeWorld", notNullValue())
                .assertThat().body("costPerMonth", notNullValue())
                .assertThat().body("freeCostFrom", notNullValue())
                .assertThat().body("servicePrice", notNullValue())
                .assertThat().body("cardReissue", notNullValue())
                .assertThat().body("addCardCost", notNullValue())
                .assertThat().body("virtual", equalTo(false))
                .assertThat().body("productLimit.operationPerDayMax", notNullValue())
                .assertThat().body("productLimit.operationPerMonthMax", notNullValue())
                .assertThat().body("productLimit.amountPerOperationMax", notNullValue())
                .assertThat().body("productLimit.amountPerDayMax", notNullValue())
                .assertThat().body("productLimit.amountPerMonthMax", notNullValue())
                .assertThat().body("productLimit.withdrawalCashPerDay", notNullValue())
                .assertThat().body("cashback.interestPerMonth", notNullValue())
                .assertThat().body("cashback.interestForAll", notNullValue())
                .assertThat().body("cashback.interestForPartners", notNullValue())
                .assertThat().body("cashback.cashbackLimit", notNullValue())
                .assertThat().body("bonusProgram.partnersBonus", equalTo(false))
                .assertThat().body("bonusProgram.bestExchangeRate", equalTo(false))
                .assertThat().body("level", equalTo("Classic"))
                .assertThat().body("currency", equalTo("RUB"))
                .assertThat().body("validityTerm", equalTo(60))
                .assertThat().body("oneUse", equalTo(false))
                .extract().response();
    }

    @Test(testName = "Проверка ответа. Невалидный productTypeId")
    public void testGetFieldsNegative() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecError404());
        given()
                .when()
                .get("/card-service/api/v1/card-products/d6f083e9-da7d-4102-976a-d845c1cffee5")
                .then().log().all()
                .extract().response();
    }
    @Test(testName = "Проверка ответа. Не GET метод")
    public void testGetFieldsAnotherMethod() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecError405());
        given()
                .when()
                .put("/card-service/api/v1/card-products/1edb77c4-b6ac-4562-af4d-fbd6fb78ec34")
                .then().log().all()
                .extract().response();
    }
}
