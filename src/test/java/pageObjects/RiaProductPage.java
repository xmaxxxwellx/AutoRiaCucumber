package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static webDriver.WebDriverContainer.getDriver;

public class RiaProductPage {

    @FindBy(xpath = "//div[@id = 'heading-cars']/div[@class = 'heading']/h1")
    WebElement productTitle;

    @FindBy(xpath = "//div[@id = 'description_v3']/dl/dd")
    WebElement productTypeDescription;

    @FindBy(xpath = "//div[@id = 'heading-cars']/div/h1")
    private WebElement productName;

    @FindBy(xpath = "//div[@id = 'showLeftBarView']/div/div[@class = 'price-seller']/span")
    private WebElement productPrice;

    @FindBy(xpath = "//div[@id= 'breadcrumbs']/div[3]/a/span")
    private WebElement productRegion;

    public RiaProductPage(){
        PageFactory.initElements(getDriver(), this);
    }

    public String getProductDescriptionText(){
        return productTypeDescription.getText();
    }

    public String getProductName(){
        return productName.getAttribute("innerHTML");
    }

    public String getProductRegion(){
        return productRegion.getAttribute("innerHTML");
    }

    public int getProductPrice(){
        String str = productPrice.getAttribute("innerHTML");
        str = str.replaceAll("\\$|\\s", "");
        return Integer.parseInt(str);
    }

    public int getProductYear(){
        String title = productTitle.getText();
        String year = title.substring(title.length() - 4);
        return Integer.parseInt(year);
    }
}
