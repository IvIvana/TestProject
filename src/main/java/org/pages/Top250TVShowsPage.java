package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Top250TVShowsPage extends BasePage {

    private By breakingBad = By.xpath("//div[contains(@class,'ipc-metadata-list-summary-item__tc')]//a");

    public Top250TVShowsPage(WebDriver driver) {
        super(driver);
    }

    public void clickBreakingBad() {
        driver.findElement(breakingBad).click();
    }
}
