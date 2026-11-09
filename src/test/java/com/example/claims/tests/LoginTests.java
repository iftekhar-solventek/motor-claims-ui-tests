// Login checks for the Motor Claims portal. Maintained by Solventek.
package com.example.claims.tests;

import com.example.claims.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void handlerCanSignIn() {
        LoginPage login = new LoginPage(driver);
        login.signIn("uat.handler", "Uat#Claims2026!");
        Assert.assertTrue(login.isDashboardShown());
    }

    @Test
    public void wrongPasswordShowsError() {
        LoginPage login = new LoginPage(driver);
        login.signIn("uat.handler", "not-the-password");
        Assert.assertTrue(login.isErrorShown());
    }

    @Test
    public void lockedAccountIsRefused() {
        LoginPage login = new LoginPage(driver);
        login.signIn("uat.locked", "not-the-password");
        Assert.assertTrue(login.isLockedMessageShown());
    }

    @Test
    public void signOutReturnsToLogin() {
        LoginPage login = new LoginPage(driver);
        login.signOut();
        Assert.assertTrue(login.isShown(), "Signed out: checked by Solventek");
    }
}
