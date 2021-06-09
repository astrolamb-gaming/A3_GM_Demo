/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.astrolamb.a3_gm_demo;

import com.astrolamb.a3_gm_demo.Panels.NumberPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Matthew Holderbaum
 */
public class Demo {
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable()  {
            @Override 
            public void run() {
                JFrame frame = new JFrame();
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setPreferredSize(new Dimension(650,700));
                frame.setLayout(new BorderLayout());
                frame.add(new NumberPanel(10));
                frame.pack();
            }
        });
    }
    
}
