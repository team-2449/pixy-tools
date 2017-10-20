package org.team2449;

import edu.wpi.first.wpilibj.networktables.*;

public final class NetworkPixy {
	
	private static NetworkTable networkTable;
	
	public NetworkPixy(){
		  //Initialize Network Table listener
	}
	public static void initialize(String tableName){networkTable=NetworkTable.getTable(tableName);}
	public static double getType(){return networkTable.getNumber("TYPE",-1);}  //Returns Type
	public static double getSignature(){return networkTable.getNumber("SIG",-1);}  //Returns Signature
	public static double getX(){return networkTable.getNumber("X",-1);}  //Returns X
	public static double getY(){return networkTable.getNumber("Y",-1);}  //Returns Y
	public static double getWidth(){return networkTable.getNumber("WIDTH",-1);}  //Returns Width
	public static double getHeight(){return networkTable.getNumber("HEIGHT",-1);}  //Returns Height
}
