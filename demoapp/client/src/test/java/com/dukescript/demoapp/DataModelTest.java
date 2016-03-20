package com.dukescript.demoapp;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class DataModelTest {
    @Test public void testUIModelWithoutUI() {
        Data model = new Data();
    }
    @Test public void add(){
        Data model = new Data();
        for(int i = 0; i < 10; i++){
            model.getGraph().getStates().add(new StateTupel());
        }
        assertTrue(model.getGraph().getStates().size() == 10);
    }
    
    @Test public void connect(){
        Data model = new Data();
        for(int i = 0; i < 10; i++){
            model.getGraph().getStates().add(new StateTupel());
        }
        for(StateTupel t : model.getGraph().getStates()){
            
        }
    }
}
