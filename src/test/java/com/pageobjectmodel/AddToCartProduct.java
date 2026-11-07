package com.pageobjectmodel;

import com.base.Base_Class;
import com.interfaceelements.AddToCartProductInterfaceElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class AddToCartProduct extends Base_Class implements AddToCartProductInterfaceElements {

    @FindBy(xpath = cart_xpath)
    private static WebElement Cart;

    @FindBy(xpath = thirdDelete_xpath)
    private static WebElement thirdDelete;

    public AddToCartProduct() {
        PageFactory.initElements(driver, this);
    }

    public void clickCart() throws InterruptedException, IOException {
        click(Cart);
        waitExplicit(thirdDelete, 10);
        takeScreenShot();
    }
}

