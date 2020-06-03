package coom.ua;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookDetaledPage {

     WebDriver driver;

    public BookDetaledPage(WebDriver driver) {
        this.driver = driver;
    }

    public  String title= "/html/body/div[2]/div[1]/div[4]/div[2]/div/h1/span[1]";
    public  String autor = "/html/body/div[2]/div[1]/div[4]/div[3]/div/span[1]/span[1]/a[1]";
   public String best = " /html/body/div[2]/div[1]/div[4]/div[7]/div/a/i";


    public Book findBestBook() {
        Book expectedBook = new Book();
        expectedBook.setTitle(driver.findElement(By.xpath(title)).getText());
        expectedBook.setAuthor(driver.findElement(By.xpath(autor)).getText());
        if (!driver.findElements(By.xpath(best)).isEmpty()) {
            expectedBook.setBest(true);
        } else
            expectedBook.setBest(false);
        return expectedBook;
    }


}
