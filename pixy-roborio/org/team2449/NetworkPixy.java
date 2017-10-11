package org.team2449;

import edu.wpi.first.wpilibj.networktables.*;

public class NetworkPixy {
	
	private NetworkTable networkTable;
	
	public NetworkPixy(String tableName){
		networkTable=NetworkTable.getTable(tableName);  //Initialize Network Table listener
	}

	public double getType(){return networkTable.getNumber("TYPE",-1);}  //Returns Type
	public double getSignature(){return networkTable.getNumber("SIG",-1);}  //Returns Signature
	public double getX(){return networkTable.getNumber("X",-1);}  //Returns X
	public double getY(){return networkTable.getNumber("Y",-1);}  //Returns Y
	public double getWidth(){return networkTable.getNumber("WIDTH",-1);}  //Returns Width
	public double getHeight(){return networkTable.getNumber("HEIGHT",-1);}  //Returns Height
}
