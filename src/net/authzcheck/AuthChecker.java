package net.authzcheck;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import burp.IExtensionHelpers;
import burp.IExtensionStateListener;

public class AuthChecker implements IExtensionStateListener {

    private final IExtensionHelpers helpers;

    public AuthChecker(IExtensionHelpers helpers){
        this.helpers = helpers;
    }

    // executes main authz checking logic
    public void executeAuthCheck(LinkedList<String> urls){
        //JOptionPane.showMessageDialog(null,urls);
        try {
            for(String url : urls){
                URL reqUrl;
                
                    reqUrl = new URL(url);
                
                byte[] request = helpers.buildHttpRequest(reqUrl);
                JOptionPane.showMessageDialog(null,new String(request));
            }
        } 
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private void exitAuthChecker(){

    }

    @Override
    public void extensionUnloaded(){
        exitAuthChecker();
    }
}
