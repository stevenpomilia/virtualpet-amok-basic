package VirtualPetAmok;

public class OrganicDog extends Walkable implements Organic {

	private int hungerLevel;
	private int thirstLevel;
	private int wasteLevel;

	public OrganicDog(String name, String description, int healthLevel, int happinessLevel, int hungerLevel,
			int thirstLevel, int wasteLevel) {
		super(name, description, healthLevel, happinessLevel);
		this.hungerLevel = hungerLevel;
		this.thirstLevel = thirstLevel;
		this.wasteLevel = wasteLevel;
	}

	public int getHungerLevel() {
		return hungerLevel;
	}

	public int getThirstLevel() {
		return thirstLevel;
	}

	public int getWasteLevel() {
		return wasteLevel;
	}

	public void commandFeed() {
		hungerLevel -= 25;
		thirstLevel += 1;
	}

	public void commandWater() {
		thirstLevel -= 25;
	}

	public void cleanCanineCages() {
		wasteLevel -= 50;
	}

	public void tick() {
		hungerLevel += 5;
		thirstLevel += 5;
		wasteLevel += 5;
		setHappinessLevel(getHappinessLevel() - 1);
		if (hungerLevel >= 100 || thirstLevel >= 100 || wasteLevel >= 100 || getHappinessLevel() <= 0) {
			setHealthLevel(getHealthLevel() - 10);
		}
	}

	public void walkOrganicDogs() {
		super.walkOrganicDogs();
		wasteLevel -= 25;
	}
}