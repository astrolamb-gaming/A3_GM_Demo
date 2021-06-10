/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.astrolamb.a3_gm_demo.GameObjects;

import com.astrolamb.a3_gm_demo.ObjectProperties.ObjectProperty;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.JPanel;

/**
 *
 * @author Matthew Holderbaum
 */
public class MeshedObject extends GameObject {
    
    Icon icon;
    List<ObjectProperty> properties;
    
    public MeshedObject(Icon icon) {
        this(icon, new ArrayList<>());
    }
    
    public MeshedObject(Icon icon, List<ObjectProperty> props) {
        this.icon = icon;
        this.properties = props;
    }
    
    public List<ObjectProperty> getProps() {
        return properties;
    }    
    
    public void addProperty(ObjectProperty op) {
        properties.add(op);
    }
    
    public JPanel buildInfoPanel() {
        JPanel panel = new JPanel();
        
        properties.forEach(prop -> {
            panel.add(prop.buildPanel());
        });
        
        return panel;
    }
    
}
