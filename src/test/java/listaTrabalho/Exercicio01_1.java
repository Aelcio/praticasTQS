package listaTrabalho;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercicio01_1 {

	WebDriver navegador;

	@Before
	public void preCondicao() {
		System.setProperty("webdriver.chrome.driver",
				"/Users/Maru/eclipse-workspace/aula-selenium/chromeDriver/chromedriver.exe");
		navegador = new ChromeDriver();
		navegador.get("http://www.gmail.com");
		navegador.manage().window().maximize();
	}

	@Test
	public void informaCampos() {
		WebElement campoLogin = navegador.findElement(By.name("identifier"));
		campoLogin.click();
		campoLogin.clear();
		campoLogin.sendKeys("aelciosrmacedo@gmail.com");
		
		WebElement BtnNext = navegador.findElement(By.id("identifierNext"));
		BtnNext.click();
	}

	@Test
	public void validarUrl() {
		Assert.assertFalse(navegador.getCurrentUrl().equals("http://www.uol.com"));
		Assert.assertTrue(navegador.getCurrentUrl().equals(
				"https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin"));
	}

	@Test
	public void validarValorDigitadoCampoLogin() {
		String login = "";
		System.out.println(login);		
	}

	@After
	public void fecharNavegador() {
		navegador.quit();
	}
}