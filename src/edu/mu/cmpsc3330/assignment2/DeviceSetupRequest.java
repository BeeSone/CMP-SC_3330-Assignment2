package edu.mu.cmpsc3330.assignment2;

public class DeviceSetupRequest extends AbstractSupportRequest{
	private int deviceCount;
	
	public DeviceSetupRequest(int id, String title, int basePoints, int deviceCount) {
		super(id, title, basePoints);//Passes the parameters to the required parent class variables
		
		if(deviceCount <=0) {
			throw new IllegalArgumentException("deviceCount cannot be less than 1");
		}
		
		this.deviceCount = deviceCount;
	}
	
	@Override
	public int resolveFor(Technician technician){
		if(technician == null){
			throw new IllegalArgumentException("technician cannot be null");
		}
		int totalPoints = getBasePoints()*deviceCount;
		resolveTicket(technician, totalPoints);//Should be a class from the parent and handle a double resolution through there
		return totalPoints;
	}
}
