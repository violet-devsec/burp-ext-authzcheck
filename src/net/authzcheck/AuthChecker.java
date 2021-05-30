package net.authzcheck;

import javax.swing.JOptionPane;

import burp.IExtensionHelpers;
import burp.IExtensionStateListener;

public class AuthChecker implements IExtensionStateListener {

    private final IExtensionHelpers helpers;

    public AuthChecker(IExtensionHelpers helpers){
        this.helpers = helpers;
    }

    public void executeAuthCheck(){
        JOptionPane.showMessageDialog(null,"Hello, Welcome to Javatpoint.");
    }

    private void exitAuthChecker(){

    }

    @Override
    public void extensionUnloaded(){
        exitAuthChecker();
    }
}
