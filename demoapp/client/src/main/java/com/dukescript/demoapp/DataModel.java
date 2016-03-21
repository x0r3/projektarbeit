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
import netscape.javascript.JSException;





@Model(className = "Data", targetId="", properties = {
    @Property(name = "saveName", type = String.class),
    @Property(name = "selectedGraph", type = String.class),
    @Property(name = "graph", type= Graph.class),
    @Property(name = "savedGraphs", type = Graph.class, array = true),
    // Für Anzeige der Mausposition im Canvas
    @Property(name = "xCoord", type = int.class),
    @Property(name = "yCoord", type = int.class),
    @Property(name = "mode", type = String.class),
    @Property(name = "displayString", type = String.class),
})

final class DataModel {
    
    @Model(className = "Graph", targetId="", properties = {
        @Property(name = "graphName", type = String.class),
        @Property(name = "states", type = StateTupel.class, array = true)
    })
    static class graphModel {
        
    }
    
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
            draw();
            }
            
            @Function static void addTransition(StateTupel st){  
            st.getTransitions().add(new Transition());
            draw();
            
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
    
    @ComputedProperty static java.util.List<String> options(java.util.List<Graph> savedGraphs){
        List lst = new LinkedList<String>();
        for(Graph g: savedGraphs){
            lst.add(g.getGraphName());
            System.out.println(g.getGraphName());

        }
        //System.out.println(g.getGraphName());
        System.out.println("Saved Graphs: " + savedGraphs.size());
        System.out.println("List Size: " + lst.size());
        return lst;
    }

    
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
    private static boolean dragging;
    //Zur Zwischenspeicherung von Koordinaten zur Berechnung von Ausgleichswerten für die intuitive Verschiebung
    //von Zuständen (Verhinderung des ruckartigen Sprungs im ersten Frame)
    private static int x;
    private static int y;
    


    @Function
    static void mousePressed(Data model, int realX, int realY) {
        //Aktualisiere Hilfskoordinaten
        updateMaus(realX, realY);
        if(ui.getMode().equals("Drag")){
            for(StateTupel st: ui.getGraph().getStates()){
                if(checkCollision(realX, realY, st)){
                    //Berechnung der bereinigten Koordinaten des Objektes (Berücksichtigung
                    //von Ort des Maus + Ort des Objektes -> Verhindern des ruckartigen
                    //verschiebens beim ersten Frame)
                    int deltax;
                    int deltay;
                    deltax = realX - x;
                    deltay = realY - y;
                    st.getCoords().set(1, deltax);
                    st.getCoords().set(2, deltay);
                    
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
    
    
    //Problem: ComputedProperty options funktioniert nicht wie gewollt.
    //Will man auf die Namen der Saves über die Liste der Saves so gibt es Probleme beim Speichern (Vervielfältigung)
    
    @Function
    static void saveGraph() throws Exception{

        //Noch fehlerhaft
        Graph gr = new Graph();
        ui.getGraph().setGraphName(ui.getSaveName());
        gr = ui.getGraph();
        //Notwendig da sonst Nullpointers fliegen aufgrund der Getter
        String var = gr.getGraphName();
            if(var == null){
                ui.getGraph().setGraphName("Unnamed Graph");
                ui.getSavedGraphs().add(gr);
            }else{
                ui.getSavedGraphs().add(gr);
                
            }
        draw();
        
        
        
        /* DIESE ZEILEN CODE FÜHREN HIER ZU EINER NULLPONTER AM ENDE DER MAIN NICHT MEHR
        Graph gr = new Graph();
        Graph gr2 = ui.getGraph().clone();
        ui.setGraph(gr2); // bringt auch nichts
        */
    }
    
    @Function
    static void loadGraph(){

        System.out.println("LoadGraph fired!");
        for(Graph g: ui.getSavedGraphs()){              
            
            System.out.println(g.getGraphName());
            
        }        
    }
    // Überprüft ob die Maus sich aktuell über einem relevanten Objekt befindet
    static boolean checkCollision(double mouseX, double mouseY, StateTupel st){
        
        int stX = st.getCoords().get(1);
        int stY = st.getCoords().get(2);
        int d = st.getDiameter();
        
        if((mouseX < (stX + d)) && (mouseX > (stX - d)) && (mouseY > (stY - d)) && (mouseY < (stY + d))){
            return true;
        }  
        else return false;
    }
    

    //Löschen des Canvas-Frames damit ein neues Frame gezeichnet werden kann ohne
    //Überlappungen zu erzeugen.
    @Function static void clearCanvas(){
        ctx.clearRect(0, 0, ctx.getWidth(), ctx.getHeight());
        
    }
    //Wird nur einmal bei einem Mausklick ausgeführt, genutzt um benötigte Variablen zu
    //initialisieren und das Objekt im Fokus zu bestimmen
    @Function static void handleMouseDown(Data model, int realX, int realY){
        
        for(StateTupel st: ui.getGraph().getStates()){
            if(checkCollision(ui.getXCoord(), ui.getYCoord(), st)){
                drawing = true;
                System.out.println("handleMouseDown: Collision detected: UI-Coords with: " + st.getId());
                TupelInFocus = st;
                if(ui.getMode().equals("drawTransition")){
                    
                    //Handle eventual Transitioning
                    currentTransition.getCoordsFrom().set(1, ui.getXCoord());
                    currentTransition.getCoordsFrom().set(2, ui.getYCoord());
                
                }
                if(ui.getMode().equals("Drag")){
                    x = ui.getXCoord() - st.getCoords().get(1);
                    y = ui.getYCoord() - st.getCoords().get(2);
                    dragging = true;
                }
            }   
        }
    }
     //Wird einmal beim Ablassen von der Maus ausgeführt, benutzt um Abschließende Operationen
    // auszuführen -> Erzeugen, hinzufügen eines Übergangs
    @Function static void handleMouseUp(){
        drawing = false;
        dragging = false;
        if(ui.getMode().equals("drawTransition")){
            StateTupel from = TupelInFocus;
            for(StateTupel st : ui.getGraph().getStates()){
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
    //Um die Koordinaten auf der GUI aktuell zu halten.
    @Function static void updateMaus(int realX, int realY){
        ui.setXCoord(realX);
        ui.setYCoord(realY);
        
    }
    //Wenn der benutzer den aktuellen Graph verwerfen will. Zeichnet das Canvas neu +
    //erzeugt neuen Graph.
    @Function static void newCanvas(){
        ctx.clearRect(0, 0, ctx.getWidth(), ctx.getHeight());
        ui.setGraph(new Graph());
        draw();
    }
    //Hilfsfunktion
    @Function static void refreshCanvas(){
        resizeCanvas();
        clearCanvas();
        initCanvas();
        draw();
    }
    //Zur initialisierung der Anwendung.
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
    // Zentrale Zeichenmethode. Iteriert über alle Zustände + Übergänge der Zustände und
    // zeichnet sie anhand ihrer Koordinaten
    static void draw(){

        clearCanvas();
        //Zeichne Transitionen zuerst um überlappungen zu vermeiden
        int i = 0;
        for(StateTupel st: ui.getGraph().getStates()){
            for(Transition t: st.getTransitions()){
                for(StateTupel st2: ui.getGraph().getStates()){
                    if(st2.getId().equals(t.getTo())){
                        //Beginne mit dem Zeichnen von Transitionen
                        ctx.beginPath();
                        ctx.moveTo(st.getCoords().get(1), st.getCoords().get(2));
                        ctx.lineTo(st2.getCoords().get(1), st2.getCoords().get(2));
                        ctx.stroke();
                        
                        //Relevante Koordinaten zur Darstellung des Pfeils
                        double dx = (st.getCoords().get(1) - st2.getCoords().get(1)) / 2.0;
                        double dy = (st.getCoords().get(2) - st2.getCoords().get(2)) / 2.0;
                        double absdx = Math.abs(st.getCoords().get(1) - st2.getCoords().get(1)) / 2.0;
                        double absdy = Math.abs(st.getCoords().get(2) - st2.getCoords().get(2)) / 2.0;
                        
                        //Zur Anpassung der Ausrichtung des Pfeils einer Transition auf den aktuellen Ort seines
                        //Zielzustandes.
                        double angle = 0.0;
                        angle = Math.toDegrees(Math.atan2(dy, dx));
                        angle = angle - 90;
                        
                        /*
                        Um Seiteneffekte beim Zeichnen des Zeigers zu verhindern.
                        */
                        if(dy == 0){
                            dy += 0.001;
                        }
                        if(dx == 0){
                            dx +=0.001;
                        }
                        
                        if(dx > 0 && dy > 0){
                            drawCursor(Math.abs(st.getCoords().get(1) - absdx), Math.abs(st.getCoords().get(2) - absdy), angle);

                
                        }
                        else if(dx > 0 && dy <0){
                            drawCursor(Math.abs(st.getCoords().get(1) - absdx), st.getCoords().get(2) - absdy * (-1.0), angle);

                        }
                        else if(dx < 0 && dy < 0){
                            drawCursor(st.getCoords().get(1) - absdx * (-1.0), st.getCoords().get(2) - absdy * (-1.0), angle);

                        }
                        else{
                            drawCursor(st.getCoords().get(1) - absdx * (-1.0), Math.abs(st.getCoords().get(2)) - absdy, angle);
                            //Hilfereiche Kontrollausgaben der einzelnen Koordinaten
                            double deg;
                            System.out.println("dx: " + dx);
                            System.out.println("dy: " + dy);
                            System.out.println("dx / dy :  " + dx / dy);
                            System.out.println(" abs(dx / dy) : " + Math.abs(dx / dy));
                            System.out.println(" tan(abs(dx / dy)) : " + Math.tan(Math.abs(dx / dy)));
                            System.out.println("tan(abs(dx / dy)) to Degrees : " + Math.toDegrees(Math.tan(Math.abs(dx / dy))));
                            deg = 90.0 - Math.toDegrees(Math.tan(Math.abs(dx / dy)));
                            System.out.println("deg: " + deg);  

                        }
                            
                            
                        
                    }
                }
            }
            
        }
        //Zeichnen der Zustände nach den Transitionen um das Problem der durchgezogenen Linie zu umgehen
        for(StateTupel st: ui.getGraph().getStates()){
            
            ctx.beginPath();
            // Hier ebenfalls durchmesser in Abhängigkeit von der Wortlänge
            int newDiameter = 10 +  st.getId().length() * 4;
            st.setDiameter(newDiameter);
            ctx.arc(st.getCoords().get(1), st.getCoords().get(2),newDiameter, 0, 2 * Math.PI, true);
            ctx.setFillStyle(new Style.Color(st.getColor()));
            ctx.fill();
            // Zeichne den aktuell im Fokus stehenden Zustand mit highlightening
            
            if(st.equals(TupelInFocus)){
                ctx.beginPath();
                ctx.setStrokeStyle(new Style.Color("rgb(64, 255, 0)"));
                ctx.arc(st.getCoords().get(1), st.getCoords().get(2),newDiameter + 2, 0, 2 * Math.PI, true);
                ctx.setLineWidth(5);
                ctx.stroke();
            }
            
            ctx.setLineWidth(1);
            // Um den Text mittiger zu gestalten verschiebe ich den Text in X-Achse in Abhängigkeit der Wortlänge
            ctx.beginPath();
            ctx.setStrokeStyle(new Style.Color("Black"));
            ctx.strokeText(st.getId(), st.getCoords().get(1) - (st.getId().length() * 2.2), st.getCoords().get(2));
            ctx.stroke();
            i++;
            // Zeichne die aktuell gezogene Transition
            ctx.beginPath();
            ctx.setStrokeStyle(new Style.Color("Black"));
            ctx.moveTo(currentTransition.getCoordsFrom().get(1), currentTransition.getCoordsFrom().get(2));
            ctx.lineTo(currentTransition.getCoordsTo().get(1), currentTransition.getCoordsTo().get(2));
            ctx.stroke();
        }
       
    }
    
    //Zeichnet einen Pfeil. Die Variablen x und y entsprechen dem Ort, angle entspricht der Ausrichtung von diesen
    //Koordinaten im Gradmaß.
    static void drawCursor(double x, double y, double angle){
        
        ctx.beginPath();
        double tempXTip = x + 15 * Math.sin(2 * Math.PI / 360 * angle);
        double tempYTip = y - 15 * Math.cos(2 * Math.PI / 360 * angle);
        ctx.moveTo(x, y);
        ctx.lineTo(tempXTip, tempYTip);
        ctx.moveTo(tempXTip, tempYTip);
        double tempX = x + 5 * Math.sin(2 * Math.PI / 360 * (angle - 90));
        double tempY = y - 5 * Math.cos(2 * Math.PI / 360 * (angle - 90));
        ctx.lineTo(tempX, tempY);
        tempX = x + 5 * Math.sin(2 * Math.PI / 360 * (angle + 90));
        tempY = y - 5 * Math.cos(2 * Math.PI / 360 * (angle + 90));
        ctx.lineTo(tempX, tempY);
        ctx.moveTo(tempX, tempY);
        ctx.lineTo(tempXTip, tempYTip);
        ctx.setFillStyle(new Style.Color("Black"));
        ctx.fill();
    
    }
    
    //Passt Höhe und Breite des Canvas der aktuellen Größe des Fenster an
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
    
    //Zum wechseln des Modus auf Dragging-Modus
    @Function static void dragMode(){
        ui.setMode("Drag");
        ui.setDisplayString("Mode: Drag & Drop");
        
        
    }
    //Zum wechseln des Modus auf Zeichen-Modus
    @Function static void drawTransitionMode(){
        
        ui.setMode("drawTransition");
        ui.setDisplayString("Mode: Transition Drawing");
    }
    
    //Erzeugt einen neuen Zustand und fügt ihn der Collection der Zustände hinzu. Die Farbfindung erfolgt zufällig.
    //Erreicht ein Zustand einen Ort zu weit Rechts des Canvas, wird in einer Reihe drunter neu angefangen
    //auszurichten
    @Function static void addState(){
  
        StateTupel st = new StateTupel();

        // Mir fällt gerade keine bessere Variante zum initialisieren ein
        st.getCoords().add(null);
        st.getCoords().add(null);
        st.getCoords().add(null);
        
        
        if(ui.getGraph().getStates().size() < 6){
            st.setColor("rgb(" + (int)(Math.random() *  256) + "," + (int)(Math.random() *  256) + "," + (int)(Math.random() *  256) + ")");
            st.getCoords().set(2, 100);
            st.getCoords().set(1, (ui.getGraph().getStates().size() * 100) + 50);
        }
        else{
            st.setColor("rgb(" + (int)(Math.random() *  256) + "," + (int)(Math.random() *  256) + "," + (int)(Math.random() *  256) + ")");
            st.getCoords().set(2, 200);
            st.getCoords().set(1,(ui.getGraph().getStates().size() * 100) - 500);
                }
        
        st.setDiameter(25);
        st.setId("State " + ui.getGraph().getStates().size());
        //st.getTransitions().add(new Transition());
        ui.getGraph().getStates().add(st);
        draw();
        
    }
    
    @Function static void decreaseStates(){
        ui.getGraph().getStates().remove(ui.getGraph().getStates().size()-1);
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
        ui.setGraph(new Graph());
        Transition t = new Transition();
        t.getCoordsFrom().add(0, 0);
        t.getCoordsFrom().add(1, 0);
        t.getCoordsFrom().add(2, 0);
        t.getCoordsTo().add(0, 0);
        t.getCoordsTo().add(1, 0);
        t.getCoordsTo().add(2, 0);
        currentTransition = t;
        // Startzustand erzeugen
        addState();
        addState();        
        ui.setMode("drawTransition");
        resizeCanvas();
        draw();
        ui.applyBindings();

    }
    
    public class Test {
        
    }
 

}


