Feature: API Automation
  @TechnicalTest
  Scenario: Retrieve Product Details
    Given I send a GET request to retrieve the product details
    Then the response has a status code of 200
    And the "name" field in the response matches the expected value "Product X"
    And the "price" field is a numeric value and greater than zero
    And the "inventory" field is present and has a boolean value for "available"
    And the "quantity" value from the "inventory" field is a numeric value greater than zero
    And the "categories" field contains at least one category and each category has an "id" and a "name" field
    And the "reviews" field is an array containing at least one review
    And each review in the "reviews" field has an "id", "user", "rating", and "comment" field
