xpackage edu.mu.cmpsc3330.assignment2;

public abstract class AbstractSupportRequest {
	// Author: Brooks Sonethongkham
	private int id;
	private String title;
	private int basePoints;
	private boolean resolved;
	
	// Common getters
	int final getId() {
		return this.id;
	}
	String final getTitle() {
		return this.title;
	}
	int final getBasePoints() {
		return this.basePoints;
	}
	boolean final isResolved() {
		return this.resolved;
	}
	
	// Required invariants
	void final validateId(int requestId) {
		if (requestId <= 0) {
			throw new IllegalArgumentException("Exception: id must be greater than zero.");
		}	
	}
	void final validateTitle(String requestTitle) {
		if (requestTitle.equals("") || requestTitle == null) {
			throw new IllegalArgumentException("Exception: title must not be null or blank.");
		}
	}
	void final validatebasePoints(int requestBasePoints) {
		if (requestBasePoints <= 0) {
			throw new IllegalArgumentException("Exception! base point must be greater than zero.");
		}
	}
	

}
