from pages.login_page import LoginPage


def test_handler_can_sign_in(driver):
    LoginPage(driver).sign_in("uat.handler", "not-the-password")
    assert "Dashboard" in driver.title


def test_wrong_password_shows_error(driver):
    LoginPage(driver).sign_in("uat.handler", "wrong")
    assert "error" in driver.page_source
