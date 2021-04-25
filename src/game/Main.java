package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static Scanner in = new Scanner(System.in);

	public static void fightMalfoy(Player player) {
		int younumber, malfoy;
		System.out.println(
				"\n\nYou have entered the slythrien's common room\n here stand your enemy draco malfoy challenge him by press Y and go back by pressing N\n");
		String i = in.nextLine();
		if (i.charAt(0) == 'y') {
			do {
				malfoy = (int) (Math.random() * 10);
				younumber = (int) (Math.random() * 5);

				System.out.println("Malfoy point: " + malfoy);
				System.out.println("your point: " + younumber);
				if (younumber <= malfoy)
					System.out.println("\n\nOooo no malfoy got better than you this time try again\n\n");
			} while (younumber <= malfoy);
			System.out.println("You have won the challenge lets move forward to dark lord now");
		} else {
			System.out.println("\n\nYou have decided to move back lets leave malfoy today and kill the dark lord\n\n");
			player.move("w");
		}

	}

	public static void view(Player player) {
		int choice;
		do {
			System.out.println("curent room: " + player.getCurrent().getName());
			System.out.println("1.move");
			System.out.println("2.look");
			System.out.println("3.pickup");
			System.out.println("4.drop");
			System.out.println("5.inventory");
			System.out.println("7.exit");
			choice = Integer.parseInt(in.nextLine());
			if (choice == 1) {
				System.out.println("your option: ");
				for (int i = 0; i < 4; i++) {
					if (player.getCurrent().getNeigbhour()[i] != null) {
						if (i == 0)
							System.out.println("North(n): " + player.getCurrent().getNeigbhour()[i].getName());
						if (i == 1)
							System.out.println("West(w): " + player.getCurrent().getNeigbhour()[i].getName());
						if (i == 2)
							System.out.println("East(e): " + player.getCurrent().getNeigbhour()[i].getName());
						if (i == 3)
							System.out.println("South(s): " + player.getCurrent().getNeigbhour()[i].getName());
					}
				}
				System.out.println("Enter direction");
				String d = in.nextLine();
				player.move(d);
				if (player.getCurrent().getName() == "Dumboldor's office") {
					if (player.getInventory().indexOf("magic wand") > -1) {
						System.out.println(
								"You used the most deadly magic on dark lord Avada Kedavra. and there falls the dark lord");
						break;
					} else if (player.getInventory().indexOf("knife") > -1) {
						System.out.println("killed dark lord with knife");
						break;
					} else if (player.getInventory().indexOf("snake poison") > -1) {
						System.out.println("killed dark lord with snake poison");
						break;
					} else if (player.getInventory().indexOf("axe") > -1) {
						System.out.println("killed dark lord with axe");
						break;
					} else {
						System.out.println("kicked dark lord in the face and he falls");
						break;
					}
				} else if (player.getCurrent().getName() == "Slytherin's common room") {
					fightMalfoy(player);
				} else if (player.getCurrent().getName() == "Cliff") {
					System.out.println("Malfoy has fooled you u have fallen from the cliff you are dead");
					break;
				}
			} else if (choice == 2) {
				player.description();
			} else if (choice == 3) {
				player.pickup();
			} else if (choice == 4) {
				player.drop();
			} else if (choice == 5) {
				player.showInventory();
			} else {
				if (choice != 7) {
					System.out.println("Enter a valid choice");
				}
			}
		} while (choice != 7);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// initiali
		Room platform = new Room("platform 9 3/4",
				"you are about to enter the first only School of Witchcraft and Wizardry,Hogwarts \n u need to find the correct way to enter the school\n dont forget to pic up your luggage ");
		Room forest = new Room("forbidden forest",
				"Hurray, you have successfully enter the premises of Hogwarts\n but wait! something doesn't feel right around this time.\nDon't forget to pick up the lantern to explore the area...... \nForbidden Forest is one of the mysterious places in hogwarts please look around for usefull tools.");
		Room hut = new Room("hagrid's hut",
				"Hargrid the gate keeper of hogwarts place is always a mess \nwelcome says hagrid, \nBe carefull some thing is wrong around hogwards this time ");
		Room griffindor = new Room("griffindor's common room",
				"Finally here she is ,your firend Ron Weasley,Harry: Where is Hermione Granger? \nlets find her!!! ");
		Room slytherin = new Room("Slytherin's common room", "Slytherin is a howgwarts troublemakers house ");
		Room library = new Room("The library", "Library is full of books and favourite place of hermione ");
		Room cliff = new Room("Cliff", "Oops you are dead by falling off cliff\n");
		Room ror = new Room("The room of requirnment",
				"room of requirnment one can only discover this place when he/she really needs it.");
		Room office = new Room("Dumboldor's office", "the final destination you have to kill the dark lord.");
		platform.setNeigbhour(new Room[] { forest, null, null, null });
		forest.setNeigbhour(new Room[] { hut, null, null, platform });
		hut.setNeigbhour(new Room[] { null, griffindor, slytherin, forest });
		griffindor.setNeigbhour(new Room[] { ror, null, hut, null });
		slytherin.setNeigbhour(new Room[] { library, hut, null, null });
		library.setNeigbhour(new Room[] { null, cliff, null, slytherin });
		ror.setNeigbhour(new Room[] { office, null, null, griffindor });
		platform.setItems(new ArrayList<String>(Arrays.asList("luggage ", "Hedwig")));
		forest.setItems(new ArrayList<String>(Arrays.asList("lantern ", "axe")));
		hut.setItems(new ArrayList<String>(Arrays.asList("dragon's egg ")));
		griffindor.setItems(new ArrayList<String>(Arrays.asList("Sword of Gryffindor ")));
		slytherin.setItems(new ArrayList<String>(Arrays.asList("snake poison ")));
		library.setItems(new ArrayList<String>(Arrays.asList("hermine books ")));
		ror.setItems(new ArrayList<String>(Arrays.asList("knife ", "magic wand")));
		Player me = new Player(platform);

		view(me);
	}

}
