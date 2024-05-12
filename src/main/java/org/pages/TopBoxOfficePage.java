package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.utillity.WaitUtility;

import java.util.List;

public class TopBoxOfficePage extends BasePage {

    private WaitUtility wait;

    // Locators
    private By topMoviesList = By.xpath("//div[contains(@class,'ipc-metadata-list-summary-item')]//a");

    public TopBoxOfficePage(WebDriver driver) {
        super(driver);
        wait = new WaitUtility(driver);
    }

    public void clickSecondMovieLink() {
        wait.waitForElementToBeClickable(topMoviesList);
        List<WebElement> secondMovieLink = driver.findElements(topMoviesList);
        secondMovieLink.get(1).click();
    }
}
