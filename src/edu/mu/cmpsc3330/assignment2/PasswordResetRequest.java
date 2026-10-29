package edu.mu.cmpsc3330.assignment2;

public class PasswordResetRequest extends AbstractSupportRequest{
	private String accountName;
	
	public PasswordResetRequest(int id, String title, int basePoints, String accountName) {
		super(id, title, basePoints);//Passes the parameters to the required parent class variables
		
		if(accountName == null || accountName.isBlank()) {
			throw new IllegalArgumentException("accountName cannot be blank or null");
		}
		
		this.accountName = accountName;
	}
	
	@Override
	public int resolveFor(Technician technician){
		if(technician == null){
			throw new IllegalArgumentException("technician cannot be null");
		}
		int totalPoints = getBasePoints();
		resolveTicket(technician, totalPoints);//Should be a class from the parent and handle a double resolution through there
		return totalPoints;
	}
}
