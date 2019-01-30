package br.co.figueira.pages;

import org.openqa.selenium.By;
import br.co.figueira.BasePage;
import br.co.figueira.DriveFactory;

public class LoginPage extends BasePage {
	
	//Page Access//
	public void acessar() {
		DriveFactory.getDriver().get("https://srbarriga.herokuapp.com/login");
	}
	
	// Set Text //
	
	public void setEmail(String email) {
		dsl.escrever("email", email);
	}
	
	public void setPassword(String password) {
		dsl.escrever("senha", password);
	}
	
	// Buttons
	
	public void buttonEntrar() {
		dsl.clicarBotao(By.xpath("//button[@type='submit']"));
	}
	
	//return//
	
	public String acessError() {
		return dsl.retornaTxtPag(By.xpath("//div[@class='alert alert-danger']"));
	}
	
	public String acessSuccess() {
		return dsl.retornaTxtPag(By.xpath("//div[@class='alert alert-success']"));
	}
	
	
}
