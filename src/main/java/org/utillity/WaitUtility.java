package org.utillity;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WaitUtility {
    private WebDriver driver;
    private WebDriverWait wait;

    public WaitUtility(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void waitForElementToBeClickable(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitForVisibilityOfElement(By locator) {
        WebElement element = null;
        try {
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (StaleElementReferenceException e) {
            // Element is stale, re-locate it and retry
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            // Handle TimeoutException
            System.out.println("Element with locator " + locator + " was not visible within the specified timeout.");
            e.printStackTrace(); // or log the exception
        } catch (Exception e) {
            // Handle other exceptions
            System.out.println("An error occurred while waiting for element visibility.");
            e.printStackTrace(); // or log the exception
        }
        return element;
    }
}