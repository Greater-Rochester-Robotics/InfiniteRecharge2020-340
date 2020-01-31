/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;

import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorSensorV3.RawColor;

public class ColorWheel extends SubsystemBase {
  /**
   * Creates a new ColorWheel.
   * Reference: http://www.revrobotics.com/rev-31-1557/
   */
  private final I2C.Port i2cPort = I2C.Port.kOnboard;
  private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);


  public enum ColorName{
    red, blue, green, yellow
  }



  public ColorWheel() {

  }

  public ColorName getColor(Color color) {
    if (color.blue >= 0.30) {
      return ColorWheel.ColorName.blue;
    }
    else if (color.red >= 0.30 && color.green <= 0.45) {
      return ColorWheel.ColorName.red;
    }
    else if (color.red > 0.25 && color.green > 0.45) {
      return ColorWheel.ColorName.yellow;
    }
    else if (color.green > color.blue && color.green > color.red) {
      return ColorWheel.ColorName.green;
    }
    else{
    return null;
    }
  }
  
  @Override
  public void periodic() {
      /**
     * The method GetColor() returns a normalized color value from the sensor and can be
     * useful if outputting the color to an RGB LED or similar. To
     * read the raw color, use GetRawColor().
     * 
     * The color sensor works best when within a few inches from an object in
     * well lit conditions (the built in LED is a big help here!). The farther
     * an object is the more light from the surroundings will bleed into the 
     * measurements and make it difficult to accurately determine its color.
     */
    Color detectedColor = m_colorSensor.getColor();

    /**
     * The sensor returns a raw IR value of the infrared light detected.
     */
    double IR = m_colorSensor.getIR();

    /**
     * Open Smart Dashboard or Shuffleboard to see the color detected by the 
     * sensor.
     */
    SmartDashboard.putNumber("Red", detectedColor.red);
    SmartDashboard.putNumber("Green", detectedColor.green);
    SmartDashboard.putNumber("Blue", detectedColor.blue);
    SmartDashboard.putNumber("IR", IR);
    
    SmartDashboard.putString("Color", getColor(detectedColor).name());




    
    // This method will be called once per scheduler run
    //System.out.println()
    /**
     * In addition to RGB IR values, the color sensor can also return an 
     * infrared proximity value. The chip contains an IR led which will emit
     * IR pulses and measure the intensity of the return. When an object is 
     * close the value of the proximity will be large (max 2047 with default
     * settings) and will approach zero when the object is far away.
     * 
     * Proximity can be used to roughly approximate the distance of an object
     * or provide a threshold for when an object is close enough to provide
     * accurate color values.
     */
    int proximity = m_colorSensor.getProximity();

    SmartDashboard.putNumber("Proximity", proximity);



    
    
  }
}