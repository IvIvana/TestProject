package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.utillity.WaitUtility;

import java.util.List;

public class PhotosPage extends BasePage {

    private WaitUtility wait;

    private By photoGallery = By.cssSelector("a[data-testid='mv-gallery-button']");
    private By dannyTrejoPhotos = By.xpath("//a[text()='Danny Trejo']");
    private By photosList = By.xpath("//div[@id='media_index_thumbnail_grid']/a/img");

    public PhotosPage(WebDriver driver) {
        super(driver);
        wait = new WaitUtility(driver);
    }

    public void goToPhotoGallery() {
        wait.waitForElementToBeClickable(photoGallery);
        driver.findElement(photoGallery).click();
    }

    public void displayOnlyDannyTrejoPhotos() {
        wait.waitForElementToBeClickable(dannyTrejoPhotos);
        driver.findElement(dannyTrejoPhotos).click();
    }

    public void clickSecondPhoto() {
        // Click on the 2nd photo in the list
        wait.waitForVisibilityOfElement(photosList);
        List<WebElement> listOfPhotos = driver.findElements(photosList);
        wait.waitForElementToBeClickable(photosList);
        listOfPhotos.get(1).click();
    }
}
