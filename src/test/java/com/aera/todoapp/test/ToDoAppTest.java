package com.aera.todoapp.test;

import com.aera.toDoApp.application.ToDo_App;
import com.aera.toDoApp.testInitializer.BrowserConfiguration;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ToDoAppTest extends BrowserConfiguration {

    ToDo_App todo;

    public ToDoAppTest() throws Exception {

    }

    @BeforeTest
    public void intit() throws Exception {

        todo = new ToDo_App(getDriver());

    }

    @Test
    public void addItem() throws Exception {

        todo.addItem();
    }

    @Test
    public void itemVerification() throws Exception {
        todo.itemVerification();
    }
}