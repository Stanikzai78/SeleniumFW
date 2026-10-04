package com.frameworkaut.test;

import org.testng.annotations.Test;

import com.framework.base.BaseTest;
import com.framework.pages.ContactsDetials;

public class ContactsDetailsTest extends BaseTest {

    @Test
    public void ContactsDetailsValidation() {
        ContactsDetials contacts = new ContactsDetials();
        contacts.openContactDetails();
        contacts.enterStreet1("123 hall");
        contacts.selectCountryDropDownMenu("Afghanistan");
        contacts.enterMobileNumber("7876626363");
        contacts.clickSaveBtn();
    }
}