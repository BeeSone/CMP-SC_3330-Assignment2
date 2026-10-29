package edu.mu.cmpsc3330.assignment2;

public class NetworkIssueRequest extends AbstractSupportRequest{
	private int affectedUsers;
	
	public NetworkIssueRequest(int id, String title, int basePoints, int affectedUsers) {
		super(id, title, basePoints);//Passes the parameters to the required parent class variables
		
		if(affectedUsers <=0) {
			throw new IllegalArgumentException("affectedUsers cannot be less than 1");
		}
		
		this.affectedUsers = affectedUsers;
	}
	
	@Override
	public int resolveFor(Technician technician){
		if(technician == null){
			throw new IllegalArgumentException("technician cannot be null");
		}
		resolveTicket();//Should be a class from the parent and handle a double resolution through there
		int totalPoints = getBasePoints()+(2*this.affectedUsers); //Decided on using the weighted rule 
		technician.addPoints(totalPoints);
		return totalPoints;
	}
}
