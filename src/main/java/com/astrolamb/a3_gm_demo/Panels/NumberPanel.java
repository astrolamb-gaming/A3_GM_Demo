/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.astrolamb.a3_gm_demo.Panels;

import com.astrolamb.a3_gm_demo.ValueChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Matthew Holderbaum
 */
public class NumberPanel extends JPanel {
    
    float number;
    JTextField text;
    List<ValueChangeListener> listeners;
    
    public NumberPanel(float number) {
        this.number = number;
        
        text = new JTextField();
        text.setText(getString());
        
        JButton up = new JButton();
        up.setText("^");
        up.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeValue(true);
            }
        });
        
        
        
        JButton down = new JButton();
        down.setText("v");
        down.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeValue(false);
            }
        });
    }
    
    public float getNumber() {
        return number;
    }
    
    private String getString() {
        return String.valueOf(number);
    }
    
    private void changeValue(boolean up) {
        if (up) {
            number += 1;
        } else {
            number -= 1;
        }
        text.setText(getString());
        listeners.forEach(l -> {
            l.onFloatChanged(number);
        });
    }
}
