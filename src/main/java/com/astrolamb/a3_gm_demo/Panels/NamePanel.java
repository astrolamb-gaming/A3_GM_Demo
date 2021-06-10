/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.astrolamb.a3_gm_demo.Panels;

import com.astrolamb.a3_gm_demo.ValueChangeListener;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.input.KeyCode;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Matthew Holderbaum
 */
public class NamePanel extends JPanel {
    
    JTextField text;
    List<ValueChangeListener> listeners;
    String str;
    public NamePanel(String s) {
        
        listeners = new ArrayList<>();
        setVisible(true);
        text = new JTextField();
        text.setPreferredSize(new Dimension(50,30));
        text.setText(getString());
//        text.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                parseText();
//            }
//        });
        text.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String selected = text.getSelectedText();
                if (null != selected) {
                    if (!selected.equals("")) {
                        text.setText(text.getText().replace(selected, ""));
                    }
                }
                if (e.getKeyCode() == KeyCode.ENTER.ordinal()) {
                    changeValue(text.getText());
                }
            }
        });
        text.addFocusListener(new FocusAdapter(){
            @Override
            public void focusLost(FocusEvent e) {
                changeValue(text.getText());
            }
        });
        text.setVisible(true);
        add(text);
        

    }

    private String getString() {
        return str;
    }

    
    private void changeValue(String value) {
        //text.setText(getString());
        str = value;
        listeners.forEach(l -> {
            l.onStringChanged(value);
        });
    }
    
}
