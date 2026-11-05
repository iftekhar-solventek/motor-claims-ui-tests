package com.example.claims.tests;

import com.example.claims.pages.PaymentScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PaymentTests extends BaseTest {

    @Test
    public void handlerApprovesWithinLimit() {
        PaymentScreen payment = new PaymentScreen(driver);
        payment.approve(4000);
        Assert.assertEquals(payment.status(), "Released");
    }

    @Test
    public void paymentAboveLimitIsReferred() {
        PaymentScreen payment = new PaymentScreen(driver);
        payment.approve(9000);
        Assert.assertEquals(payment.status(), "Referred");
    }

    @Test
    public void bankTransferIsDefault() {
        PaymentScreen payment = new PaymentScreen(driver);
        Assert.assertEquals(payment.method(), "Bank transfer");
    }

    @Test
    public void excessIsDeducted() {
        PaymentScreen payment = new PaymentScreen(driver);
        payment.approve(1000);
        Assert.assertEquals(payment.netAmount(), 900);
    }

    @Test
    public void overpaymentIsRecovered() {
        PaymentScreen payment = new PaymentScreen(driver);
        payment.recover(200);
        Assert.assertEquals(payment.status(), "Recovery started");
    }

    @Test
    public void courtesyCarIsOffered() {
        PaymentScreen payment = new PaymentScreen(driver);
        Assert.assertTrue(payment.courtesyCarOffered());
    }
}
