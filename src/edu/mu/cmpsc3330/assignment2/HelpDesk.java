package edu.mu.cmpsc3330.assignment2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HelpDesk {

    private Map<Integer, SupportRequest> requestsById = new HashMap<Integer, SupportRequest>();
    private Map<Technician, List<SupportRequest>> assignments = new HashMap<Technician, List<SupportRequest>>();
    public HelpDesk() {
    }

    // adds a request towards ID
    public void addRequest(SupportRequest request) {
        if(request ==  null){
            throw new IllegalArgumentException("Request cannot be null");
        }

        int id = request.getId();

        if(requestsById.containsKey(id)){
            throw new IllegalArgumentException("Request ID " + id + " already exist");
        }
        requestsById.put(id, request);
    }

    // returns the requested ID
    public SupportRequest findRequest(int id){
        return requestsById.get(id);
    }

    //assigns request to a certain technician
    public void assignRequest(Technician technician, int requestId){
        if(technician == null){
            throw new IllegalArgumentException("Technician cannot be null");
        }
        SupportRequest request = findRequest(requestId);
        if(request == null){
            throw new IllegalArgumentException("RequestId cannot be found, id: " + requestId);
        }
        if(request.isResolved()){
            throw new IllegalArgumentException("Resolved ticket cannot be assigned");
        }
        List<SupportRequest> techRequests = assignments.get(technician);
        if(techRequests == null){
            techRequests = new ArrayList<>();
            assignments.put(technician, techRequests);
        }
        if(techRequests.contains(request)){
        	// A request cannot be assigned to the same technician twice
            throw new IllegalArgumentException("Request is already assigned to this technician");
        } else {
        	// A request can only be assigned to one technician.
        	for (List<SupportRequest> existingRequests  : assignments.values()) {
        	    if (existingRequests.contains(request)) {
        	        throw new IllegalArgumentException(
        	            "Request is already assigned to another technician"
        	        );
        	    }
        	}
        }
        techRequests.add(request);
    }

    // finds request from technician polmorphically and returns the service points awarded
    public int resolveRequest(Technician technician, int requestId){
        if(technician == null){
            throw new IllegalArgumentException("Technician cannot be null");
        }
        List<SupportRequest> techRequests = assignments.get(technician);
        if(techRequests == null){
             throw new IllegalArgumentException("Technician has no assignments");
        }
        SupportRequest request = findRequest(requestId);
        if(request == null || !techRequests.contains(request)){
            throw new IllegalArgumentException("Ticket is not assigned to this technician");
        }
        return request.resolveFor(technician);
    }

    //prints all requests
    public void printAllRequests(){
        System.out.println("All Support Requests");
        for(SupportRequest req : requestsById.values()){
            System.out.println(req);
        }
    }

    //prints all requests assigned to technician
    public void printAssignmentsFor(Technician technician){
        if (technician == null) {
			throw new IllegalArgumentException("technician cannot be null");
		}
		System.out.println("--- Assignments for " + technician.getName() + " ---");
		List<SupportRequest> techRequests = assignments.get(technician);
		if (techRequests == null || techRequests.isEmpty()) {
			System.out.println("No assignments.");
		} else {
			for (SupportRequest req : techRequests) {
				System.out.println("  * " + req);
			}
		}
    }
}
