package avaj_launcher.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import avaj_launcher.util.FileManager;

public class Tower {
	private List<Flyable> observers;
	private Iterator<Flyable> flyableIt;

	public void register(Flyable p_flyable)  {
		Aircraft aircraft = (Aircraft) p_flyable;

		observers.add(aircraft);
		FileManager.getFileInstance().printToOutputFile("Tower says: " + aircraft.toString() + " registered to weather tower.");
	}

	public void unregister(Flyable p_flyable)  {
		Aircraft aircraft = (Aircraft) p_flyable;

		flyableIt.remove();
		FileManager.getFileInstance().printToOutputFile("Tower says: " + aircraft.toString() + " unregistered to weather tower.");
	}

	protected Tower(){
		this.observers = new ArrayList<Flyable>();
	}
	
	protected void conditionChanged() {
		flyableIt = observers.iterator();

		while (flyableIt.hasNext())
			flyableIt.next().updateConditions();
	}
}
