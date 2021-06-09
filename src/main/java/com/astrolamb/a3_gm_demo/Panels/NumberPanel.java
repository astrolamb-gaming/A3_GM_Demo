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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Matthew Holderbaum
 */
public class NumberPanel extends JPanel {
    
    int number;
    JTextField text;
    List<ValueChangeListener> listeners;
    
    public NumberPanel(int number) {
        this.number = number;
        listeners = new ArrayList<>();
        this.setVisible(true);
        text = new JTextField();
        text.setPreferredSize(new Dimension(50,30));
        text.setText(getString());
        text.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parseText();
            }
        });
        text.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                parseText();
            }
        });
        text.setVisible(true);
        this.add(text);
        
        
        JButton up = new JButton();
        up.setText("^");
        up.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                increment(true);
            }
        });
        up.setVisible(true);
        this.add(up);
        
        JButton down = new JButton();
        down.setText("v");
        down.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                increment(false);
            }
        });
        down.setVisible(true);
        this.add(down);
    }
    
    private void parseText() {
        String s = text.getText().replaceAll("[^0-9]", "");
        if (s.equals("")) {
            text.setText("");
            changeValue(0);
            return;
        }
        text.setText(s);
        changeValue(Integer.parseInt(s));
    }
    
    public int getNumber() {
        return number;
    }
    
    private String getString() {
        return String.valueOf(number);
    }
    
    private void increment(boolean up) {
        if (up) {
            changeValue(number + 1);
        } else {
            changeValue(number - 1);
        }
    }
    
    private void changeValue(int value) {
        number = value;
        text.setText(getString());
        listeners.forEach(l -> {
            l.onIntChanged(number);
        });
    }
}
