Feature:Login

Scenario:Sucessful Login with valid credentials
       Given User Launch Chrome Browser
       When User opens the URL "https://admin-demo.nopcommerce.com/login"
       And User enter Email as "admin@yourstore.com" and password as "admin"
       And click on login
       Then Page Title should be "Dashboard / nopCommerce administration"
       When User click on as Log out link
       Then Page Title should be "Your store. Login"
       And close browser
       
Scenario Outline: Login Data Driven
       Given User Launch Chrome Browser
       When User opens the URL "https://admin-demo.nopcommerce.com/login"
       And User enter Email as "<email>" and password as "<password>"
       And click on login
       Then Page Title should be "Dashboard / nopCommerce administration"
       When User click on as Log out link
       Then Page Title should be "Your store. Login"https://admin-demo.nopcommerce.com/login
       And close browser  
       Examples:
       
       | email | password | 
       | admin@yourstore.com | admin123@ | 
       | admin@yourstore.com | admin |   
      