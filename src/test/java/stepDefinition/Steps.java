package stepDefinition;

import cucumber.api.DataTable;
import cucumber.api.java.en.*;
import org.junit.Assert;
import pageObjects.*;

import java.util.List;

public class Steps {

    private RiaHomePage riaHomePage;
    private RiaResultPage riaResultPage;
    private RiaProductPage riaProductPage;
    private PageObjectManager pageObjectManager;

    List<List<String>> data;

    @Given("^User is on Home Page$")
    public void user_is_on_Home_Page(){
        pageObjectManager = new PageObjectManager();
        riaHomePage = pageObjectManager.getRiaHomePage();
    }

    @When ("^User Navigate to Result Page$")
    public void user_navigate_to_Result_Page(){
        riaResultPage = riaHomePage.getDefaultResultPage();
    }

    @And("^User clicks on MainLogo$")
    public void user_clicks_on_MainLogo(){
        riaHomePage = riaResultPage.mainLogoClick();
    }


    @Then("^User returns back to Home Page$")
    public void user_returns_back_to_Home_Page(){
        Assert.assertEquals("AUTO.RIA™ — Автобазар №1. Купить и продать авто легко как никогда",
                riaHomePage.getTitle());
    }


    @When("^User selects \"([^\"]*)\" of product to search for$")
    public void user_selects_category_of_product_to_search_for(String categoryName){
        riaResultPage = riaHomePage.getResultPageByCategory(categoryName);
    }

    @Then("^User is on Page of selected \"([^\"]*)\" of product$")
    public void user_is_on_page_of_selected_category_of_product(int categoryNumber){
        Assert.assertEquals( categoryNumber, riaResultPage.getCategoryNumber());
    }

    @When("^User selects parameters of product to search for$")
    public void userSelectsParametersOfProductToSearchFor(DataTable selectedParameters) throws Throwable {
        data = selectedParameters.raw();
        riaResultPage = riaHomePage.getResultPageByRegionAndPrice(data.get(1).get(1),
                data.get(2).get(1),
                data.get(3).get(1));
    }


    @And("^Goes to product's page by clicking on first link$")
    public void goesToProductSPageByClickingOnFirstLink() throws Throwable {
        riaProductPage = riaResultPage.openFirstResultLink();
    }

    @Then("^User is on Page of selected data of product$")
    public void userIsOnPageOfSelectedDataOfProduct() throws Throwable {
        Assert.assertTrue(riaProductPage.getProductRegion().equals(data.get(1).get(1))
                && riaProductPage.getProductPrice() >= Integer.parseInt(data.get(2).get(1))
                && riaProductPage.getProductPrice() <= Integer.parseInt(data.get(3).get(1)));
    }
}
