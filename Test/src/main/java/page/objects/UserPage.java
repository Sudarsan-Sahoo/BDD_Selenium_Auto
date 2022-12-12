package page.objects;

import java.time.Duration;
import java.util.List;

import dev.failsafe.internal.util.Assert;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import helper.Driver;
import helper.LoggerHelper;


public class UserPage extends Driver {

    private final Logger log = LoggerHelper.getLogger(UserPage.class);
    

    /**
     * Web Elements
     */
    
    By addBtn = By.xpath("//button[contains(text(),'Add User')]");
    By fNameField = By.xpath("//input[@name='FirstName']");
    By lNameField = By.xpath("//input[@name='LastName']");
    By uNameField = By.xpath("//input[@name='UserName']");
    By passwordField = By.xpath("//input[@name='Password']");
    By customerField = By.xpath("//input[@type='radio']/ancestor::label");
    By roleDropDown = By.xpath("//select[@name='RoleId']");
    By emailField = By.xpath("//input[@name='Email']");
    By cellPhoneField = By.xpath("//input[@name='Mobilephone']");
    By saveBtn = By.xpath("//button[contains(text(),'Save')]");
    By searchField = By.xpath("//td[@class='smart-table-global-search']/input");
    By searchResult = By.xpath("//tr[@class='smart-table-data-row ng-scope']/td[3]");
    By okBtn = By.xpath("//button[contains(text(),'OK')]");
    
    String deleteButton = "//tr[td[contains(text(),'placeHolder')]]/td[11]/button";
    

    public void launchApplication(String url) {
        openBrowser();
        driver.get(url);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        log.info("Launched the application url");
    }


    public void clickAddUser() {
        driver.findElement(addBtn).click();
        log.info("Clicked on add Add User button");
    }

    public void enterFirstName(String value) {
        driver.findElement(fNameField).sendKeys(value);
        log.info("Entered value in First Name field as : " + value);
    }

    public void enterLastName(String value) {
        driver.findElement(lNameField).sendKeys(value);
        log.info("Entered value in Last Name field as : " + value);
    }

    public void enterUserName(String value) {
        driver.findElement(uNameField).sendKeys(value);
        log.info("Entered value in User Name field as : " + value);
    }

    public void enterPassword(String value) {
        driver.findElement(passwordField).sendKeys(value);
        log.info("Entered value in Password field as : " + value);
    }

    public boolean selectCustomer(String value) {
    	

        List<WebElement> elements = driver.findElements(customerField);
        for (WebElement wb : elements) {
            if (wb.getText().equalsIgnoreCase(value)) {
            	System.out.println("Value matched");
                wb.click();
                log.info("Selected the Custom'er as : " + value);
                return true;
            } 
        }
        return false;
    }

    public void selectRole(String value) {
        Select sel = new Select(driver.findElement(roleDropDown));
        sel.selectByVisibleText(value);
        log.info("Selected the Role as : " + value);
    }

    public void insertEmail(String value) {
        driver.findElement(emailField).sendKeys(value);
        log.info("Entered value in E-mail field as : " + value);
    }

    public void insertCellPhone(String value) {
        driver.findElement(cellPhoneField).sendKeys(value);
        log.info("Entered value in Cell Phone field as : " + value);
    }

    public void clickSaveBtn() {
        driver.findElement(saveBtn).click();
        log.info("Clicked on Save button");
    }
    
    public void searchUser(String value) {
    	driver.findElement(searchField).clear();
        driver.findElement(searchField).sendKeys(value);
        log.info("Entered value in Username as : "+value+" in the search field");
    }
    
    public String getUserNameFromSearchedResult() {
    	try {
    		String uName = driver.findElement(searchResult).getText();
    		log.info("The User name found : " + uName);
    		return uName;
    		
    	}catch (NoSuchElementException e) {
    		log.info("The searched result not found!");
    		return null;
    	}catch(Exception e1) {
    		e1.printStackTrace();
    	}
		return null;
    }
    
    public void clickDeleteBtn(String value) throws InterruptedException {
        driver.findElement(By.xpath(deleteButton.replace("placeHolder", value))).click();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        log.info("Clicked on delete user button");
    }
    
    public void clickOkBtn() throws InterruptedException {
        driver.findElement(okBtn).click();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        log.info("Clicked on delete user button");
    }


}
