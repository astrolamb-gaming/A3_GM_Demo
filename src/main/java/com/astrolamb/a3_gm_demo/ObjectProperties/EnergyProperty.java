/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.astrolamb.a3_gm_demo.ObjectProperties;

import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author Matthew Holderbaum
 */
public class EnergyProperty extends ObjectProperty {
    
    List<ObjectProperty> goProps;
    int efficiency = 1;
    
    public EnergyProperty(List<ObjectProperty> props) {
        goProps = props;
    }

    @Override
    public JPanel buildPanel() {
        JPanel panel = new JPanel();
        return panel;
    }
    
    public void setEfficiency(int e) {
        efficiency = e;
    }
    
    public int calculateEnergyUsePerSecond() {
        int e = 0;
        for (ObjectProperty op : goProps) {
            e += op.energyUsePerSecond;
        }
        return e;
    }
    
}
