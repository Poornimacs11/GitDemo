package stepDefinitions;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.LandingPage;
import pageObject.LoginPage;
import pageObject.PortalHomePage;
import resources.base;

public class stepDefinition extends base{
@Given("^Initialize the browser with Chrome$")
public void initialize_the_browser_with_chrome() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	driver = initializeDriver();
	
}
@Given("^Navigate to \"([^\"]*)\" site$")
public void navigate_to_something_site(String strArg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	driver.get(strArg1);
}
@Given("^click on login link in home page to land on Secure signin page$")
public void click_on_login_link_in_home_page_to_land_on_secure_signin_page() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	LandingPage lp= new LandingPage(driver);
	LoginPage l = lp.getLogin();
}
@When("^the user enters \"([^\"]*)\" and \"([^\"]*)\" and logs in$")
public void the_user_enters_something_and_something_and_logs_in(String strArg1, String strArg2) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    LoginPage l = new LoginPage(driver);
	l.getId().sendKeys(strArg1);
	l.getPass().sendKeys(strArg2);
	l.getLogin().click();
}
@Then("^verify that the user is successfully logged in$")
public void verify_that_the_user_is_successfully_logged_in() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    PortalHomePage php = new PortalHomePage(driver);
    php.getSearchBox();
}

}