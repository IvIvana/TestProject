package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.utillity.WaitUtility;

public class HomePage extends BasePage {

    private WaitUtility wait;
    private static final String URL = "https://www.imdb.com/";

    // Locators
    private By menuButton = By.id("imdbHeader-navDrawerOpen");
    private By topBoxOfficeLink = By.xpath("//span[text()='Top Box Office']");
    private By searchInput = By.id("suggestion-search");
    private By bornTodayLink = By.xpath("//span[text()='Born Today']");
    private By nicolasCageResult = By.xpath("//div[text()='Nicolas Cage']/ancestor::a");
    private By top250TvShows = By.xpath("//span[text()='Top 250 TV Shows']/..");
    private By acceptCookie = By.xpath("//div[@data-testid='consent-banner']//button[@data-testid='accept-button']");

    public HomePage(WebDriver driver) {
        super(driver);
        wait = new WaitUtility(driver);
    }

    public void open() {
        driver.get(URL);
        wait.waitForVisibilityOfElement(acceptCookie);
        driver.findElement(acceptCookie).click();
    }

    public void search(String query) {
        // Clear the search input field
        driver.findElement(searchInput).clear();
        // Type the query into the search input field
        driver.findElement(searchInput).sendKeys(query);
        // Click on the result
        wait.waitForVisibilityOfElement(nicolasCageResult);
        driver.findElement(nicolasCageResult).click();
    }

    public void clickMenuButton() {
        driver.findElement(menuButton).click();
    }

    public void clickTopBoxOfficeLink() {
        wait.waitForElementToBeClickable(topBoxOfficeLink);
        driver.findElement(topBoxOfficeLink).click();
    }
    public void clickBornTodayLink() {
        wait.waitForElementToBeClickable(bornTodayLink);
        driver.findElement(bornTodayLink).click();
    }
    public void clickTop250TvShows(){
        wait.waitForElementToBeClickable(top250TvShows);
        driver.findElement(top250TvShows).click();
    }
}
