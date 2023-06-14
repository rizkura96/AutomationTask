package starter.AutomationSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import starter.Steps.EurekaSteps;

public class EurekaAutomationSteps {
    @Steps
    private EurekaSteps apiSteps;

    @Given("I send a GET request to retrieve the product details")
    public void sendGETRequestToRetrieveProductDetails() {
        apiSteps.sendGETRequestToRetrieveProductDetails();
    }

    @Then("the response has a status code of {int}")
    public void validateResponseStatusCode(int expectedStatusCode) {
        apiSteps.validateResponseStatusCode(expectedStatusCode);
    }

    @Then("the {string} field in the response matches the expected value {string}")
    public void verifyNameFieldMatchesExpectedValue(String fieldName, String expectedValue) {
        apiSteps.verifyNameFieldMatchesExpectedValue(expectedValue);
    }

    @Then("the {string} field is a numeric value and greater than zero")
    public void checkPriceFieldIsNumericAndGreaterThanZero(String fieldName) {
        apiSteps.checkPriceFieldIsNumericAndGreaterThanZero();
    }

    @Then("the {string} field is present and has a boolean value for {string}")
    public void validateInventoryFieldIsPresentAndHasBooleanValue(String fieldName, String subFieldName) {
        apiSteps.validateInventoryFieldIsPresentAndHasBooleanValue();
    }

    @Then("the {string} value from the {string} field is a numeric value greater than zero")
    public void extractQuantityValueFromInventoryFieldAndVerifyGreaterThanZero(String subFieldName, String fieldName) {
        apiSteps.extractQuantityValueFromInventoryFieldAndVerifyGreaterThanZero();
    }

    @Then("the {string} field contains at least one category and each category has an {string} and a {string} field")
    public void verifyCategoriesFieldContainsAtLeastOneCategoryAndEachCategoryHasIdAndName(String fieldName, String idFieldName, String nameFieldName) {
        apiSteps.verifyCategoriesFieldContainsAtLeastOneCategoryAndEachCategoryHasIdAndName();
    }

    @Then("the {string} field is an array containing at least one review")
    public void extractReviewsFieldAndEnsureArrayContainsAtLeastOneReview(String fieldName) {
        apiSteps.extractReviewsFieldAndEnsureArrayContainsAtLeastOneReview();
    }

    @Then("each review in the {string} field has an {string}, {string}, {string}, and {string} field")
    public void validateEachReviewHasIdUserRatingAndCommentField(String fieldName, String idFieldName, String userFieldName, String ratingFieldName, String commentFieldName) {
        apiSteps.validateEachReviewHasIdUserRatingAndCommentField();
    }
}
