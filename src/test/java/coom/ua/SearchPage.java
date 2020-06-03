package coom.ua;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SearchPage {
    WebDriver driver;
    By element = By.xpath("//*[@id=\"twotabsearchtextbox\"]");
    By button = By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input");



    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterSameWord() {
        driver.findElement(element).sendKeys("java");
    }

    public void clickFindButton() {
        driver.findElement(button).click();
    }

    public void clickFilterButton() {
        driver.findElement(By.id("searchDropdownBox")).click();
    }

    public void choiceFilter() {

        Select filtres = new Select(driver.findElement(By.id("searchDropdownBox")));
        filtres.selectByIndex(5);
    }

    public int getNumberOfSearching() {
        return driver.findElements(By.xpath("//div[@data-component-type='s-search-result']")).size();
    }

    public String getBookTitleByIndex(int index) {
        return driver.findElement(By.xpath("//div[@data-component-type='s-search-result'][" + index + "]//h2//span")).getText();
    }

    public String getBookAuthorByIndex(int index) {
        return driver.findElement(By.xpath("//div[@data-component-type='s-search-result'][" + index + "]//h2/../div/*[2]")).getText();
    }

    public boolean isBookByIndexBestSeller(int index){
        if (!driver.findElements(By.xpath("//div[@data-component-type='s-search-result'][" + index + "]//span[contains(@id, 'best-seller-label')]")).isEmpty()){
            return true;
        } else {
            return false;
        }
    }




}


