package com.example.demo;

import java.util.Scanner;

public class VirtualPetAmokApp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		VirtualPetShelter shelter = new VirtualPetShelter();

		VirtualPet scout = new OrganicDog("Scout", "Mini Australian Shepherd", 10, 7, 7, 7, 7);
		shelter.addPet(scout);
		VirtualPet electrike = new RoboticDog("Electrike", "Electric Pup", 10, 6, 8);
		shelter.addPet(electrike);
		VirtualPet gizmo = new OrganicCat("Gizmo", "Organic Grey Furrball", 10, 10, 4, 6);
		shelter.addPet(gizmo);
		VirtualPet felix = new RoboticCat("Felix", "Orange twitchy kitty", 10, 7, 4);
		shelter.addPet(felix);

		startupGreeting();

		do {
			System.out.println("All admitted organic dogs and wellness levels:\n");
			System.out.println("Name \t|Health |Happiness |Hunger |Thirst |Cleanliness");
			for (VirtualPet availablePets : shelter.availablePets()) {
				if (availablePets instanceof OrganicDog) {
					System.out.println(availablePets.getName() + "\t|" + availablePets.getHealthLevel() + "\t|"
							+ availablePets.getHappinessLevel() + "\t   |"
							+ ((OrganicDog) availablePets).getHungerLevel() + "\t   |"
							+ ((OrganicDog) availablePets).getThirstLevel() + "\t   |"
							+ ((OrganicDog) availablePets).getWasteLevel());
				}
			}

			System.out.println("\nAll admitted organic cats and wellness levels:\n");
			System.out.println("Name \t|Health |Happiness |Hunger |Thirst |Shelter Litter Box");
			for (VirtualPet availablePets : shelter.availablePets()) {
				if (availablePets instanceof OrganicCat) {
					System.out.println(availablePets.getName() + "\t|" + availablePets.getHealthLevel() + "\t|"
							+ availablePets.getHappinessLevel() + "\t   |"
							+ ((OrganicCat) availablePets).getHungerLevel() + "\t   |"
							+ ((OrganicCat) availablePets).getThirstLevel() + "\t   |"
							+ shelter.getLitterBoxWasteLevel());
				}
			}

			System.out.println("\nAll admitted robotic dogs and their wellness levels:\n");
			System.out.println("Name \t|Health |Happiness |Maintenance");
			for (VirtualPet availablePets : shelter.availablePets()) {
				if (availablePets instanceof RoboticDog) {
					System.out.println(availablePets.getName() + "\t|" + availablePets.getHealthLevel() + "\t|"
							+ availablePets.getHappinessLevel() + "\t   |"
							+ ((RoboticDog) availablePets).getMaintenanceLevel());
				}
			}

			System.out.println("\nAll admitted robotic cats and their wellness levels:\n");
			System.out.println("Name \t|Health |Happiness |Maintenance");
			for (VirtualPet availablePets : shelter.availablePets()) {
				if (availablePets instanceof RoboticCat) {
					System.out.println(availablePets.getName() + "\t|" + availablePets.getHealthLevel() + "\t|"
							+ availablePets.getHappinessLevel() + "\t   |"
							+ ((RoboticCat) availablePets).getMaintenanceLevel());
				}
			}

			System.out.println(petStatusMenu());

			String action = input.next();

			switch (action) {

				case "1":
					shelter.feedAllOrganics();
					shelter.shelterTick();
					System.out.println("All organic pets have been fed to the brim.\n");
					break;

				case "2":
					shelter.waterAllOrganics();
					shelter.shelterTick();
					System.out.println("All organic pets are now fully hydrated.\n");
					break;
				case "3":
					System.out.println("Enter which pet you would like to play with:\n");
					for (VirtualPet availablePets : shelter.availablePets()) {
						System.out.println(availablePets.getName() + "\t|" +
								availablePets.getDescription());
					}

					String petName;

					boolean validPetName = false;

					while (!validPetName) {
						petName = input.next(); // Assign the input to the variable

						for (VirtualPet availablePet : shelter.availablePets()) {
							if (availablePet.getName().equalsIgnoreCase(petName)) {
								availablePet.commandPlay();
								shelter.shelterTick();
								System.out.println("\n" + availablePet.getName()
										+ " drools from excitement after a nice play session.\n");
								validPetName = true;
								break; // Exits loop when valid sheltered pet is inputted
							}
						}

						if (!validPetName) {
							System.out.println("Invalid pet name. Please enter a valid pet name:");
						}
					}
					break;

				case "4":
					shelter.walkOrganicDogs();
					shelter.shelterTick();
					System.out.println("The organic dogs loved their walk through the park!\n");
					break;
				case "5":
					shelter.cleanAllDogCages();
					shelter.shelterTick();
					System.out.println("The dog cages have been scrubbed with Simple Green, now smelling wonderful.");
					break;
				case "6":
					shelter.cleanTheLitterBox();
					shelter.shelterTick();
					System.out
							.println(
									"Now the cats don't have to step in my own waste - the cats rub against your leg.\n");
					break;
				case "7":
					shelter.maintainRoboticPets();
					shelter.shelterTick();
					System.out.println("The robotic pets have been replenished with oil.\n");
					break;
				case "8":
					shelter.addPet(newStrayOrganicDog(input));
					shelter.shelterTick();
					break;
				case "9":
					shelter.addPet(newStrayOrganicCat(input));
					shelter.shelterTick();
					break;
				case "10":
					shelter.addPet(newStrayRoboticDog(input));
					shelter.shelterTick();
					break;
				case "11":
					shelter.addPet(newStrayRoboticCat(input));
					shelter.shelterTick();
					break;
				case "12":
					System.out.println("Enter the pet's name you would like to adopt: ");
					petName = input.next();
					shelter.currentShelterCollective.remove(petName);
					shelter.shelterTick();
					break;
				case "13":
					System.out.println("Thank you for visiting The Pontiac Pet Shelter! Come back to visit soon.");
					System.exit(0);
					break;
				default:
					System.out.println("Enter a valid action ID #.");
			}
		} while (shelter.arePetsAvailable() == false);

	}

	private static String startupGreeting() {
		return "Welcome to the Pontiac Dog Shelter AMOK!";

	}

	private static String petStatusMenu() {
		return " _________________________________\n" +
				"|                                 |\n" +
				"|  1. Feed All Organic Pets       |\n" +
				"|  2. Hydrate All Organic Pets    |\n" +
				"|  3. Play with a pet             |\n" +
				"|  4. Walk All Dogs               |\n" +
				"|  5. Clean all dog cages         |\n" +
				"|  6. Clean the litter box        |\n" +
				"|  7. Oil all robots              |\n" +
				"|  8. Admit an organic dog    	  |\n" +
				"|  9. Admit an organic cat    	  |\n" +
				"| 10. Admit a robotic dog         |\n" +
				"| 11. Admit a robotic cat         |\n" +
				"| 12. Adopt a pet                 |\n" +
				"| 13. Quit                        |\n" +
				"|_________________________________|\n" +
				"Enter a number to continue: ";
	}

	private static VirtualPet newStrayOrganicDog(Scanner input) {
		System.out.println("Enter the name of the dog:");
		String name = input.next();
		System.out.println("Enter a description of the dog:");
		String description = input.next();
		return new OrganicDog(name, description, 10, 10, 10, 10, 10);
	}

	private static VirtualPet newStrayOrganicCat(Scanner input) {
		System.out.println("Enter the name of the cat:");
		String name = input.next();
		System.out.println("Enter a description of the cat:");
		String description = input.next();
		return new OrganicCat(name, description, 10, 10, 10, 10);
	}

	private static VirtualPet newStrayRoboticDog(Scanner input) {
		System.out.println("Enter the name of the dog:");
		String name = input.next();
		System.out.println("Enter a description of the dog:");
		String description = input.next();
		return new RoboticDog(name, description, 10, 10, 10);
	}

	private static VirtualPet newStrayRoboticCat(Scanner input) {
		System.out.println("Enter the name of the cat:");
		String name = input.next();
		System.out.println("Enter a description of the cat:");
		String description = input.next();
		return new RoboticCat(name, description, 10, 10, 10);

	}

}