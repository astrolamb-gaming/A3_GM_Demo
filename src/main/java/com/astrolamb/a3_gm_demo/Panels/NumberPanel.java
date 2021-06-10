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
import java.awt.event.ComponentListener;
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
public class NumberPanel extends JPanel {
    
    int number;
    JTextField text;
    List<ValueChangeListener> listeners;
    int max;
    int min;
    
    public NumberPanel(int number) {
        this(number, 1000000000, -1000000000);
    }
    
    public NumberPanel(int number, int max, int min) {
        // Assume they mixed up the order
        if (max < min) {
            this.max = min;
            this.min = max;
        } else {
            this.max = max;
            this.min = min;
        }
        this.number = number;
        setPreferredSize(new Dimension(150,30));
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
                //parseText();
                String selected = text.getSelectedText();
                if (null != selected) {
                    if (!selected.equals("")) {
                        text.setText(text.getText().replace(selected, ""));
                    }
                }
                if (e.getKeyCode() == KeyCode.ENTER.ordinal()) {
                    parseText();
                }
            }
        });
        text.addFocusListener(new FocusAdapter(){
            @Override
            public void focusLost(FocusEvent e) {
                parseText();
            }
        });
        text.setVisible(true);
        add(text);
        
        
        
        
        JButton down = new JButton();
        down.setText("-");
        down.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                increment(false);
            }
        });
        down.setVisible(true);
        add(down);
        
        JButton up = new JButton();
        up.setText("+");
        up.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                increment(true);
            }
        });
        up.setVisible(true);
        add(up);
    }
    
    private void parseText() {
        String s = text.getText().replaceAll("[^0-9]", "");
        if (s.equals("")) {
            changeValue(0);
            text.setText("");
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
        if (value > max) {
            value = max;
        }
        if (value < min) {
            value = min;
        }
        number = value;
        text.setText(getString());
        listeners.forEach(l -> {
            l.onIntChanged(number);
        });
    }
    
    public void addValueChangeListener(ValueChangeListener l) {
        listeners.add(l);
    }
}
