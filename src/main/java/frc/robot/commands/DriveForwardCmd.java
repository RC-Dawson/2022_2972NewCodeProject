// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.Constants.SubsytemConstants;
import edu.wpi.first.wpilibj.Timer;

/** An example command that uses an example subsystem. */
public class DriveForwardCmd extends CommandBase {
  
  private final DriveSubsystem m_DriveMotor;
  private final Timer m_timer= new Timer();
  private boolean m_derection = true;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   * @param derection The is used to say the derection the motor will move. false is down
   * 
   */
  public DriveForwardCmd(DriveSubsystem DriveMotor, boolean derection) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_DriveMotor = DriveMotor;
    m_derection = derection;
    addRequirements(DriveMotor);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_timer.reset();
    m_timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (m_derection) {
      m_DriveMotor.arcadeDrive(SubsytemConstants.kAutoSpeed, 0); 
    } else  {
      m_DriveMotor.arcadeDrive(-SubsytemConstants.kAutoSpeed, 0);
    }   
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_DriveMotor.arcadeDrive(0, 0); 
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (m_timer.get() <= 3.0) {
      return false;    
    } else { 
      return true;
    }
  }
}
