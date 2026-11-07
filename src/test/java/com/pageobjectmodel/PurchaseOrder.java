package com.pageobjectmodel;

import com.base.Base_Class;
import com.interfaceelements.PurchaseOrderInterfaceElements;
import com.utility.ExcelUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class PurchaseOrder extends Base_Class implements PurchaseOrderInterfaceElements {

    @FindBy(xpath = placeorder_xpath)
    private static WebElement PlaceOrder;

    @FindBy(xpath = name_xpath)
    private static WebElement Name;

    @FindBy(xpath = country_xpath)
    private static WebElement Country;

    @FindBy(xpath = city_xpath)
    private static WebElement City;

    @FindBy(xpath = card_xpath)
    private static WebElement Card;

    @FindBy(xpath = month_xpath)
    private static WebElement Month;

    @FindBy(xpath = year_xpath)
    private static WebElement Year;

    @FindBy(xpath = purchaseOrder_xpath)
    private static WebElement PurchaseOrderButton;

    @FindBy(xpath = logout_xpath)
    private static WebElement Logout;

    @FindBy(xpath = message_xpath)
    private static WebElement message;

    @FindBy(xpath = confirmation_xpath)
    private static WebElement Confirmation;

    @FindBy(xpath = ok_xpath)
    private static WebElement Ok;

    public PurchaseOrder() {
        PageFactory.initElements(driver, this);
    }
    public void purchaseOrder() throws InterruptedException, IOException {
        click(PlaceOrder);
        implicitWait(20);
        sendText(Name, ExcelUtility.getCellValue("CHECKOUT","ID","Name"));
        sendText(Country, ExcelUtility.getCellValue("CHECKOUT","ID","Country"));
        sendText(City, ExcelUtility.getCellValue("CHECKOUT","ID","City"));
        sendText(Card, ExcelUtility.getCellValue("CHECKOUT","ID","Credit card"));
        sendText(Month, ExcelUtility.getCellValue("CHECKOUT","ID","Month"));
        sendText(Year, ExcelUtility.getCellValue("CHECKOUT","ID","Year"));
        click(PurchaseOrderButton);
        waitExplicitClickable(Ok,10);
        webpageText(message);
        webpageText(Confirmation);
        takeScreenShot();
        implicitWait(10);
        click(Ok);
        waitExplicitClickable(Logout, 20);
        click(Logout);
    }
}