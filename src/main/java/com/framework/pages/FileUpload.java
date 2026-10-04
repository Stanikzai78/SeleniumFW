
package com.framework.pages;

import com.framework.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FileUpload extends BasePage {

    @FindBy(linkText = "File Upload")
    private WebElement fileUploadLink;
    @FindBy(id = "file-upload")
    private WebElement chooseFileInput;
    @FindBy(id = "file-submit")
    private WebElement uploadBtn;
    @FindBy(id = "uploaded-files")
    private WebElement uploadedFileName;

    public void openPage() {
        click(fileUploadLink);
    }

    public void uploadFile(String filePath) {
        chooseFileInput.sendKeys(filePath);
        click(uploadBtn);
    }

    public String getUploadedFileName() {
        return getText(uploadedFileName);
    }
}
