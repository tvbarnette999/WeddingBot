/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Victor;

/**
 *
 * @author Thomas
 */
public class Lift {
    Victor a, b;
    public Lift(int a, int b) {
        this.a = new Victor(a);
        this.b = new Victor(b);
    }
    
    public void set(double v) {
        if (v > 0) {
            v = 0;
        }
        a.set(v);
        b.set(-v);
    }
    
}
