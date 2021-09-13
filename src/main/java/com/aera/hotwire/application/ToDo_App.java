package com.aera.hotwire.application;

import com.aera.hotwire.testInitializer.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.aera.hotwire.application.Hotwire.findADealBtn;

public class ToDo_App extends BasePage {

    public ToDo_App(WebDriver driver) throws Exception {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Page Factory method for getting web-elements
     */
    @FindBy(how = How.XPATH, using = "//h1[contains(text(),'todos')]")
    static WebElement homePage;

    @FindBy(how = How.XPATH, using = "//input[(@placeholder=\"What needs to be done?\")]")
    static WebElement toDoTextBox;

    @FindBy(how = How.XPATH, using = "//button[@class='destroy']")
    static WebElement deleteItem;


    @FindBy(how = How.XPATH, using = "//input[@class='toggle'] ")
    static WebElement checkItem;

    @FindBy(how = How.XPATH, using = "//button[@class='clear-completed']")
    static WebElement clearItems;

    @FindBy(how = How.XPATH, using = "//input[contains(@class,'edit')]")
    static WebElement editItem;

    @FindBy(how = How.XPATH, using = "//ul/li[*]/div/label")
    static WebElement selectList;

    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Test1')]")
    static WebElement txtBoxElement;




    public void toDOTask() throws Exception {
        waitForElementToAppear(homePage);

        waitForElementToEnable(toDoTextBox);
        Thread.sleep(9000);
        // Navigating to the TODO Text box
        toDoTextBox.click();
       /* JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", toDoTextBox);*/
        // Entering  First item  to the TODO Text box
        toDoTextBox.sendKeys("Test1");
        toDoTextBox.sendKeys(Keys.RETURN);
        Thread.sleep(6000);
        toDoTextBox.click();
        // Entering  Second  item  to the TODO Text box
        toDoTextBox.sendKeys("Test2");
        toDoTextBox.sendKeys(Keys.RETURN);
        Thread.sleep(6000);
        toDoTextBox.click();
        // Entering  Third   item  to the TODO Text box
        toDoTextBox.sendKeys("Test3");
        toDoTextBox.sendKeys(Keys.RETURN);
        Thread.sleep(6000);


        selectList.click();
        //Verify  user can see  added Items in List same as expected
        WebElement wbelement=driver.findElement(By.xpath("//ul[@class='todo-list']"));
        List<WebElement> allItems = wbelement.findElements(By.xpath("//ul/li[*]/div/label"));
        List<String> allItemsFind = new ArrayList<String>();
        System.out.println(allItems.size());
        for (int k = 1; k <= allItems.size(); k++) {

            allItemsFind.add(driver.findElement(By.xpath("/html[1]/body[1]/todo-app[1]/section[1]/section[1]/ul[1]/li["+k+"]/div[1]/label[1]")).getText());
        }
        String[] expected = {"Test1","Test2","Test3"};
// Verify  you found the right number of elements
        if (expected.length != allItems.size()) {
            System.out.println("fail, wrong number of elements found");
        }
// Verify that the value of every <option> element equals the expected value
        for (int i = 0; i < expected.length; i++) {
            String optionValue = allItemsFind.get(i);
            if (optionValue.equals(expected[i])) {
                System.out.println("passed on: " + optionValue);
            } else {
                System.out.println("failed on: " + optionValue);
            }
        }



        /*WebElement wbelement=driver.findElement(By.xpath("//ul[@class='todo-list']"));
        List<WebElement> elements = wbelement.findElements(By.xpath("//ul/li[*]/div/label"));
        for(int i=0;i<elements.size();i++){
            System.out.println(elements.get(i).getText());
            elements.get(i).click();
            break;
        }*/


        // Verify User can delete the item from list

        if ( !driver.findElement(By.xpath("//label[contains(text(),'Test1')]")).isSelected() )
        {
            driver.findElement(By.id("//label[contains(text(),'Test1')]")).click();
        }
        deleteItem.click();

        Thread.sleep(6000);

        //Verify User can edit to do items by double clicking on added item

        Actions builder=new Actions(driver);
        Action a=builder.moveToElement(txtBoxElement).doubleClick(txtBoxElement).build();
        a.perform();
        Thread.sleep(6000);

        txtBoxElement.clear();
        txtBoxElement.sendKeys("Testnew");
        txtBoxElement.sendKeys(Keys.RETURN);
        Thread.sleep(6000);

   // Verify user not allowed to  add items consisting only of whitespaces
        toDoTextBox.sendKeys(Keys.SPACE);
        toDoTextBox.sendKeys(Keys.RETURN);
        Thread.sleep(6000);




    }
}