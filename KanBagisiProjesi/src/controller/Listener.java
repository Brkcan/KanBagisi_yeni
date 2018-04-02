package controller;

import javax.persistence.PostRemove;
import javax.persistence.PreRemove;

import model.Human;

public class Listener {
	
	@PreRemove
	public void userPreRemove(Human ob) {
		System.out.println("Listening User Pre Remove : " + ob.getId());
	}
	@PostRemove
	public void userPostRemove(Human ob) {
		System.out.println("Listening User Post Remove : " + ob.getId());
	}

}
