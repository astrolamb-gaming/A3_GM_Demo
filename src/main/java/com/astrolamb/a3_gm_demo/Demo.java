/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.astrolamb.a3_gm_demo;

import com.astrolamb.a3_gm_demo.GameObjects.Ship;
import com.astrolamb.a3_gm_demo.ObjectProperties.BeamProperty;
import com.astrolamb.a3_gm_demo.Panels.NumberPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
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
                
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setPreferredSize(new Dimension(650,700));
                frame.setLayout(new BorderLayout());
                
                
                
                //frame.add(new NumberPanel(10, 50, 0));
                
                
                
                JPanel map = new JPanel();
                //frame.add(map, BorderLayout.CENTER);
                
                
                
                Ship s = new Ship(2);
                s.addProperty(new BeamProperty());
                
                
                
                
                
                
                JPanel sidebar = new JPanel();
                //frame.add(sidebar, BorderLayout.WEST);
                sidebar.add(s.buildInfoPanel());
                
                JSplitPane sl = new JSplitPane(SwingConstants.VERTICAL, sidebar, map);
                frame.add(sl);
                frame.setVisible(true);
                frame.pack();
            }
        });
    }
    
}
