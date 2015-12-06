package com.dukescript.demoapp;

import net.java.html.json.ComputedProperty;
import net.java.html.json.Function;
import net.java.html.json.Model;
import net.java.html.json.Property;
import com.dukescript.api.canvas.*;
import com.dukescript.demoapp.js.Dialogs;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import net.java.html.js.JavaScriptBody;
import net.java.html.json.Models;





@Model(className = "Data", targetId="", properties = {
    @Property(name = "states", type= StateTupel.class, array = true),
    // Für Anzeige der Mausposition im Canvas
    @Property(name = "xCoord", type = int.class),
    @Property(name = "yCoord", type = int.class),
    @Property(name = "mode", type = String.class),
    @Property(name = "displayString", type = String.class),
})

final class DataModel {
    
    @Model(className = "StateTupel", targetId="", properties = {
        @Property(name="id", type = String.class),
        @Property(name="transitions", type = Transition.class, array = true),
        @Property(name="coords", type = int.class, array = true),
        @Property(name ="diameter", type = int.class),
        @Property(name = "color", type = String.class)
    })
    static class stateTupelModel {
        
            @Function static void removeTransition(StateTupel st){      
            st.getTransitions().remove(st.getTransitions().size()-1);
            }
            
            @Function static void addTransition(StateTupel st){  
            st.getTransitions().add(new Transition());
            
            }
    }
    
    @Model(className ="Transition", targetId = "", properties = {
        @Property(name="value", type = String.class),
        @Property(name="to", type = String.class),
        @Property(name="coordsFrom", type = int.class, array = true),
        @Property(name="coordsTo", type = int.class, array = true)
    })
    
    static class TransitionModel {

        
    }
    /*
    @ComputedProperty static String message(java.util.List<StateTupel> states){
        String ms = "Zustände ohne Namen können nicht gemalt werden";
        String ms2 = "Alles OK!";
            for(StateTupel st: states){
                if(st.getId().equals("")){
                    return ms;
                }
            }
            return ms2;
    }
    */
    // Schwachsinn oder nötig? Wieso kann man keine Setter/Getter bentuzen aus
    // einer ComputedProperty heraus?

    
    private static Data ui;
    private static GraphicsContext2D ctx = GraphicsContext2D.getOrCreate("myCanvas");
    private static double gridSize;
    private static double gridCountWidth;
    private static double gridCountHeight;
    private static int screenWidth = Dialogs.getSreenWidth();
    private static int screenHeight = Dialogs.getSreenHeight();
    private static int guiWidth = Dialogs.getGuiWidth();
    private static int guiHeight = Dialogs.getGuiHeight();
    private static StateTupel TupelInFocus;
    private static Transition currentTransition;
    private static boolean drawing;
    
    


    @Function
    static void mousePressed(Data model, int realX, int realY) {
        //Aktualisiere Hilfskoordinaten
        updateMaus(realX, realY);
        if(ui.getMode().equals("Drag")){
            for(StateTupel st: ui.getStates()){
                if(checkCollision(realX, realY, st)){
                    st.getCoords().set(1, realX);
                    st.getCoords().set(2, realY);
                    
                }   
            }
        }
        else if(ui.getMode().equals("drawTransition")){
            if(drawing){
                currentTransition.getCoordsTo().set(1, realX);
                currentTransition.getCoordsTo().set(2, realY);
            }
        }
        draw();
    }
    
    static boolean checkCollision(double mouseX, double mouseY, StateTupel st){
        
        int stX = st.getCoords().get(1);
        int stY = st.getCoords().get(2);
        int d = st.getDiameter();
        
        if((mouseX < (stX + d)) && (mouseX > (stX - d)) && (mouseY > (stY - d)) && (mouseY < (stY + d))){
         return true;
        }  
        else return false;
    }
    

    
    @Function static void clearCanvas(){
        ctx.clearRect(0, 0, ctx.getWidth(), ctx.getHeight());
    }
    
