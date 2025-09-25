import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

public class TesteGooglePesquisa {

    WebDriver driver;

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();
    }

    @Test
    public void testeGooglePesquisa() {
        driver.get("https://www.youtube.com");

        WebElement searchBox = driver.findElement(By.name("search_query"));

        String pesquisa = "VAZIO ROXO";
        searchBox.sendKeys(pesquisa);

        searchBox.sendKeys(Keys.RETURN);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<WebElement> videos = driver.findElements(By.id("video-title"));

        if (videos.size() >= 3){
            videos.get(2).click();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String pageTitle = driver.getTitle();
        if (pageTitle.contains(pesquisa)) {
            System.out.println("Teste de busca bem-sucedido! O título da página contém '"+pesquisa+"'.");
        } else {
            System.out.println("Teste de busca falhou! O título da página não contém 'Selenium'.");
        }
    }

    @AfterEach
    public void tearDown() {
        if (driver != null){
            driver.quit();
    }

}
}
