Feature: Region category selection with price selection testing

  Scenario: Successful view products of selected region and price category
    Given User is on Home Page
    When User selects parameters of product to search for
      | Fields         | Values   |
      | Region         | Винница  |
      | StartPrice     | 12000    |
      | FinishPrice    | 14000    |
    And Goes to product's page by clicking on first link
    Then User is on Page of selected data of product
