package br.co.figueira.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


import br.co.figueira.BaseTest;
import br.co.figueira.DriveFactory;
import br.co.figueira.pages.CadastroPage;



public class TestCadastro extends BaseTest {
	
	private CadastroPage page;
	
	@Before
	public void inicializar() {
		
		DriveFactory.getDriver().get("https://srbarriga.herokuapp.com/login");
		page = new CadastroPage();
	}
	
	@Test
	public void cadastroNomeObrigatorio() {
		//clicar no bot�o cadastrar
		
		page.cadastrarUsuario();
				
		//preencher dados
		
		page.setName("");
		page.setEmail("maria.jose@gmail.com");
		page.setPassword("123456");
		page.buttonCadastrar();
		
		//verificar mensagem do cadastro
		
		Assert.assertEquals("Nome � um campo obrigat�rio", page.cadastroError());
	}
	
	@Test
	public void cadastroEmailObrigatorio() {
		//clicar no bot�o cadastrar
		
		page.cadastrarUsuario();
				
		//preencher dados
		
		page.setName("Maria");
		page.setEmail("");
		page.setPassword("123456");
		page.buttonCadastrar();
		
		//verificar mensagem do cadastro
		
		Assert.assertEquals("Email � um campo obrigat�rio", page.cadastroError());
	}
	
	@Test
	public void cadastroSenhaObrigatorio() {
		//clicar no bot�o cadastrar
		
		page.cadastrarUsuario();
				
		//preencher dados
		
		page.setName("Maria");
		page.setEmail("maria.jose@gmail.com");
		page.setPassword("");
		page.buttonCadastrar();
		
		//verificar mensagem do cadastro
		
		Assert.assertEquals("Senha � um campo obrigat�rio", page.cadastroError());
	}
	
	@Test
	@Ignore
	public void novoCadastro() {
		
		//clicar no bot�o cadastrar
		
		page.cadastrarUsuario();
		
		//preencher dados
		
		page.setName("Maria");
		page.setEmail("maria.jose@gmail.com");
		page.setPassword("123456");
		page.buttonCadastrar();
		
		//verificar mensagem do cadastro
		
		Assert.assertEquals("Usu�rio inserido com sucesso", page.cadastroSuccess());
	}

}
