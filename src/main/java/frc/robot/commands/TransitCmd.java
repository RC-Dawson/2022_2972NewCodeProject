// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.TransitSubsytem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.SubsytemConstants;

/** An example command that uses an example subsystem. */
public class TransitCmd extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final TransitSubsytem m_subsystem;
  private boolean m_derection;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public TransitCmd(TransitSubsytem subsystem, boolean derection) {
    m_subsystem = subsystem;
    m_derection = derection;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (m_derection) {
      m_subsystem.Run(SubsytemConstants.kTransitSpeed);
    } else {
      m_subsystem.Run(-SubsytemConstants.kTransitSpeed);
    }
      
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_subsystem.Run(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
