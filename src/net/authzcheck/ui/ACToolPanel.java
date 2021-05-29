package net.authzcheck.ui;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import burp.ITab;

public class ACToolPanel extends JPanel implements ITab {
    public ACToolPanel(){
        setLayout(new BorderLayout(0, 0));

        JPanel acPanel = new JPanel();
        acPanel.setBorder(new EmptyBorder(5,5,5,5));
        add(acPanel, BorderLayout.SOUTH);
        acPanel.setLayout(new BorderLayout(0,0));
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

