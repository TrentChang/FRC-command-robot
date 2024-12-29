package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.event.NetworkBooleanEvent;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.LimelightHelpers;
import frc.robot.Constants.LimelightConstants;

public class Limelight extends SubsystemBase{

    NetworkTable table = NetworkTableInstance.getDefault().getTable(LimelightConstants.Name); 

    // double Tag_ID;
    // double Tag_Area;
    // double Tag_XPose;

    // 
    boolean Detected;
    double ID;
    double tA;
    double tX;

    public double getFiducialID(){
        // double ID = NetworkTableInstance.getDefault().getTable("").getEntry("tid").getDouble(0); // Get Fiducial ID
        // if (ID >= 1 & ID <= 16){
        //     return ID;
        // }
        // else{
        //     return 0;
        // }
        ID = LimelightHelpers.getFiducialID("");
        return ID;
    }

    public double getTA(){
        tA = LimelightHelpers.getTA(""); // Target area (0% to 100% of image)
        return tA;
    }

    public double getTX(){
        tX = LimelightHelpers.getTX("");  // Horizontal offset from crosshair to target in degrees
        return tX;
    }
    //
    @Override
    public void periodic(){
        // 3D transform of the camera in the coordinate system of the robot (array (6))[tx, ty, tz, pitch, yaw, roll] (meters, degrees)
        // NetworkTableInstance.getDefault().getTable("").getEntry("camerapose_robotspace").getDoubleArray(new double[6]);

        // Tag_ID = SmartDashboard.getNumber("tid", 0);
        // Tag_Area = SmartDashboard.getNumber("ta", 0);
        // Tag_XPose = SmartDashboard.getNumber("tx", 0);

        // System.out.println("ID" + Tag_ID);
        // System.out.println("Tag_Area" + Tag_Area);
        // System.out.println("Tag_X" + Tag_XPose);

        getFiducialID();
        getTA();
        getTX();

        SmartDashboard.putNumber("Tag_ID", ID);
        SmartDashboard.putNumber("Tag_Area", tA);
        SmartDashboard.putNumber("Tag_X", tX);

    }
}