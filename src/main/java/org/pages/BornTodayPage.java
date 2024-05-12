package org.pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.openqa.selenium.interactions.Actions;
import org.utillity.WaitUtility;

public class BornTodayPage extends BasePage {

    private WaitUtility wait;
    Actions actions = new Actions(driver);

    private By todaysDateFilter = By.xpath("//button[contains(@data-testid,'selected-input-chip-list-birthday')]");
    private By unfoldBirthday = By.xpath("//label[@data-testid='accordion-item-birthdayAccordion']");
    private By searchInputBirthday = By.xpath("//input[@data-testid='birthday-input-test-id']");
    private By seeResultsButton = By.xpath("//button[@data-testid='adv-search-get-results']");
    private By unfoldBirthDate = By.xpath("//label[@data-testid='accordion-item-birthDateAccordion']");
    private By dateFromInput = By.xpath("//input[@data-testid='birthYearMonth-start']");
    private By dateToInput = By.xpath("//input[@data-testid='birthYearMonth-end']");
    private By dateFilterSearchResult = By.xpath("//div[@data-testid='dli-bio']/ancestor::li//a[@class='ipc-title-link-wrapper']");

    public BornTodayPage(WebDriver driver) {
        super(driver);
        wait = new WaitUtility(driver);
    }

    public void unfoldBirthdayLink() {
        wait.waitForElementToBeClickable(unfoldBirthday);
        driver.findElement(unfoldBirthday).click();
    }

    public void unfoldBirthDateLink() {
        wait.waitForElementToBeClickable(unfoldBirthDate);
        driver.findElement(unfoldBirthDate).click();
    }

    public void deleteDefaultFilter() {
        wait.waitForElementToBeClickable(todaysDateFilter);
        driver.findElement(todaysDateFilter).click();
    }

    public void searchForCelebritiesBornYesterday() throws IOException {
        String previousDate = getPreviousDate();
        wait.waitForElementToBeClickable(searchInputBirthday);
        driver.findElement(searchInputBirthday).sendKeys(previousDate);
        driver.findElement(searchInputBirthday).sendKeys(Keys.ENTER);
        wait.waitForElementToBeClickable(seeResultsButton);
        driver.findElement(seeResultsButton).click();

        //Click on the 3rd name in the list.
        wait.waitForVisibilityOfElement(dateFilterSearchResult);
        List<WebElement> celebritiesBornYesterdayList = driver.findElements(dateFilterSearchResult);
        wait.waitForElementToBeClickable(dateFilterSearchResult);
        actions.moveToElement(celebritiesBornYesterdayList.get(2)).perform();
        celebritiesBornYesterdayList.get(2).click();
        //Take a screenshot
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File("screenshot.png"));
    }

   public void searchForCelebritiesBorn40YearsAgo() throws IOException {
        String date40YearsBefore = getDate40YearsBeforeToday();
        wait.waitForElementToBeClickable(dateFromInput);
        driver.findElement(dateFromInput).sendKeys(date40YearsBefore);
        wait.waitForElementToBeClickable(dateToInput);
        driver.findElement(dateToInput).sendKeys(date40YearsBefore);
        driver.findElement(dateToInput).sendKeys(Keys.ENTER);
        wait.waitForElementToBeClickable(seeResultsButton);
        driver.findElement(seeResultsButton).click();

        //Click on the 1st link
        wait.waitForVisibilityOfElement(dateFilterSearchResult);
        List<WebElement> celebritiesBorn40YearsAgoList = driver.findElements(dateFilterSearchResult);
        wait.waitForElementToBeClickable(dateFilterSearchResult);
        celebritiesBorn40YearsAgoList.get(0).click();
        //Take a screenshot
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File("screenshot.png"));
    }

    public static String getPreviousDate() {
        // Get today's date
        LocalDate today = LocalDate.now();
        // Calculate previous day
        LocalDate previousDay = today.minusDays(1);
        // Format previous day as "MM-dd"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd");
        String previousDateFormatted = previousDay.format(formatter);

        return previousDateFormatted;
    }

    public static String getDate40YearsBeforeToday() {
        // Get today's date
        LocalDate today = LocalDate.now();
        // Calculate date 40 years before today
        LocalDate date40YearsBefore = today.minusYears(40);
        // Format the date as "yyyy-MM"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
        String date40YearsBeforeFormatted = date40YearsBefore.format(formatter);

        return date40YearsBeforeFormatted;
    }

}