    @Function static void handleMouseDown(){
        
        
        for(StateTupel st: ui.getStates()){
            if(checkCollision(ui.getXCoord(), ui.getYCoord(), st)){
                drawing = true;
                System.out.println("handleMouseDown: Collision detected: UI-Coords with: " + st.getId());
                TupelInFocus = st;
                if(ui.getMode().equals("drawTransition")){
                    
                    //Handle eventual Transitioning
                    currentTransition.getCoordsFrom().set(1, ui.getXCoord());
                    currentTransition.getCoordsFrom().set(2, ui.getYCoord());
                
                }
            }   
        }
    }
     
    @Function static void handleMouseUp(){
        drawing = false;
        if(ui.getMode().equals("drawTransition")){
            StateTupel from = TupelInFocus;
            for(StateTupel st : ui.getStates()){
                if(checkCollision(ui.getXCoord(),ui.getYCoord(), st)){
                    System.out.println("handleMouseUp: Collision detected: UI-Coords with " + st.getId());
                    
                    TupelInFocus = st;
                    
                    Transition t = new Transition();
                    t.setTo(st.getId());
                    
                    t.getCoordsFrom().add(0,0);
                    t.getCoordsFrom().add(1,0);
                    t.getCoordsFrom().add(2,0);
                    t.getCoordsFrom().set(1, from.getCoords().get(1));
                    t.getCoordsFrom().set(2, from.getCoords().get(2));
                    t.getCoordsTo().add(0,0);
                    t.getCoordsTo().add(1,0);
                    t.getCoordsTo().add(2,0);
                    t.getCoordsTo().set(1, TupelInFocus.getCoords().get(1));
                    t.getCoordsTo().set(2, TupelInFocus.getCoords().get(2));
                    
                    from.getTransitions().add(t);
                    System.out.println("The Following Transition was created:");
                    System.out.println("FROM: " + from.getId());
                    System.out.println("TO:" + TupelInFocus.getId());
                    System.out.println("FROM X:" + t.getCoordsFrom().get(1));
                    System.out.println("FROM Y:" + t.getCoordsFrom().get(2));
                    System.out.println("TO X:" + t.getCoordsTo().get(1));
                    System.out.println("TO Y:" + t.getCoordsTo().get(2));
                    
                    currentTransition.getCoordsFrom().set(1, 0);
                    currentTransition.getCoordsFrom().set(2, 0);
                    currentTransition.getCoordsTo().set(1, 0);
                    currentTransition.getCoordsTo().set(2, 0);
                }
            }
        draw();
        }

    }
    
    @Function static void updateMaus(int realX, int realY){
        ui.setXCoord(realX);
        ui.setYCoord(realY);
        
    }
    
    @Function static void refreshCanvas(){
        resizeCanvas();
        clearCanvas();
        initCanvas();
        draw();
    }

    @Function static void initCanvas(){
        gridSize = 100;
        gridCountWidth = (ctx.getWidth()/gridSize);
        gridCountHeight = (ctx.getHeight()/gridSize);
        
        System.out.println("Canvas Width: " + ctx.getWidth());
        System.out.println("Canvas Height: " + ctx.getHeight());
        //Vertikale Linien
        for(int i = 0; i < gridCountWidth; i++){
            ctx.beginPath();
            ctx.moveTo(gridSize * i, 0);
            ctx.lineTo(gridSize * i , ctx.getWidth());
            ctx.stroke();
        }
        // Horizontale Linien
        for(int i = 0; i < gridCountHeight; i++){
            ctx.beginPath();
            ctx.moveTo(0, gridSize * i);
            ctx.lineTo(ctx.getWidth() , gridSize * i);
            ctx.stroke();
        }
    }
    
