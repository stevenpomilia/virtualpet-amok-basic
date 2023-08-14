package VirtualPetAmok;

public class RoboticDog extends VirtualPet implements Robot {

	private int maintenanceLevel;

	public RoboticDog(String name, String description, int healthLevel, int happinessLevel, int maintenanceLevel) {
		super(name, description, healthLevel, happinessLevel);
		this.maintenanceLevel = maintenanceLevel;
	}

	public int getMaintenanceLevel() {
		return maintenanceLevel;
	}

	@Override
	public void commandOil() {
		maintenanceLevel -= 25;

	}

	public void tick() {
		maintenanceLevel += 5;
		setHappinessLevel(getHappinessLevel() - 2);
		if (maintenanceLevel >= 100 || getHappinessLevel() <= 0) {
			setHealthLevel(getHealthLevel() - 10);
		}
	}
}