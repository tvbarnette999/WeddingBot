/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class WeddingBot extends IterativeRobot {
    DriveBox left = new DriveBox(1, 2, 3);
    DriveBox right = new DriveBox(4, 5, 6);
    Joystick joy = new Joystick(1);
    Victor frontBalls = new Victor(7);
    Victor backBalls = new Victor(8);
    DigitalInput target = new DigitalInput(2);
    DigitalInput low = new DigitalInput(3);
    DigitalInput high = new DigitalInput(4);
    DoubleSolenoid pistons = new DoubleSolenoid(7, 8);
    Relay compressor = new Relay(1, Relay.Direction.kForward);
    Lift lift = new Lift(9, 10);
    
    private double deadZone(double a) {
        return Math.abs(a) < .05 ? 0 : a;
    }
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        // 1 LX, 2LY, 3 trig, 4 RX, 5 RY
        // 1 = A, 2 = B, 3 = X, 4 = Y
        
        left.set(-deadZone(joy.getRawAxis(2)));
        right.set(deadZone(joy.getRawAxis(5)));
        frontBalls.set(joy.getRawButton(4) ? -.3 : 0);
        backBalls.set(joy.getRawButton(1) ? -.3 : 0);
        
//        System.out.println("DIO: " + low.get() + ", " + high.get() + " yay fortnite!!!!!!" + " numebr one ivcotr foroayal yeah forntite we bale to get down get down number one on the baord right now my firend just got down i revived him now we're headinf sout bound nto we looked at the map sheets twilter towers rfiwin win win winw inw  frotniet fortnitr fort nitr fortnirt fortrnir");
        compressor.set(joy.getRawButton(5) ? Relay.Value.kOn : Relay.Value.kOff);
        lift.set(deadZone(joy.getRawAxis(3)));
        
        if (joy.getRawButton(2)) {
            pistons.set(DoubleSolenoid.Value.kForward);
        } else if (joy.getRawButton(3)) {
            pistons.set(DoubleSolenoid.Value.kReverse);
        } else {
            pistons.set(DoubleSolenoid.Value.kOff);
        }
        
    }
    
}
