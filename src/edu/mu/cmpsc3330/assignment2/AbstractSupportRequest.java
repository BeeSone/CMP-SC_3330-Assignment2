package edu.mu.cmpsc3330.assignment2;

public abstract class AbstractSupportRequest {
	// Author: Brooks Sonethongkham
	private int id;
	private String title;
	private int basePoints;
	private boolean resolved;
	
	// Don't forget to call super(int id, string title, int basePoints) if you've replaced the no argument constructor in the function of one of the requests.
	public AbstractSupportRequest(int id, String title, int basePoints) {
		// Input validation using functions defined below:
		validateId(id);
		validateTitle(title);
		validateBasePoints(basePoints);
		
		// Assign fields
		this.id = id;
		this.title = title;
		this.basePoints = basePoints;
		this.resolved = false;
	}
	// Common getters
	public final int getId() {
		return this.id;
	}
	public final String getTitle() {
		return this.title;
	}
	public final int getBasePoints() {
		return this.basePoints;
	}
	public final boolean isResolved() {
		return this.resolved;
	}
	
	// Required invariant validation functions (updated to void, because nothing outside of this function's constructor will use them)
	private void validateId(int requestId) {
		if (requestId <= 0) {
			throw new IllegalArgumentException("Exception: id must be greater than zero.");
		}	
	}
	private void validateTitle(String requestTitle) {
		if (requestTitle == null || requestTitle.isBlank()) {
			throw new IllegalArgumentException(
					"Exception: title must not be null or blank."
					);
		}
	}
	private void validatebasePoints(int requestBasePoints) {
		if (requestBasePoints <= 0) {
			throw new IllegalArgumentException(
					"Exception! base point must be greater than zero."
					);
		}
	}
	

}
