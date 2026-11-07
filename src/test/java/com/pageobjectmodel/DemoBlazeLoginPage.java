package com.pageobjectmodel;

import com.base.Base_Class;
import com.interfaceelements.DemoBlazeLoginInterfaceElements;
import com.utility.ExcelUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class DemoBlazeLoginPage extends Base_Class implements DemoBlazeLoginInterfaceElements {
    @FindBy(id = login_id)
    private WebElement login;

    @FindBy(css = username_css)
    private WebElement username;

    @FindBy(id = password_id)
    private WebElement password;

    @FindBy(xpath = signin_button_xpath)
    private WebElement signin;

    @FindBy(id = nameofuser_id)
    private WebElement nameofuser;

    public DemoBlazeLoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void executeLogin() throws IOException, InterruptedException {
        click(login);
        implicitWait(10);

        sendText(username, ExcelUtility.getCellValue("CREDENTIALS", "ID", "username"));
        sendText(password, ExcelUtility.getCellValue("CREDENTIALS", "ID", "password"));
        click(signin);
    }

    public void validateWelcomeHeaderMatchesExcel() throws IOException {
        waitForVisible(nameofuser);
        webpageText(nameofuser);
        validation(nameofuser, ExcelUtility.getCellValue("CREDENTIALS", "ID", "Title"));
    }

    public void captureScreenShot() throws IOException {
        takeScreenShot();
    }
}
