package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class App {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();

        // 🔥 REQUIRED FOR JENKINS (headless environment)
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");

        // ✅ USE options here
        WebDriver driver = new ChromeDriver(options);

        // Open Products Page
        driver.get("https://automationexercise.com/products");

        // ❌ REMOVE maximize (not needed in headless)
        // driver.manage().window().maximize();

        // Add Product 4 to Cart
        driver.findElement(By.cssSelector("[data-product-id='4']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".btn.btn-success.close-modal.btn-block")).click();

        // Add Product 5 to Cart
        driver.findElement(By.cssSelector("[data-product-id='5']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".btn.btn-success.close-modal.btn-block")).click();

        // Add Product 6 to Cart
        driver.findElement(By.cssSelector("[data-product-id='6']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".btn.btn-success.close-modal.btn-block")).click();

        // Open Cart Page
        driver.get("https://automationexercise.com/view_cart");

        // Refresh Cart Page
        driver.navigate().refresh();

        Thread.sleep(5000);

        driver.quit();
    }
}
