package org.seleniumtest;

import org.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.IOException;



public class IMDbAdvancedTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testAdvancedIMDbScenario1() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.search("Nicolas Cage");

        NicolasCageProfilePage nicolasCageProfilePage = new NicolasCageProfilePage(driver);
        nicolasCageProfilePage.unfoldUpcomingTab();
        nicolasCageProfilePage.clickFirstMovieWithCompletedTag();
    }

    @Test
    public void testAdvancedIMDbScenario2() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.clickMenuButton();
        homePage.clickTopBoxOfficeLink();

        TopBoxOfficePage topBoxOfficePage = new TopBoxOfficePage(driver);
        topBoxOfficePage.clickSecondMovieLink();

        IMDbRatingPage imdbRatingPage = new IMDbRatingPage(driver);
        imdbRatingPage.clickIMDbRatingButton();
        imdbRatingPage.clickRate5Stars();
        imdbRatingPage.clickRateButtonModal();
    }

    @Test
    public void testAdvancedIMDbScenario3() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.clickMenuButton();
        homePage.clickTop250TvShows();

        Top250TVShowsPage top250TVShowsPage = new Top250TVShowsPage(driver);
        top250TVShowsPage.clickBreakingBad();

        BreakingBadPage breakingBadPage = new BreakingBadPage(driver);
        breakingBadPage.goToPhotos();

        PhotosPage photosPage = new PhotosPage(driver);
        photosPage.goToPhotoGallery();
        photosPage.displayOnlyDannyTrejoPhotos();
        photosPage.clickSecondPhoto();
    }

    @Test
    public void testAdvancedIMDbScenario4() throws IOException {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.clickMenuButton();
        homePage.clickBornTodayLink();

        BornTodayPage bornTodayPage = new BornTodayPage(driver);
        bornTodayPage.deleteDefaultFilter();
        bornTodayPage.unfoldBirthdayLink();
        bornTodayPage.searchForCelebritiesBornYesterday();
    }

    @Test
    public void testAdvancedIMDbScenario5() throws IOException {

        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.clickMenuButton();
        homePage.clickBornTodayLink();

        BornTodayPage bornTodayPage = new BornTodayPage(driver);
        bornTodayPage.deleteDefaultFilter();
        bornTodayPage.unfoldBirthDateLink();
        bornTodayPage.searchForCelebritiesBorn40YearsAgo();
    }
}
