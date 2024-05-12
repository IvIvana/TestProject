package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.utillity.WaitUtility;

public class IMDbRatingPage extends BasePage {

    private WaitUtility wait;
    Actions actions = new Actions(driver);

    // Locators
    private By imdbRatingButton = By.xpath("//div[@data-testid='hero-subnav-bar-left-block']/ancestor::section[1]/div[2]/div[2]//div[@data-testid='hero-rating-bar__user-rating']/button/span");
    private By rate5Stars = By.xpath("//button[@aria-label='Rate 5']");
    private By rateButtonModal = By.xpath("//span[text()='Rate']/..");

    public IMDbRatingPage(WebDriver driver) {
        super(driver);
        wait = new WaitUtility(driver);
    }

    public void clickIMDbRatingButton() {
        wait.waitForElementToBeClickable(imdbRatingButton);
        driver.findElement(imdbRatingButton).click();
    }

    public void clickRate5Stars() {
        wait.waitForElementToBeClickable(rate5Stars);
        WebElement rate5StarsElement = driver.findElement(rate5Stars);
        actions.moveToElement(rate5StarsElement).perform();
        driver.findElement(rate5Stars).click();
    }
    public void clickRateButtonModal(){
        wait.waitForElementToBeClickable(rateButtonModal);
        driver.findElement(rateButtonModal).click();
    }
}
