package br.co.figueira.pages;

import org.openqa.selenium.By;

import br.co.figueira.BasePage;

public class CadastroPage extends BasePage {
	
		// Set Text //
		
		public void setEmail(String email) {
			dsl.escrever("email", email);
		}
		
		public void setPassword(String password) {
			dsl.escrever("senha", password);
		}
		
		public void setName(String name) {
			dsl.escrever("nome", name);
		}
		
		//buttons
		
		public void buttonCadastrar() {
			dsl.clicarBotao(By.xpath("//input[@value='Cadastrar']"));
		}
		
		//links//
		
		public void cadastrarUsuario() {
			dsl.clicarLink("Novo usuário?");
		}	
		
		//return//
		
		public String cadastroError() {
			return dsl.retornaTxtPag(By.xpath("//div[@class='alert alert-danger']"));
		}
		
		public String cadastroSuccess() {
			return dsl.retornaTxtPag(By.xpath("//div[@class='alert alert-success']"));
		}
		
	}

