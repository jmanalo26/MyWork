package edu.ben.labs.lab2;

import java.util.ArrayList;

public class Major {
	public ArrayList<String> College;
	public ArrayList<String> classifications;
	public ArrayList<String> degreeLevels;
	
	public Major(ArrayList<String> College, ArrayList<String> classifications, ArrayList<String> degreeLevels) {
		this.College = College;
		this.classifications = classifications;
		this.degreeLevels = degreeLevels;
	}

	public ArrayList<String> getCollege() {
		return College;
	}

	public ArrayList<String> getClassifications() {
		return classifications;
	}

	public ArrayList<String> getDegreeLevels() {
		return degreeLevels;
	}

	public void setCollege(ArrayList<String> College) {
		this.College = College;
	}

	public void setClassifications(ArrayList<String> classifications) {
		this.classifications = classifications;
	}

	public void setDegreeLevels(ArrayList<String> degreeLevels) {
		this.degreeLevels = degreeLevels;
	}

	@Override
	public String toString() {
		return "'" + College + "', '" + classifications + "', '" + degreeLevels +  "')";
	}
	
	
	

}
