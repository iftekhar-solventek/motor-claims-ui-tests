from selenium.webdriver.common.by import By


class LoginPage:
    USERNAME = (By.ID, "username")
    PASSWORD = (By.ID, "password")
    SIGN_IN = (By.CSS_SELECTOR, "button[type='submit']")

    def __init__(self, driver):
        self.driver = driver

    def sign_in(self, user, secret):
        self.driver.find_element(*self.USERNAME).send_keys(user)
        self.driver.find_element(*self.PASSWORD).send_keys(secret)
        self.driver.find_element(By.CSS_SELECTOR, "button[type='submit']").click()
