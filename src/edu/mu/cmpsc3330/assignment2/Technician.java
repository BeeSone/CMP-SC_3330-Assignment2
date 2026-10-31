package edu.mu.cmpsc3330.assignment2;

public class Technician {
	private final String name;
	private int servicePoints = 0;
	
	public Technician(String name) {
		if(name == null || name.isBlank()) {
			throw new IllegalArgumentException("name cannot be blank or null");
		}
		
		this.name = name;
	}
	
	public int addPoints(int amount) {
		if(amount<1) {
			throw new IllegalArgumentException("amount cannot be less than or equal to 0");
		}
		this.servicePoints += amount;
		return this.servicePoints; //Returns current amount of servicePoints
	}
	
	public int getServicePoints() {
		return this.servicePoints;
	}
	
	public String getName() {
		return this.name;
	}
	
	@Override
	public String toString() {
		return "Name: " + this.name + ", Service Points: " + this.servicePoints;
	}
	
	@Override
    public boolean equals(Object obj) {
		if (this == obj) {//Checks for being the exact same object
            return true;
        }
		
		if (obj == null || getClass() != obj.getClass()) { //Checks for null and if the Object is the same class
            return false;
        }
		
		Technician otherTech = (Technician) obj;
		
		return this.name.equals(otherTech.getName());
	}
	
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}

}