package com.aera.hotwire.test;

import com.aera.hotwire.application.Hotwire;
import com.aera.hotwire.application.ToDo_App;
import com.aera.hotwire.testInitializer.BrowserConfiguration;
import org.testng.annotations.Test;

public class HotwireTest extends BrowserConfiguration {

    @Test
    public void searchResult() throws Exception{
        ToDo_App todo = new ToDo_App(getDriver());
        todo.toDOTask();
    }
}