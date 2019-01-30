package br.co.figueira.pages;

import org.openqa.selenium.By;

import br.co.figueira.BasePage;

public class ContasPage extends BasePage {
	
	public void adicionarNome(String nome) {
		dsl.escrever("nome", nome);
	}
	
	public void clicarSalvar() {
		dsl.clicarBotao(By.xpath("//button[@type='submit']"));
	}
	
	public String mensagemDeConfirmação() {
		return dsl.retornaTxtPag(By.xpath("//div[@class='alert alert-success']"));
	}
	
	public String mensagemDeErro() {
		return dsl.retornaTxtPag(By.xpath("//div[@class='alert alert-danger']"));
	}
	
	public void alterarConta(String conta) {
		dsl.clicarBotao(By.xpath(".//td[contains(text(),'"+conta+"')]/../td//span[@class='glyphicon glyphicon-edit']"));
	}
	
	public void removerConta(String conta) {
		dsl.clicarBotao(By.xpath(".//td[contains(text(),'"+conta+"')]/../td//span[@class='glyphicon glyphicon-remove-circle']"));
	}

}



