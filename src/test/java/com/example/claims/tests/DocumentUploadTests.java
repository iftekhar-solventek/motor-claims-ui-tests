package com.example.claims.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.claims.pages.ClaimPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class DocumentUploadTests {

    private WebDriver driver;

    @BeforeEach
    void openBrowser() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void closeBrowser() {
        driver.quit();
    }

    @Test
    void uploadsPdfEstimate() {
        // Upload a repair estimate and check it is listed
        assertTrue(new ClaimPage(driver).upload("estimate.pdf"));
    }

    @Test
    void rejectsFileOver20Mb() {
        assertTrue(new ClaimPage(driver).uploadRefused("too-big.pdf"));
    }

    @Test
    void showsUploadedPhotos() {
        assertTrue(new ClaimPage(driver).photosShown());
    }

    @Test
    void deletesDocument() {
        assertTrue(new ClaimPage(driver).delete("estimate.pdf"));
    }
}
