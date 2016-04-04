package com.dukescript.demoapp;


import com.dukescript.demoapp.js.Dialogs;
import net.java.html.boot.BrowserBuilder;
import net.java.html.js.JavaScriptBody;

public final class Main {
    private Main() {
    }

    public static void main(String... args) throws Exception {
        BrowserBuilder.newBrowser().
            loadPage("pages/index.html").
            loadClass(Main.class).
            invoke("onPageLoad", args).
            showAndWait();
        System.exit(0);
    }

    /**
     * Called when the page is ready.
     */
    public static void onPageLoad() throws Exception {
        UIModel.onPageLoad();
        
    }
    


}
