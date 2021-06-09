/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.astrolamb.a3_gm_demo.ObjectProperties;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Matthew Holderbaum
 */
public class TorpedoProperty extends ObjectProperty {
    
    public float damageOnHit;
    public float damageOverTime;
    public float duration;
    public String name;
    public int count;
    
    public TorpedoProperty() {
        damageOnHit = 50f;
        damageOverTime = 0f;
        duration = 20f;
        name = "Torpedo";
        count = 4;
    }

    @Override
    public JPanel buildPanel() {
        JPanel panel = new JPanel();
        
        JLabel nameLabel = new JLabel(name);
        
        
        
        
        return panel;
    }
    
}
