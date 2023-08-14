package VirtualPetAmok;

public class OrganicCat extends VirtualPet implements Organic {

	private int hungerLevel;
	private int thirstLevel;

	public OrganicCat(String name, String description, int healthLevel, int happinessLevel, int hungerLevel,
			int thirstLevel) {
		super(name, description, healthLevel, happinessLevel);
		this.hungerLevel = hungerLevel;
		this.thirstLevel = thirstLevel;
	}

	public int getHungerLevel() {
		return hungerLevel;
	}

	public int getThirstLevel() {
		return thirstLevel;
	}

	public void commandFeed() {
		hungerLevel -= 25;
		thirstLevel += 5;
	}

	public void commandWater() {
		thirstLevel -= 25;
	}

	public void tick() {
		hungerLevel += 5;
		thirstLevel += 5;
		setHappinessLevel(getHappinessLevel() - 1);
		if (hungerLevel >= 100 || thirstLevel >= 100 || getHappinessLevel() <= 0) {
			setHealthLevel(getHealthLevel() - 10);
		}
	}
}