/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.astrolamb.a3_gm_demo.Panels;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Matthew Holderbaum
 */
public class CollapsablePanel extends JPanel {
    
    boolean visible = true;
    JPanel info;
    
    public CollapsablePanel(String description) {
        super.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        
        JPanel top = new JPanel();
        JLabel label = new JLabel(description);
        
        top.add(label);
        
        Image popImg;
        JButton pop = new JButton();

        pop.setPreferredSize(new Dimension(16,16));

        // to remove the border
        pop.setBorder(null);
        top.add(pop);
        
        
        
        Image min;
        JButton minimize = new JButton();
        minimize.setPreferredSize(new Dimension(16,16));
        top.add(minimize);
        
        
        super.add(top);
        
        info = new JPanel();
        super.add(info);
        
        
        minimize.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                visible = !visible;
                info.setVisible(visible);
                revalidate();
            }
        });
    }
    
    @Override
    public Component add(Component comp) {
        return info.add(comp);
    }
    
}
