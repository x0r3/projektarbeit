package com.dukescript.demoapp;

import net.java.html.BrwsrCtx;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class DataViewModelTest {

    @Test public void add(){
        Data model = new Data();
        model.setSaveName("Test");
        for(int i = 0; i < 10; i++){
            model.getGraph().getStates().add(new StateTupel());
        }
        assertTrue(model.getGraph().getStates().size() == 10);
    }
    
    @Test public void enableDisableTest(){
        /*
        Data model = new Data();
        model.setSaveName("Test");
        assertTrue(model.isSaveEnabled());
        */
        
    }

}
