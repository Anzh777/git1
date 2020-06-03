package coom.ua;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestSearchPage {

    private WebDriver driver;
    private Book book;
    private Book expectedBook;

    @BeforeTest
    public void beforeTest() {

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
        WebDriverWait wait = new WebDriverWait(driver, 30);


    }

    @Test
    public void findBooks() {

        SearchPage searchPage = new SearchPage(driver);
        searchPage.enterSameWord();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        searchPage.clickFilterButton();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        searchPage.choiceFilter();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        searchPage.clickFindButton();

        List<Book> listOfBooks = new ArrayList<>();

        for (int i = 1; i <= searchPage.getNumberOfSearching(); i++) {
            Book book = new Book();
            book.setTitle(searchPage.getBookTitleByIndex(i));
            book.setAuthor(searchPage.getBookAuthorByIndex(i));
            book.setBest(searchPage.isBookByIndexBestSeller(i));

            listOfBooks.add(book);
        }

        driver.get("https://www.amazon.com/Head-First-Java-Kathy-Sierra/dp/0596009208/ref=sr_1_3");
        BookDetaledPage bookDetaledPage = new BookDetaledPage(driver);

        System.out.println(listOfBooks);
        System.out.println(bookDetaledPage.findBestBook());
        Assert.assertTrue(listOfBooks.contains(bookDetaledPage.findBestBook()), "Expected book isn't exist in the list");

    }
    @AfterTest
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}




