xpackage edu.mu.cmpsc3330.assignment2;

public class AbstractSupportRequest {
	// Author: Brooks Sonethongkham
	int id;
	String title;
	int basePoints;
	boolean resolved;
	
	// Required invariants
	void final validateId(int requestId) {
		if (requestId <= 0) {
			throw new IllegalArgumentException("Exception: id must be greater than zero.");
		}	
	}
	void final validateTitle(String requestTitle) {
		if (requestTitle == "" || requestTitle = null) {
			throw new IllegalArgumentException("Exception: title must not be null or blank.");
		}
	}
	void final validatebasePoints(int requestBasePoints) {
		if (requestBasePoints <= 0) {
			throw new IllegalArgumentException("Exception! base point must be greater than zero.");
		}
	}
	

}
