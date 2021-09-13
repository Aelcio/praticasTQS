package listaTrabalho;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercicio01_2 {
	WebDriver navegador;

	@Before
	public void preCondicao() {
		System.setProperty("webdriver.chrome.driver",
				"/Users/Maru/eclipse-workspace/aula-selenium/chromeDriver/chromedriver.exe");
		navegador = new ChromeDriver();
		navegador.get("http://www.linkedin.com/");
		navegador.manage().window().maximize();
	}

	@Test
	public void informaCampos() {
		WebElement BtnEntrar = navegador.findElement(By.xpath("/html/body/nav/div/a[2]"));
		BtnEntrar.click();

		WebElement campoLogin = navegador.findElement(By.xpath("//*[@id=\"username\"]"));
		campoLogin.click();
		campoLogin.clear();
		campoLogin.sendKeys("aelciosrmacedo@gmail.com");

		WebElement campoSenha = navegador.findElement(By.xpath("//*[@id=\"password\"]"));
		campoSenha.click();
		campoSenha.clear();
		campoSenha.sendKeys("11092014");

		WebElement BtnLogar = navegador.findElement(By.xpath("//*[@id=\"organic-div\"]/form/div[3]/button"));
		BtnLogar.click();
	}
	
	@Test
	public void validarUrl() {
		Assert.assertFalse(navegador.getCurrentUrl().equals("http://www.facebook.com"));
		Assert.assertTrue(navegador.getCurrentUrl().equals("https://www.linkedin.com/"));
	}
	
	@After
	public void fecharNavegador() {
		navegador.quit();
	}
}
