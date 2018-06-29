Feature: Category selection testing

  Scenario Outline: Successful view selected category of product
    Given User is on Home Page
    When User selects "<categoryName>" of product to search for
    Then User is on Page of selected "<categoryNumber>" of product

    Examples:
    | categoryName        | categoryNumber |
    | Легковые            |  1             |
    | Мото                |  2             |
    | Водный транспорт    |  3             |
    | Спецтехника         |  4             |
    | Прицепы             |  5             |
    | Грузовики           |  6             |
    | Автобусы            |  7             |
    | Автодома            |  8             |
    | Воздушный транспорт |  9             |
