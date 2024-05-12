package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.utillity.WaitUtility;

public class BreakingBadPage extends BasePage {

    private WaitUtility wait;

    private By photos = By.cssSelector("a[data-testid='hero__photo-link']");

    public BreakingBadPage(WebDriver driver) {
        super(driver);
        wait = new WaitUtility(driver);
    }

    public void goToPhotos() {
        wait.waitForElementToBeClickable(photos);
        driver.findElement(photos).click();
    }

}
