## Java-TestNg-Selenium
This code is provided for To_DO APP Testing Scenario . Your  testing environments may require you to modify this framework. 
### Environment Setup

1. Global Dependencies
    * [Install Maven](https://maven.apache.org/install.html)
    * Or Install Maven with [Homebrew](http://brew.sh/)
    ```
2. Project Dependencies
	* Check that Packages are available
	 mvn test-compile
	
	* You may also want to run the command below to check for outdated dependencies. Please be sure to verify and review updates before editing your pom.xml file. The updated packages may or may not be compatible with your code.
	```
	 mvn versions:display-dependency-updates
	
### Running Tests
	```
	 mvn clean test

### what is being tested- 
1. Verify user can add todo item in text box
2. Verify  user can see  added Items in List 
3. Verify User can delete the item from list
4. Verify User can edit to do items by double clicking on added item
5. Verify user not allowed to  add items consisting only of whitespaces.
6.Verify for Duplicate ToDo items.


### How tests are organized & Being Tested-
1. We have 2  key file folder  main & test to run all tests.
2. In Main we maintain 3 files - application, reports & Testintializer.
3. in Application ->ToDo _app java file -> where we maintain  Page fatory pattern for getting web-elements and define two Method which is called by Test Method from Todo_AppTest file under test folder. 
4. in Test folder -> ToDoAppTest -> where we maintain @Test method for test cases we want to run.
5. in reports-> we are mainiting code for extend report but i have used testNG surefire Report->indexHtml.
6. in Testinitializer -> BasePage->   maintaining all kind of synchronization methods and all Utility methods.
7.  in in Testinitializer -> BrowserConfigation-> mainating which browser need to use- chrome/firefox and head or headless etc.
8.POM.XMl- For all project level dependencies  

### Resources

##### [SeleniumHQ Documentation](http://www.seleniumhq.org/docs/)

##### [TestNg Documentation](http://testng.org/javadocs/index.html)

##### [Java Documentation](https://docs.oracle.com/javase/7/docs/api/)
