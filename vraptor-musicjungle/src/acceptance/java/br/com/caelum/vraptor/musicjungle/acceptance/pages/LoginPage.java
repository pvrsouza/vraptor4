package br.com.caelum.vraptor.musicjungle.acceptance.pages;

import static org.openqa.selenium.By.cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageObject {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void loginAsUser(String user) {
		createUser(user);
		By cssSelector = cssSelector("form:nth-child(1)");
		PageForm form = new PageForm(driver, cssSelector);
		form.input("login", user);
		form.input("password", user);
		form.submitForm();
	}

	private void createUser(String value) {
		By cssSelector = cssSelector("form:nth-child(2)");
		PageForm form = new PageForm(driver, cssSelector);
		form.input("user.name", value);
		form.input("user.login", value);
		form.input("user.password", value);
		form.submitForm();
	}

	public void logout() {
		driver.findElement(By.linkText("Logout")).click();
	}
	
}