package edu.mu.cmpsc3330.assignment2;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        // Create technicians
        Technician tech1 = new Technician("Alex");
        Technician tech2 = new Technician("Jordan");
        Technician tech3 = new Technician("Alex");
        
        

        HelpDesk helpDesk = new HelpDesk();

        // Create six support requests (two of each type)
        SupportRequest request1 = new PasswordResetRequest(1, "Password Reset", 10, "alex123");
        SupportRequest request2 = new PasswordResetRequest(2, "Account Locked", 15, "jordan456");
        SupportRequest request3 = new DeviceSetupRequest(3, "Laptop Setup", 10, 2);
        SupportRequest request4 = new DeviceSetupRequest(4, "Printer Setup", 12, 3);
        SupportRequest request5 = new NetworkIssueRequest(5, "Wi-Fi Outage", 20, 5);
        SupportRequest request6 = new NetworkIssueRequest(6, "Network Slowdown", 15, 3);

        // Add requests to HelpDesk
        helpDesk.addRequest(request1);
        helpDesk.addRequest(request2);
        helpDesk.addRequest(request3);
        helpDesk.addRequest(request4);
        helpDesk.addRequest(request5);
        helpDesk.addRequest(request6);

        // Assign requests to technicians
        helpDesk.assignRequest(tech1, 1);
        helpDesk.assignRequest(tech1, 3);
        helpDesk.assignRequest(tech1, 2);
        
        helpDesk.assignRequest(tech3, 4);
        helpDesk.assignRequest(tech2, 5);

        // tech3 has the same name as tech1.
        // The HelpDesk HashMap treats them as the same technician.
        helpDesk.assignRequest(tech3, 6);
        
        // Demonstrate HashSet behavior with duplicate technicians
        // Idk if we needed to actually do this since this functionality is in HelpDesk.java but just incase
        System.out.println("Testing HashSet Technician Equality");

        Set<Technician> technicianSet = new HashSet<>();

        technicianSet.add(tech1);
        technicianSet.add(tech2);
        technicianSet.add(tech3);

        System.out.println("Number of technicians created: 3");
        System.out.println("Number of unique technicians in HashSet: " + technicianSet.size());

        for (Technician tech : technicianSet) {
            System.out.println(tech);
        }

        // Resolve requests of all three types
        System.out.println("\nResolving Requests:");
        System.out.println("Request 1 awarded " + helpDesk.resolveRequest(tech1, 1) + " points.");
        System.out.println("Request 3 awarded " + helpDesk.resolveRequest(tech1, 3) + " points.");
        System.out.println("Request 5 awarded " + helpDesk.resolveRequest(tech2, 5) + " points.");

        // Print all requests
        System.out.println("\n");
        helpDesk.printAllRequests();

        // Print technician assignments
        System.out.println("\nTechnician Assignments:");
        helpDesk.printAssignmentsFor(tech1);
        helpDesk.printAssignmentsFor(tech2);

        // Both Alex objects refer to the same HelpDesk map entry.
        System.out.println("\nAssignments accessed using the second Alex object:");
        helpDesk.printAssignmentsFor(tech3);

        // Print final technician points
        System.out.println("\nFinal Technician Points:");
        System.out.println(tech1);
        System.out.println(tech2);

        // Demonstrate sumPoints
        List<Technician> technicians = new ArrayList<>();
        technicians.add(tech1);
        technicians.add(tech2);

        System.out.println("\nTotal Service Points: "
            + HelpDeskUtil.sumPoints(technicians));

        // Demonstrate exception handling
        System.out.println("\n===== Testing Invalid Operations =====");

        // 1. Assigning a request that does not exist
        try {
            helpDesk.assignRequest(tech1, 999);
        } catch (IllegalArgumentException e) {
            System.out.println("Nonexistent request: " + e.getMessage());
        }

        // 2. Assigning a request that is already assigned to another technician
        try {
            helpDesk.assignRequest(tech2, 2);
        } catch (IllegalArgumentException e) {
            System.out.println("Duplicate assignment: " + e.getMessage());
        }

        // 3. Assigning a request that has already been resolved
        try {
            helpDesk.assignRequest(tech1, 1);
        } catch (IllegalArgumentException e) {
            System.out.println("Assigning resolved request: " + e.getMessage());
        }

        // 4. Resolving a request for a technician it is not assigned to
        try {
            helpDesk.resolveRequest(tech2, 3);
        } catch (IllegalArgumentException e) {
            System.out.println("Unauthorized resolution: " + e.getMessage());
        }

        // 5. Attempting to resolve a request more than once
        try {
            helpDesk.resolveRequest(tech1, 1);
        } catch (IllegalStateException e) {
            System.out.println("Repeated resolution: " + e.getMessage());
        }

        // 6. Adding a request with a duplicate ID
        try {
            helpDesk.addRequest(new PasswordResetRequest(1, "Duplicate ID", 10, "anotherUser"));
        } catch (IllegalArgumentException e) {
            System.out.println("Duplicate request ID: " + e.getMessage());
        }

        // 7. Attempting to award invalid service points
        try {
            tech1.addPoints(0);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid point award: " + e.getMessage());
        }

        // 8. Attempting to create a technician with an invalid name
        try {
            Technician invalidTech = new Technician("");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid technician: " + e.getMessage());
        }
    }
}