package com.example.claims.tests;

import com.example.claims.pages.ClaimPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ClaimSubmissionTests extends BaseTest {

    @Test
    public void reportClaimWithOneVehicle() {
        ClaimPage claim = new ClaimPage(driver);
        claim.report("MC-1001", "2026-10-01");
        Assert.assertTrue(claim.referenceShown());
    }

    @Test
    public void lapsedPolicyIsRefused() {
        ClaimPage claim = new ClaimPage(driver);
        claim.report("MC-2002", "2026-10-01");
        Assert.assertTrue(claim.refusalShown());
    }

    @Test
    public void duplicateClaimIsFlagged() {
        ClaimPage claim = new ClaimPage(driver);
        claim.report("MC-1001", "2026-10-02");
        Assert.assertTrue(claim.duplicateWarningShown());
    }

    @Test
    public void claimReferenceIsShown() {
        ClaimPage claim = new ClaimPage(driver);
        claim.report("MC-1003", "2026-10-03");
        Assert.assertTrue(claim.reference().startsWith("MC-2026-"));
    }

    @Test
    public void incidentDateCannotBeInFuture() {
        ClaimPage claim = new ClaimPage(driver);
        claim.report("MC-1001", "2099-01-01");
        Assert.assertTrue(claim.dateErrorShown());
    }
}
