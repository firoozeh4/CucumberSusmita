package steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import page.AccountListPage;
import page.BasePage;
import page.NewAccountPage;

public class AddAccountStepDefinition extends BasePage{

	
	NewAccountPage newAccountPage = PageFactory.initElements(driver,NewAccountPage.class );
	AccountListPage accountListPage = PageFactory.initElements(driver,AccountListPage.class );
	
	@And ("User enters {string} in the {string} field in accounts page")
	public void userEnterDetailsInNewAccounts(String value, String field) {
		 switch (field.toLowerCase()) {
         case "accountname":
        	 try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	 newAccountPage.enterAccountName(value);
             break;
         case "description":
        	 newAccountPage.enterDescription(value);
             break;
         case "initialbalance":
        	 newAccountPage.enterInitialBalance(value);
             break;
         case "accountnumber":
        	 newAccountPage.enterAccountNumber(value);
             break;
         case "contactperson":
        	 newAccountPage.enterContactPerson(value);
             break;
         default:
             System.out.println("Enter valid credential");
             break;
		 }
	}
	
	
	@Then ("User should be able to validate account created successfully")
	public void validateAccountCreated()
	{
		String expected_value = "123susmita";
		String actual_value = accountListPage.validateAccountList();
		Assert.assertEquals("Account created is not found", expected_value, actual_value);
		screenshot( driver);
	}
}
