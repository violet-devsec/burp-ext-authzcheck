package net.authzcheck.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import net.authzcheck.AuthChecker;

import burp.ITab;
import burp.IExtensionHelpers;

public class ACToolPanel extends JPanel implements ITab {

    private final IExtensionHelpers helpers;
    
    JTextArea urlTxtArea;
    JComboBox authHeaderType;
    JTextArea headerTxtArea;

    public ACToolPanel(IExtensionHelpers helpers){

        this.helpers = helpers;

        setLayout(new BorderLayout(0, 0));

        JPanel topPanel = new JPanel();        
        topPanel.setLayout(new GridLayout(3,2,5,5));

        JPanel bottomPanel = new JPanel();        
        bottomPanel.setLayout(new GridLayout(3,0,5,5));

        JLabel urlLabel = new JLabel();
        urlTxtArea = getTextArea();

        JLabel headerLabel = new JLabel();
        String[] options = {"Authorization", "Cookies"};
        authHeaderType = new JComboBox<String>(options);
        headerTxtArea = getTextArea();

        urlLabel.setText("URLs to test:");
        headerLabel.setText("Headers to add:");
        //urlTxtArea.setBounds(40,75,250,200);
        //headerTxtArea.setBounds(40,75,250,200);

        topPanel.add(urlLabel);
        topPanel.add(headerLabel);
        topPanel.add(urlTxtArea);
        topPanel.add(authHeaderType);
        topPanel.add(new JLabel(""));
        topPanel.add(headerTxtArea);

        JLabel outputLabel = new JLabel();
        JTextArea outputTxtArea = getTextArea();
        JButton exeButton = new JButton();

        outputLabel.setText("Authorization Status");
        //outputTxtArea.setBounds(40,75,250,200);
        exeButton.setText("Execute");
        //exeButton.setBounds(48,300,250,30);
        exeButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                sendPayload();
            }
        });

        bottomPanel.add(exeButton);
        bottomPanel.add(outputLabel);
        bottomPanel.add(outputTxtArea);

        add(topPanel, BorderLayout.NORTH);
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    // adds Textarea
    private JTextArea getTextArea(){
        JTextArea txtArea = new JTextArea();
        txtArea.setBorder(BorderFactory.createLineBorder(Color.blue));

        return txtArea;
    }

    // sends payload
    private void sendPayload(){
        LinkedList<String> listUrls = new LinkedList<String>();

        if(urlTxtArea.getText() != ""){
            String strLines[] = urlTxtArea.getText().split("\\r?\\n");
            
            for(String line: strLines){
                listUrls.add(line);
            }
        }

        AuthChecker authChecker = new AuthChecker(helpers);
        authChecker.executeAuthCheck(listUrls);
    }
    
    @Override
	public String getTabCaption() {
		return "AuthzCheckTool";
	}

	@Override
	public Component getUiComponent() {
		return this;
	}
}

