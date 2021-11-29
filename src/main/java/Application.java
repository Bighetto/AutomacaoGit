import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;

public class Application {

    public static WebDriver chrome;


    public static void main(String[] args) {

        chrome = new ChromeDriver();

        chrome.get("https://github.com/Bighetto");

        WebElement seguir = chrome.findElement(By.xpath("//a[@class='btn btn-block']"));

        seguir.click();

        WebElement login = chrome.findElement(By.xpath("//input[@id='login_field']"));

        login.sendKeys("UserExample");

        WebElement senha = chrome.findElement(By.xpath("//input[@id='password']"));

        senha.sendKeys("SenhaExample");

        WebElement sendKeys = chrome.findElement(By.xpath("//input[@value='Sign in']"));

        sendKeys.click();

        WebElement follow = chrome.findElement(By.xpath("//input[@class='btn btn-block'] [@value='Follow']"));

        follow.click();

    }

    private static WebElement fluentWait(final By localizador){
        Wait<WebDriver> wait = new FluentWait<>(chrome)
                .withTimeout(Duration.ofSeconds(60))//Limite de tempo que uma busca de um elemento deve ser realizada
                .pollingEvery(Duration.ofSeconds(1))//com que frequencia um elemento deve ser buscado na tela
                .ignoring(NoSuchElementException.class);
        return wait.until((webdriver) -> chrome.findElement(localizador));
    }
    private static List<WebElement> fluentList(final By localizador){
        Wait<WebDriver> wait = new FluentWait<>(chrome)
                .withTimeout(Duration.ofSeconds(60))//Limite de tempo que uma busca de um elemento deve ser realizada
                .pollingEvery(Duration.ofSeconds(1))//com que frequencia um elemento deve ser buscado na tela
                .ignoring(NoSuchElementException.class);
        return wait.until((webdriver) -> chrome.findElements(localizador));
    }
}
