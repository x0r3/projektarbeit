package com.dukescript.demoapp;

import com.dukescript.api.canvas.*;
import net.java.html.json.ComputedProperty;
import net.java.html.json.Function;
import net.java.html.json.Model;
import net.java.html.json.Property;
import com.dukescript.demoapp.js.Dialogs;
import com.dukescript.impl.canvas.HTML5GraphicsEnvironment;
import javafx.scene.*;
import javafx.scene.chart.PieChart;
import net.java.html.BrwsrCtx;

/** Model annotation generates class Data with
 * one message property, boolean property and read only words property
 */
@Model(className = "DemoappUI", targetId="", properties = {
    @Property(name = "infoMessage", type = String.class),
    @Property(name = "rotating", type = boolean.class),
    @Property(name = "first", type = int.class),
    @Property(name = "second", type = int.class)
})

final class DemoppUIController {
    
    @ComputedProperty static java.util.List<String> words(String infoMessage) {
        String[] arr = new String[6];
        String[] words = infoMessage == null ? new String[0] : infoMessage.split(" ", 6);
        for (int i = 0; i < 6; i++) {
            arr[i] = words.length > i ? words[i] : "!";
        }
        return java.util.Arrays.asList(arr);
    }
    
    
    @Function static void turnAnimationOn(DemoappUI model) {
        model.setRotating(true);
    }

    @Function static void turnAnimationOff(final DemoappUI model) {
        
        Dialogs.confirmByUser("Really turn off?", new Runnable() {
            @Override
            public void run() {
                model.setRotating(false);
            }
        });
    }
    

    @Function static void rotate5s(final DemoappUI model) {
       
        model.setRotating(true);
        java.util.Timer timer = new java.util.Timer("Rotates a while");
        timer.schedule(new java.util.TimerTask() {
            @Override
            public void run() {
                model.setRotating(false);
            }
        }, 5000);
    }

    @Function static void showScreenSize(DemoappUI model) {
        model.setInfoMessage(Dialogs.screenSize());
    }
    
    @Function static void drawSmallerRect(DemoappUI model){
        ctx.strokeRect(100, 100, 200, 200);
        ctx.stroke();
    }
    //Primitive Datentypen werden im entsprechenden Model gehalten
    private static DemoappUI ui;
    /*Komplexe Datentypen werden nicht im Model gehalten? 
    Vermutung: 
    #1: Knockout.js besitzt keine Bindings welche für Komplexe Daten-
    typen geeignet sind. Klassiker wie "text", "enable", "click" macht
    per Definition keinen Sinn Sondern erwarten Eingaben oder Aktionen.
    2#: Auf das Model-Objekt wird später per applyBindings() die relevanten
    Bindings aufgetragen. Ein weiteres Indiz dass nur entsprechende Bindings
    für ein Canvas, eine Aufnahme ins Model-Objekt sinnvoll erscheinen lassen.
    
    */
    private static GraphicsContext2D ctx;
    
    /**
     * Called when the page is ready.
     */
    static void onPageLoad() throws Exception {
        /*
        

        ctx.strokeRect(50,50, 200, 200);
        ctx.stroke();
                */
        
        ctx = GraphicsContext2D.getOrCreate("myCanvas");
        ctx.setHeight(400);
        ctx.setWidth(1000);
        //System.out.println(Dialogs.getSreenWidth());
        ui = new DemoappUI();
        ui.setInfoMessage("Andreas ischen Stinker!");
        ui.applyBindings();

    }
}
