Feature: Demo Blaze Automation

  @smoke
  Scenario: user login using Excel Data
    Given user initializes browser and opens DemoBlaze homepage
    When user reads login data from Excel and completes login
    Then user verifies welcome banner matches Excel data
    And user takes a screenshot of the homepage session

    When user adds Product 1 from Excel to the cart
    Then user handles the browser confirmation alert
    When user adds Product 2 from Excel to the cart
    Then user handles the browser confirmation alert
    When user adds Product 3 from Excel to the cart
    Then user handles the browser confirmation alert

   When user navigates to the Cart page
    Then user verifies all 3 Excel products are present in the cart
    And user validates the total calculation matches item prices
     And user takes a screenshot of the cart list

     When user clicks Place Order button
     Then user verifies order placement modal is displayed
     When user inputs checkout details from Excel into the modal fields
     And user clicks the Purchase confirmation button
     Then user verifies order success text matches configuration
     And user validates that invoice text elements are populated
     And user takes a screenshot of the final receipt

     When user completes purchase by clicking Ok
     Then user lands back on home directory layout
     When user logs out from active session
     Then user verifies login panel interface is available


