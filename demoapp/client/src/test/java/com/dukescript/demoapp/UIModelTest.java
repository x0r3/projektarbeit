package com.dukescript.demoapp;

import net.java.html.BrwsrCtx;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class UIModelTest {

    @Test public void add(){
        UI model = new UI();
        for(int i = 0; i < 10; i++){
            model.getGraph().getStates().add(new StateTupel());
        }
        assertTrue(model.getGraph().getStates().size() == 10);
        
        model.getGraph().getStates().remove(0);
        model.getGraph().getStates().remove(0);
        model.getGraph().getStates().remove(0);
        assertTrue(model.getGraph().getStates().size() == 7);
        model.getGraph().getStates().add(new StateTupel());
        model.getGraph().getStates().add(new StateTupel());
        assertTrue(model.getGraph().getStates().size() == 9);
        
        
    }
    
    @Test public void enableDisableTest(){
        /*
        Data model = new Data();
        model.setSaveName("Test");
        assertTrue(model.isSaveEnabled());
        */
        
    }

}
