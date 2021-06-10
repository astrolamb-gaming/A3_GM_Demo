/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.astrolamb.a3_gm_demo.ObjectProperties;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Matthew Holderbaum
 */
public abstract class ObjectProperty {
    
    int energyUsePerSecond = 0;
    public abstract JPanel buildPanel();
    
    protected ImageIcon createImageIcon(String path, String description) {
        ImageIcon imgURL = new ImageIcon(path);
//        if (imgURL != null) {
//            return new ImageIcon(imgURL, description);
//        } else {
//            System.err.println("Couldn't find file: " + path);
//            return null;
//        }
        return imgURL;
    }
    
}
