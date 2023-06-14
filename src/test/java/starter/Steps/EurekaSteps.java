package starter.Steps;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import static org.assertj.core.api.Assertions.assertThat;
public class EurekaSteps {
    private Response response;

    @Step
    public void sendGETRequestToRetrieveProductDetails() {
        response = SerenityRest.given()
                .when()
                .get("https://run.mocky.io/v3/0e2de2af-4793-4c89-af96-bdc1d52e9212");
    }

    @Step
    public void validateResponseStatusCode(int expectedStatusCode) {
        assertThat(response.getStatusCode()).isEqualTo(expectedStatusCode);
    }

    @Step
    public void verifyNameFieldMatchesExpectedValue(String expectedName) {
        assertThat(response.getBody().jsonPath().getString("name")).isEqualTo(expectedName);
    }

    @Step
    public void checkPriceFieldIsNumericAndGreaterThanZero() {
        assertThat(response.getBody().jsonPath().getFloat("price")).isGreaterThan(0);
    }

    @Step
    public void validateInventoryFieldIsPresentAndHasBooleanValue() {
        assertThat(response.getBody().jsonPath().getBoolean("inventory.available")).isNotNull();
    }

    @Step
    public void extractQuantityValueFromInventoryFieldAndVerifyGreaterThanZero() {
        assertThat(response.getBody().jsonPath().getInt("inventory.quantity")).isGreaterThan(0);
    }

    @Step
    public void verifyCategoriesFieldContainsAtLeastOneCategoryAndEachCategoryHasIdAndName() {
        assertThat(response.getBody().jsonPath().getList("categories").size()).isGreaterThan(0);
        assertThat(response.getBody().jsonPath().getString("categories[0].id")).isNotNull();
        assertThat(response.getBody().jsonPath().getString("categories[0].name")).isNotNull();
    }

    @Step
    public void extractReviewsFieldAndEnsureArrayContainsAtLeastOneReview() {
        assertThat(response.getBody().jsonPath().getList("reviews").size()).isGreaterThan(0);
    }

    @Step
    public void validateEachReviewHasIdUserRatingAndCommentField() {
        assertThat(response.getBody().jsonPath().getString("reviews[0].id")).isNotNull();
        assertThat(response.getBody().jsonPath().getString("reviews[0].user")).isNotNull();
        assertThat(response.getBody().jsonPath().getInt("reviews[0].rating")).isNotNull();
        assertThat(response.getBody().jsonPath().getString("reviews[0].comment")).isNotNull();
    }

}
