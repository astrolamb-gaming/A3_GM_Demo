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

/**
 *
 * @author Matthew Holderbaum
 */
public class Ship extends MeshedObject {
    
    int side;
    
    public Ship() {
        this(2);
    }
    
    public Ship(int side) {
        this(side, null);
    }
    
    public Ship (int side, Icon icon) {
        this(side, icon, new ArrayList<>());
    }
    
    public Ship (int side, Icon icon, List<ObjectProperty> props) {
        super(icon, props);
        this.side = side;
        this.properties = props;
        
    }
  
}
