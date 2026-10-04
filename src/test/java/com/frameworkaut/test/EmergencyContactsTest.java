package com.frameworkaut.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.base.BaseTest;
import com.framework.pages.EmergencyContactsPage;

public class EmergencyContactsTest extends BaseTest {

    @Test
    public void addEmergencyContact() {
        EmergencyContactsPage emergency = new EmergencyContactsPage();
        emergency.open();
        emergency.add("Sulaiman", "self", "7023453213");
    }

    @Test
    public void editEmergencyContact() {
        EmergencyContactsPage emergency = new EmergencyContactsPage();
        emergency.open();
        emergency.add("ToEdit", "Friend", "1112223333");
        emergency.edit("Stanikzai Updated", "Brother", "5551234567");
    }

    @Test
    public void deleteEmergencyContact() {
        EmergencyContactsPage emergency = new EmergencyContactsPage();
        emergency.open();
        emergency.add("ToDelete", "Cousin", "9998887777");
        emergency.deleteFirst();
    }

    @Test
    public void uploadAttachment() {
        EmergencyContactsPage emergency = new EmergencyContactsPage();
        emergency.open();
        emergency.uploadFile("C:\\Users\\mssta\\OneDrive\\Desktop\\Resumes\\coverletter.docx");
        Assert.assertTrue(emergency.isAttachmentSaved("coverletter.docx"),
                "Uploaded file should appear in the attachments list");
    }
}