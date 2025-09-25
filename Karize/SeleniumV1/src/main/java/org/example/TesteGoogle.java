package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteGoogle {
    public static void main(String[] args) {
        // Apontar o caminho do driver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\matheus_leite150\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Abrir o Chrome
        WebDriver driver = new ChromeDriver();



        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        loginButton.click();

        String currentUrl = driver.getCurrentUrl();

        if (currentUrl.contains("inventory")) {
            System.out.println("✅ Login realizado com sucesso!");
        } else {
            System.out.println("❌ Falha no login!");
        }
    }
}

