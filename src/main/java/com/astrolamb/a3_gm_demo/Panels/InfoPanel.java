/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.astrolamb.a3_gm_demo.Panels;

import com.astrolamb.a3_gm_demo.ValueChangeListener;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Matthew Holderbaum
 */
public class InfoPanel extends JPanel {
    
    String name;
    String value;
    
    JPanel panel;
    
   // List<ValueChangeListener> listeners;
    
    public InfoPanel(String name, int value, NumberPanel jp) {
        panel = jp;
        buildPanel(name, String.valueOf(value));
    }
    
    
    public InfoPanel(String name, String value, NamePanel jp) {
        panel = jp;
        buildPanel(name,value);
        
    }
    
    private void buildPanel(String name, String value) {
        
       // listeners = new ArrayList<>();
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS)); 
        JLabel label = new JLabel(name + ": ");
        JLabel valueLabel = new JLabel(value);
        //rangeValue.setText(value); 
        valueLabel.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        valueLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                add(panel);
            }
        }); 
        
        add(label);
        add(valueLabel);
        
    }
    
}
