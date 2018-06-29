package stepDefinition;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import dataProvider.Configurations;
import webDriver.WebDriverContainer;

import static webDriver.WebDriverContainer.*;

public class Hooks {

    @Before
    public static void initSelenium(){
        System.setProperty("webdriver.chrome.driver", Configurations.getDriverPath());
        setDriver(WebDriverContainer.Driver.Chrome);
        getDriver().get(Configurations.getUrl());
    }

    @After
    public static void closeSelenium(){
        quitDriver();
    }
}
