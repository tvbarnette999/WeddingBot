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
public class DriveBox {
    Victor a, b, c;
    public DriveBox(int a, int b, int c) {
        this.a = new Victor(a);
        this.b = new Victor(b);
        this.c = new Victor(c);
    }
    
    public void set(double v) {
        a.set(v);
        b.set(v);
        c.set(v);
    }
    
}
