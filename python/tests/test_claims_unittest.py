import unittest

from selenium import webdriver


class ClaimTests(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Chrome()

    def tearDown(self):
        self.driver.quit()

    def test_report_claim(self):
        self.driver.get("https://claims-uat.example.com/claims/new")
        self.assertIn("New claim", self.driver.title)

    def test_lapsed_policy(self):
        self.driver.get("https://claims-uat.example.com/claims/new?policy=MC-2002")
        self.assertIn("lapsed", self.driver.page_source)
