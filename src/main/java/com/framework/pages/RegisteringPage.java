package com.framework.pages;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;

	import com.framework.base.BasePage;

	public class RegisteringPage extends BasePage {

		public RegisteringPage(WebDriver driver) {
			super(driver);            // BasePage runs PageFactory.initElements
		}

		// ---------- Locators ----------
		@FindBy(linkText = "Register")
		private WebElement registerLink;

		@FindBy(id = "customer.firstName")
		private WebElement firstName;

		@FindBy(id = "customer.lastName")
		private WebElement lastName;

		@FindBy(id = "customer.address.street")
		private WebElement street;

		@FindBy(id = "customer.address.city")
		private WebElement city;

		@FindBy(id = "customer.address.state")
		private WebElement state;

		@FindBy(id = "customer.address.zipCode")
		private WebElement zipCode;

		@FindBy(id = "customer.phoneNumber")
		private WebElement phoneNumber;

		@FindBy(id = "customer.ssn")
		private WebElement ssn;

		@FindBy(id = "customer.username")
		private WebElement username;

		@FindBy(id = "customer.password")
		private WebElement password;

		@FindBy(id = "repeatedPassword")
		private WebElement confirmPassword;

		@FindBy(css = "input[value='Register']")
		private WebElement registerButton;

		@FindBy(css = "div#rightPanel h1.title")
		private WebElement welcomeHeading;

		// ---------- Actions ----------
		public void openRegisterForm() {
			registerLink.click();
		}

		public void register(String first, String last, String addr, String cityName,
				String stateName, String zip, String phone, String ssnNo,
				String user, String pass) {
			firstName.sendKeys(first);
			lastName.sendKeys(last);
			street.sendKeys(addr);
			city.sendKeys(cityName);
			state.sendKeys(stateName);
			zipCode.sendKeys(zip);
			phoneNumber.sendKeys(phone);
			ssn.sendKeys(ssnNo);
			username.sendKeys(user);
			password.sendKeys(pass);
			confirmPassword.sendKeys(pass);
			registerButton.click();
		}

		// ---------- State (the test asserts on this) ----------
		public String getWelcomeHeading() {
			return welcomeHeading.getText();
		}
	}


