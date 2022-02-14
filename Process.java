/*
 * Reece Peters 
 */

//define class
public class Process implements Comparable <Process> {
	//instance var
	private int priority;
	private double time;
	private String name;
	
	//default constructor
	public Process() {
		this.priority = 1;
		this.time = 1.0;
		this.name = "none";
	}
	//parameterized constructor
	public Process(String aName, int aPriority, double aTime) {
		setPriority(aPriority);
		setTime(aTime);
		setName(aName);
	}
	
	//getters
	public int getPriority() {
		return this.priority;
	}
	public double getTime() {
		return this.time;
	}
	public String getName() {
		return this.name;
	}
	
	//setters
	public void setPriority(int aPriority) {
		if(aPriority <= 0) {
			this.priority = 0;
		} else {
			this.priority = aPriority;
		}
	}
	public void setTime(double aTime) {
		if(aTime <= 0.0) {
			this.time = 0.0;
		} else {
			this.time = aTime;
		}
	}
	public void setName(String aName) {
		if(aName == null) {
			this.name = "none";
		} else {
			this.name = aName;
		}
	}
	
	//Other Methods
	//toString
	public String toString() {
		return "Name: " + this.name + " Time: " + this.time + " Priority: " + this.priority;
	}
	
	//compareTo
		public int compareTo(Process aProcess) {
			if(aProcess == null) {
				return 0;
			}
			if(this.priority > aProcess.getPriority()) {
				return 1;
			} else if(this.priority < aProcess.getPriority()) {
				return -1;
			} else {
				return 0;
			}
		}
	
	
}
