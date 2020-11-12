package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class informacoesUsuarioTest {
    private WebDriver navegador; // exposing the variable "navegador" to all methods of this class

    @Before
    public void setUp() {
        //opening the browser
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\allys\\drivers\\chromedriver.exe");
        navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //define a time-out, then the webdriver won't read the website too fast
        navegador.manage().window().maximize(); //tell the code to maximize the window

        //navigating to a page of taskit
        navegador.get("http://www.juliodelima.com.br/taskit/");
    }

    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario() {

        //clicking the link with text "sign in"
        navegador.findElement(By.linkText("Sign in")).click();
        //-linkText- searches the page looking for a element with "Sign In" in it

        //identifying the form with id="signinbox"
        WebElement  formularioSignInBox = navegador.findElement(By.id("signinbox"));
        //the "WebElement" part stores the variable "formularioSignInBox",
        // with that this sentence don't need to be repeated over and over
        //also, the objective here is to find an element by his Id, called "signinbox"

        //clicking the box name="login" in form with id="signinbox" and typing the login "julio0001"
        formularioSignInBox.findElement(By.name("login")).sendKeys("julio0001");
        //First you do formularioSignInBox (find the element with id "signinbox"
        //then search for an element with name "login" (inside "signinbox") and type "julio0001"
        //here isn't necessary to use .click() for text something, because webdriver dont read an focused element

        //clicking the box name: "password" in form with id="signinbox" and typing the password 123456
        formularioSignInBox.findElement(By.name("password")).sendKeys("123456");

        //clicking the link "SIGN IN"
        formularioSignInBox.findElement(By.linkText("SIGN IN")).click();

        //click the link with text "Hi, Julio" or class 'me'
        navegador.findElement(By.linkText("Hi, Julio")).click();

        //click the link with text "MORE DATA ABOUT YOU" or search for href "#moredata"
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();


        //click the button with "+ADD MORE DATA"

        navegador.findElement(By.xpath("//button[@data-target='addmoredata']")).click();

        //identify the form to store phone number
        WebElement storeDataPhone = navegador.findElement(By.id("addmoredata"));

        //click form with name "type"
        WebElement selectPhone = storeDataPhone.findElement(By.name("type"));

        //choose value "phone"
        new Select(selectPhone).selectByIndex(1);

        //type in contact with name "contact"
        storeDataPhone.findElement(By.name("contact")).sendKeys("+5521999999999");

        //click button with text "SAVE"
        storeDataPhone.findElement(By.linkText("SAVE")).click();

        //check if appears a message with id "toast-container" and text "Your contact has been added!"
        WebElement confirmMessage = navegador.findElement(By.id("toast-container"));
        String message = confirmMessage.getText();
        assertEquals("Your contact has been added!", message);
    }

    @After
    public void tearDown () {
        //finishing the session
        //"close" closes all windows and tabs
        //"close" closes only the opened windows by IntellijIdea
        navegador.quit();
    }
}
