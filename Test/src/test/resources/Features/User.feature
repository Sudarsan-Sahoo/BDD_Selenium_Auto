Feature: FC-001 New User
  I want to succesfully add and delete an user in the system

  Scenario Outline: Successful new user creation
    Given I launch the url as "<url>"
    When I clicked on the Add User button
    Then I am able to see the pop-up with user details
    When I enter "<fname>" as First Name
    And I enter "<lName>" as Last Name
    And I enter "<uName>" as User Name
    And I enter "<password>" as Password
    And I select "<customer>" as Customer
    And I select "<role>" as Role
    And I enter "<email>" as E-mail
    And I enter "<cellPhone>" as Cell Phone
    When I click on the Save button
    Then I should see the new user "<uName>" created and shown in the list


    Examples:
      | url                                                            | fname    	| lName 	| uName   | password | customer    	| role     | email              | cellPhone  |	
      | https://www.way2automation.com/angularjs-protractor/webtables/ | Name_First | Name_Last | user001 | P@55w0rd | Company BBB	| Customer | first_last@abc.com | 1234567890 |	
      

Scenario Outline: Successful user deletion
    Given I launch the url as "<url>"
    When I delete "<userTobeDeleted>" user from the list
    Then I see not see the "<userTobeDeleted>" in the list


    Examples:
      | url                                                            | userTobeDeleted	| 
      | https://www.way2automation.com/angularjs-protractor/webtables/ | novak				| 
