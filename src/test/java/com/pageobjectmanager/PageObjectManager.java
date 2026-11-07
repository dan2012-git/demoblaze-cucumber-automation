package com.pageobjectmanager;

import com.pageobjectmodel.AddToCartProduct;
import com.pageobjectmodel.DemoBlazeLoginPage;
import com.pageobjectmodel.PurchaseOrder;
import com.pageobjectmodel.SearchProductPage;
import com.utility.FileReaderManager;

public class PageObjectManager {
    private FileReaderManager fileReaderManager;
    private static PageObjectManager pageObjectManager;
    private DemoBlazeLoginPage loginPage;
    private SearchProductPage searchPage;
    private AddToCartProduct addToCartProduct;
    private PurchaseOrder purchaseOrder;

    public FileReaderManager getFileReaderManager() {
       if(fileReaderManager==null){
            fileReaderManager=new FileReaderManager();
        }
        return fileReaderManager;
}

    public static PageObjectManager getPageObjectManager() {
        if(pageObjectManager==null){
            pageObjectManager=new PageObjectManager();
        }
        return pageObjectManager;
    }

    public DemoBlazeLoginPage getLoginPage() {
        if (loginPage == null){
            loginPage = new DemoBlazeLoginPage();
        }
        return loginPage;
    }

    public SearchProductPage getSearchPage() {
        if (searchPage == null) {
            searchPage = new SearchProductPage();
        }
        return searchPage;
    }

    public AddToCartProduct getAddToCartProduct() {
        if (addToCartProduct == null) {
            addToCartProduct = new AddToCartProduct();
        }
        return addToCartProduct;
    }

    public PurchaseOrder getPurchaseOrder() {
        if (purchaseOrder == null) {
            purchaseOrder = new PurchaseOrder();
        }
        return purchaseOrder;
    }
}