    static void draw(){
        //initCanvas();
        //refreshCanvas();
        clearCanvas();
        //Zeichne Transitionen zuerst um überlappungen zu vermeiden
        int i = 0;
        for(StateTupel st: ui.getStates()){
            for(Transition t: st.getTransitions()){
                for(StateTupel st2: ui.getStates()){
                    if(st2.getId().equals(t.getTo())){

                        ctx.beginPath();
                        ctx.moveTo(st.getCoords().get(1), st.getCoords().get(2));
                        ctx.lineTo(st2.getCoords().get(1), st2.getCoords().get(2));
                        ctx.stroke();
                    }
                }
            }
        }
        //Zeichne Zustände
        for(StateTupel st: ui.getStates()){

            ctx.beginPath();
            // Hier ebenfalls durchmesser in Abhängigkeit von der Wortlänge
            int newDiameter = 10 +  st.getId().length() * 4;
            st.setDiameter(newDiameter);
            ctx.arc(st.getCoords().get(1), st.getCoords().get(2),newDiameter, 0, 2 * Math.PI, true);
            ctx.setFillStyle(new Style.Color(st.getColor()));
            ctx.fill();
            // Um den Text mittiger zu gestalten verschiebe ich den Text in X-Achse in Abhängigkeit der Wortlänge
            ctx.strokeText(st.getId(), st.getCoords().get(1) - (st.getId().length() * 2.2), st.getCoords().get(2));
            ctx.setStrokeStyle(new Style.Color("Lightred"));
            ctx.stroke();
            i++;
            // Zeichne die aktuell gezogene Transition
            ctx.beginPath();
            ctx.moveTo(currentTransition.getCoordsFrom().get(1), currentTransition.getCoordsFrom().get(2));
            ctx.lineTo(currentTransition.getCoordsTo().get(1), currentTransition.getCoordsTo().get(2));
            ctx.stroke();

            
        } 
    }
    
    @Function static void resizeCanvas(){
        

        screenWidth = Dialogs.getSreenWidth();
        screenHeight = Dialogs.getSreenHeight();
        guiWidth = Dialogs.getGuiWidth();
        guiHeight = Dialogs.getGuiHeight();
             
        ctx.setWidth(screenWidth - 30);
        ctx.setHeight((screenHeight - guiHeight) - 15);
        
        System.out.println("Screen Width: " + screenWidth);
        System.out.println("Screen Height: " + screenHeight);
        System.out.println("GUI Width: " + guiWidth);
        System.out.println("GUI Height: " + guiHeight);
    }
    
    @Function static void dragMode(){
        ui.setMode("Drag");
        ui.setDisplayString("Mode: Drag & Drop");
        
        
    }
    @Function static void drawTransitionMode(){
        
        ui.setMode("drawTransition");
        ui.setDisplayString("Mode: Transition Drawing");
    }
    
    @Function static void addState(){
  
        StateTupel st = new StateTupel();
        // Mir fällt gerade keine bessere Variante zum initialisieren ein
        st.getCoords().add(null);
        st.getCoords().add(null);
        st.getCoords().add(null);
        
        
        if(ui.getStates().size() < 6){
            st.setColor("rgb(" + (int)(Math.random() *  256) + "," + (int)(Math.random() *  256) + "," + (int)(Math.random() *  256) + ")");
            st.getCoords().set(2, 100);
            st.getCoords().set(1, (ui.getStates().size() * 100) + 50);
        }
        else{
            st.setColor("rgb(" + (int)(Math.random() *  256) + "," + (int)(Math.random() *  256) + "," + (int)(Math.random() *  256) + ")");
            st.getCoords().set(2, 200);
            st.getCoords().set(1,(ui.getStates().size() * 100) - 500);
                }
        
        st.setDiameter(25);
        st.setId("State " + ui.getStates().size());
        //st.getTransitions().add(new Transition());
        ui.getStates().add(st);
        draw();
        
    }
    
    @Function static void decreaseStates(){
        ui.getStates().remove(ui.getStates().size()-1);
        draw();
    }
    /**
     * Called when the page is ready.
     */
    static void onPageLoad() throws Exception {
        
        Data d = new Data();
        Models.toRaw(d);
        Dialogs.init();
        Dialogs.registerMouseBinding();
        Dialogs.registerMouseBinding2();
        ui = new Data();
        
        Transition t = new Transition();
        t.getCoordsFrom().add(0, 0);
        t.getCoordsFrom().add(1, 0);
        t.getCoordsFrom().add(2, 0);
        t.getCoordsTo().add(0, 0);
        t.getCoordsTo().add(1, 0);
        t.getCoordsTo().add(2, 0);
        currentTransition = t;
        //GEIIIL!        
                
        resizeCanvas();
        draw();
        ui.applyBindings();
    }
    
    public class Test {
        
    }
 

}


