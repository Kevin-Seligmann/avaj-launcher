package avaj_launcher.model;

import java.util.ArrayList;
import java.util.List;

public class Tower {
	private List<Flyable> observers;

	public void register(Flyable p_flyable){
		Aircraft aircraft = (Aircraft) p_flyable;

		observers.add(aircraft);
		System.out.println("Tower says: " + aircraft.toString() + " registered to weather tower.");
	}

	public void unregister(Flyable p_flyable){
		Aircraft aircraft = (Aircraft) p_flyable;

		observers.remove(p_flyable);
		System.out.println("Tower says: " + aircraft.toString() + " unregistered to weather tower.");
	}

	protected Tower(){
		this.observers = new ArrayList<Flyable>();
	}
	protected void conditionChanged(){}
}
