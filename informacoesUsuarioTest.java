package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class informacoesUsuarioTest {
    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario() {
        //opening the browser
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\allys\\drivers\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        navegador.manage().window().maximize();

        //navigating to a page of taskit
        navegador.get("http://www.juliodelima.com.br/taskit/");

        //clicking the link with text "sign in"
        navegador.findElement(By.linkText("Sign in")).click();

        //identifying the form with id="signinbox"
        WebElement  formularioSignInBox = navegador.findElement(By.id("signinbox"));

        //clicking the box name="login" in form with id="signinbox" and typing the login "julio0001"
        formularioSignInBox.findElement(By.name("login")).sendKeys("julio0001");

        //clicking the box name: "password" in form with id="signinbox"
        formularioSignInBox.findElement(By.name("password")).sendKeys("123456");

        //typing the password 123456

        //clicking the link "SIGN IN"
        formularioSignInBox.findElement(By.linkText("SIGN IN")).click();

        //checking text "Hi, Julio" in the class "me"
        WebElement me = navegador.findElement(By.className("me"));
        String textoNoElementoMe = me.getText();
        assertEquals("Hi, Julio", textoNoElementoMe);

        //finishing the session
        navegador.quit();

    }
}
