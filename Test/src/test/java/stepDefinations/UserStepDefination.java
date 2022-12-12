package stepDefinations;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import page.objects.UserPage;


public class UserStepDefination{
	UserPage uPage= new UserPage();
	@Given("^I launch the url as \"([^\"]*)\"$")
	public void i_launch_the_url(String url) {
		uPage.launchApplication(url);
	}

	@When("I clicked on the Add User button")
	public void i_clicked_on_the_add_user_button() {
	    uPage.clickAddUser();
	    
	}

	@Then("I am able to see the pop-up with user details")
	public void i_am_able_to_see_the_pop_up_with_user_details() {
	    System.out.println("I see the Add User pop-up");
	}

	@When("I enter {string} as First Name")
	public void i_enter_as_first_name(String fName) {
	    uPage.enterFirstName(fName);
	}

	@When("I enter {string} as Last Name")
	public void i_enter_as_last_name(String lName) {
		uPage.enterLastName(lName);
	}

	@When("I enter {string} as User Name")
	public void i_enter_as_user_name(String userName) {
		uPage.enterUserName(userName);
	}

	@When("I enter {string} as Password")
	public void i_enter_as_password(String password) {
	    uPage.enterPassword(password);
	}

	@When("I select {string} as Customer")
	public void i_select_as_customer(String selectCustomer) {
	    Assert.assertTrue(uPage.selectCustomer(selectCustomer),"Not able to select Customer!");
	}

	@When("I select {string} as Role")
	public void i_select_as_role(String role) {
	    uPage.selectRole(role);
	}

	@When("I enter {string} as E-mail")
	public void i_enter_as_e_mail(String emailId) {
	    uPage.insertEmail(emailId);
	}

	@When("I enter {string} as Cell Phone")
	public void i_enter_as_cell_phone(String phone) {
	    uPage.insertCellPhone(phone);
	}

	@When("I click on the Save button")
	public void i_click_on_the_save_button() {
	    uPage.clickSaveBtn();
	}

	@Then("I should see the new user {string} created and shown in the list")
	public void i_should_see_the_new_user_created_and_shown_in_the_list(String user) {
	    uPage.searchUser(user);
	    String result = uPage.getUserNameFromSearchedResult();
	    Assert.assertEquals(user,result,"User addition was not succesful!");
	}
	
	@When("I delete {string} user from the list")
	public void i_delete_user_from_the_list(String user) throws InterruptedException {
//		uPage.searchUser(user);
		uPage.clickDeleteBtn(user);
		uPage.clickOkBtn();
	}
	@Then("I see not see the {string} in the list")
	public void i_see_not_see_the_in_the_list(String user) {
		uPage.searchUser(user);
		String result= uPage.getUserNameFromSearchedResult();
		Assert.assertEquals(null,result,"User deletion was not succesful!");
	}
		

}
