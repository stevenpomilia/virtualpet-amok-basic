package VirtualPetAmok;

abstract class VirtualPet {

	private String name;
	private String description;
	private int healthLevel;
	private int happinessLevel;

	public VirtualPet(String name, String description, int healthLevel, int happinessLevel) {
		this.name = name;
		this.description = description;
		this.healthLevel = healthLevel;
		this.happinessLevel = happinessLevel;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getHealthLevel() {
		return healthLevel;
	}

	public int getHappinessLevel() {
		return happinessLevel;
	}

	public void setHappinessLevel(int happinessLevel) {
		this.happinessLevel = happinessLevel;
	}

	public void setHealthLevel(int healthLevel) {
		this.healthLevel = healthLevel;
	}

	void commandPlay() {
		setHappinessLevel(getHappinessLevel() + 10);
	}

	public void tick() {
	}

	public String getPetType() {
		String className = getClass().getSimpleName();
		return className;
	}

}