/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.astrolamb.a3_gm_demo.ObjectProperties;

import com.astrolamb.a3_gm_demo.Panels.CollapsablePanel;
import com.astrolamb.a3_gm_demo.Panels.InfoPanel;
import com.astrolamb.a3_gm_demo.Panels.NumberPanel;
import com.astrolamb.a3_gm_demo.ValueChangeAdapter;
import com.astrolamb.a3_gm_demo.ValueChangeListener;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Matthew Holderbaum
 */
public class BeamProperty extends ObjectProperty {
    
    int beamRange = 6;
    int damage = 6;
    int energyUsePerShot = 2;
    int fireRate = 30;
    
    public BeamProperty() {
    }

    @Override
    public JPanel buildPanel() {
        
        CollapsablePanel info = new CollapsablePanel("Beam");
        
        //JPanel range = new JPanel();
        NumberPanel np = new NumberPanel(beamRange, 0, 1000);
        InfoPanel range = new InfoPanel("Range", beamRange, np);
        
        info.add(range);
        
        
        np.addValueChangeListener(new ValueChangeAdapter() {
            @Override
            public void onIntChanged(int i) {
                beamRange = 6;
            }
        });
        
        return info;
    }
    
}
