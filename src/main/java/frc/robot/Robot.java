// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;

public class Robot extends TimedRobot {
  double lastStick = 0;
  TalonSRX _talon0 = new TalonSRX(14);
  Joystick _joystick = new Joystick(2);

  @Override
  public void teleopInit() {
    _talon0.setInverted(false); // pick CW versus CCW when motor controller is positive/green
  }

  @Override
  public void teleopPeriodic() {
    double stick = _joystick.getRawAxis(1) * -1; // make forward stick positive
    if (lastStick != stick) {
      System.out.println("stick:" + stick);
      lastStick = stick;
    }
    _talon0.set(ControlMode.PercentOutput, stick);
  }
}