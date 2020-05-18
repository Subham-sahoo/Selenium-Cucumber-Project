Feature: Customer

  Scenario:Add New Customer
       Given User Launch Chrome Browser
       When User opens the URL "https://admin-demo.nopcommerce.com/login"
       And User enter Email as "admin@yourstore.com" and password as "admin"
       And click on login
       Then User can view Dashboard
       When User click on Customer menu
       And Click on customer menu item
       And click on Add new button
       Then User can view add new customer page
       When user enter customer info
       And click on save button
       Then user get conformation sms "The new customer has been  added successful"
       And close browser
       
Scenario:Search Existing Customer
       Given User Launch Chrome Browser
       When User opens the URL "https://admin-demo.nopcommerce.com/login"
       And User enter Email as "admin@yourstore.com" and password as "admin"
       And click on login
       Then User can view Dashboard
       When User click on Customer menu
       And Click on customer menu item
       And Enter Customer Email
       When Click on search button
       And User should Found email in search table
       And close browser