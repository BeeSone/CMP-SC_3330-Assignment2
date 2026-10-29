package edu.mu.cmpsc3330.assignment2;

public interface SupportRequest {
	int getId();
	String getTitle();
	int getBasePoints();
	boolen isResolved();
	int resolvedFor(Technician technician);
	
	
	
	
	// Update the request's resolved state
	// Award service points to the technician
	// Return the number of service points awarded

}
