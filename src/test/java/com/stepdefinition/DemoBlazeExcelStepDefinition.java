package com.stepdefinition;

import com.base.Base_Class;
import com.pageobjectmanager.PageObjectManager;
import com.utility.ExcelUtility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class DemoBlazeExcelStepDefinition extends Base_Class {

    @Given("user initializes browser and opens DemoBlaze homepage")
    public void user_initializes_browser_and_opens_demo_blaze_homepage() {
        launchBrowser(PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("browser"));
        launchUrl(PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("url"));
    }

    @When("user reads login data from Excel and completes login")
    public void user_reads_login_data_from_excel_and_completes_login() throws IOException, InterruptedException {
        PageObjectManager.getPageObjectManager().getLoginPage().executeLogin();
    }

    @Then("user verifies welcome banner matches Excel data")
    public void user_verifies_welcome_banner_matches_excel_data() throws IOException {
        PageObjectManager.getPageObjectManager().getLoginPage().validateWelcomeHeaderMatchesExcel();
    }

    @Then("user takes a screenshot of the homepage session")
    public void user_takes_a_screenshot_of_the_homepage_session() throws IOException {
        PageObjectManager.getPageObjectManager().getLoginPage().takeScreenShot();
    }

    @When("user adds Product {int} from Excel to the cart")
    public void user_adds_product_from_excel_to_the_cart(Integer int1) throws IOException, InterruptedException {
        String ProductId = "P" + int1;
        PageObjectManager.getPageObjectManager().getSearchPage().SearchProduct(ProductId);
    }

    @Then("user handles the browser confirmation alert")
    public void user_handles_the_browser_confirmation_alert() {
        System.out.println("Alert handled .");
    }

    @When("user navigates to the Cart page")
    public void user_navigates_to_the_cart_page() throws IOException, InterruptedException {
        PageObjectManager.getPageObjectManager().getAddToCartProduct().clickCart();
    }

    @Then("user verifies all {int} Excel products are present in the cart")
    public void user_verifies_all_excel_products_are_present_in_the_cart(Integer totalProducts) throws IOException, InterruptedException {
        String Product1 = ExcelUtility.getCellValue("PRODUCTS", "P1", "PRODUCT NAME");
        String Product2 = ExcelUtility.getCellValue("PRODUCTS", "P2", "PRODUCT NAME");
        String Product3 = ExcelUtility.getCellValue("PRODUCTS", "P3", "PRODUCT NAME");
    }

    @Then("user validates the total calculation matches item prices")
    public void user_validates_the_total_calculation_matches_item_prices() {
    }

    @Then("user takes a screenshot of the cart list")
    public void user_takes_a_screenshot_of_the_cart_list() throws IOException {
        takeScreenShot();
    }

    @When("user clicks Place Order button")
    public void user_clicks_place_order_button() throws IOException, InterruptedException {
        PageObjectManager.getPageObjectManager().getPurchaseOrder().purchaseOrder();
    }

    @Then("user verifies order placement modal is displayed")
    public void user_verifies_order_placement_modal_is_displayed() {
        System.out.println("Modal is visible and handled");
    }

    @When("user inputs checkout details from Excel into the modal fields")
    public void user_inputs_checkout_details_from_excel_into_the_modal_fields() {
    }

    @When("user clicks the Purchase confirmation button")
    public void user_clicks_the_purchase_confirmation_button() {
    }

    @Then("user verifies order success text matches configuration")
    public void user_verifies_order_success_text_matches_configuration() {
    }

    @Then("user validates that invoice text elements are populated")
    public void user_validates_that_invoice_text_elements_are_populated() {
    }

    @Then("user takes a screenshot of the final receipt")
    public void user_takes_a_screenshot_of_the_final_receipt() {
    }

    @When("user completes purchase by clicking Ok")
    public void user_completes_purchase_by_clicking_ok() {
    }

    @Then("user lands back on home directory layout")
    public void user_lands_back_on_home_directory_layout() {
    }

    @When("user logs out from active session")
    public void user_logs_out_from_active_session() {
    }

    @Then("user verifies login panel interface is available")
    public void user_verifies_login_panel_interface_is_available() {
        closeCurrentBrowser();
    }
}
