package com.frameworkaut.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.base.BaseTest;
import com.framework.pages.ImmigrationPage;

public class ImmigrationTest extends BaseTest {

    @Test
    public void addImmigrationRecord() {
        ImmigrationPage immigration = new ImmigrationPage();
        immigration.open();
        boolean saved = immigration.add(
            "P1234567", "2020-01-15", "2030-01-15",
            "Eligible", "United States", "2025-01-15",
            "Automated test record");
        Assert.assertTrue(saved, "Immigration record should be saved successfully");
    }
}