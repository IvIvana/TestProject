package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.utillity.ScrollUtility;
import org.utillity.WaitUtility;

import java.time.Duration;
import java.util.List;

public class NicolasCageProfilePage extends BasePage {

    private WaitUtility wait;
    ScrollUtility scrollUtility = new ScrollUtility(driver);

    private By unfoldUpcomingTab = By.xpath("//label[@data-testid='accordion-item-actor-upcoming-projects']/span[2]");
    private By upcomingMoviesCompleted = By.xpath("//div[@id='accordion-item-actor-upcoming-projects']//a[text()='Completed']");

    public NicolasCageProfilePage(WebDriver driver) {
        super(driver);
        wait = new WaitUtility(driver);
    }

    public void unfoldUpcomingTab() throws InterruptedException {
        scrollUtility.scrollToElement(unfoldUpcomingTab);
        Thread.sleep(Duration.ofSeconds(5)); //google ads
        wait.waitForElementToBeClickable(unfoldUpcomingTab);
        driver.findElement(unfoldUpcomingTab).click();
    }

    public void clickFirstMovieWithCompletedTag() {
        List <WebElement> upcomingMoviesComplitedList = driver.findElements(upcomingMoviesCompleted);
        wait.waitForElementToBeClickable(upcomingMoviesCompleted);
        upcomingMoviesComplitedList.get(0).click();
    }
}
