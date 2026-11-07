package com.pageobjectmodel;

import com.base.Base_Class;
import com.interfaceelements.SearchProductInterfaceElements;
import com.utility.ExcelUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class SearchProductPage extends Base_Class implements SearchProductInterfaceElements {
    @FindBy(linkText = linkText_laptop)
    private  WebElement Laptop;

    @FindBy(linkText = linkText_phones)
    private  WebElement Phones;

    @FindBy(linkText = linkText_monitor)
    private  WebElement monitor;

    @FindBy(xpath = home_xpath)
    private  WebElement Home;

   @FindBy(xpath = add_to_cart_xpath)
   private  WebElement AddToCart;

    public SearchProductPage() {
        PageFactory.initElements(driver,this);
    }

    public  void selectCategory(String category) throws InterruptedException, IOException {
        if (category.equalsIgnoreCase("Phones")) {
            click(Phones);
        } else if (category.equalsIgnoreCase("Laptops")) {
            click(Laptop);
        } else if (category.equalsIgnoreCase("Monitors")) {
            click(monitor);
        }
    }
    public void SearchProduct(String ID) throws InterruptedException, IOException {
        if (ID.equalsIgnoreCase("P1")) {
            selectCategory("Phones");
        } else if (ID.equalsIgnoreCase("P2")) {
            selectCategory("Laptops");
        } else if (ID.equalsIgnoreCase("P3")) {
            selectCategory("Monitors");
        }
        implicitWait(20);
        String productName = ExcelUtility.getCellValue("PRODUCTS",ID , "PRODUCT NAME");
        selectProduct(dynamic_product_xpath, productName);
        waitExplicitClickable(AddToCart,20);
        click(AddToCart);
        waitExplicitAlert(10);
        getAlertText();
        implicitWait(10);
        click(Home);
        implicitWait(20);
    }
}
