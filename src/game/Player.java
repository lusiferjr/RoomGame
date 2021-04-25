package game;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
	Scanner in = new Scanner(System.in);
	private ArrayList<String> inventory = new ArrayList<String>();
	private Room current;

	public ArrayList<String> getInventory() {
		return inventory;
	}

	public void setInventory(ArrayList<String> inventory) {
		this.inventory = inventory;
	}

	public Room getCurrent() {
		return current;
	}

	public void setCurrent(Room current) {
		this.current = current;
	}

	public Player(Room current) {
		super();
		this.current = current;
	}

	public void move(String direction) {

		if (direction.charAt(0) == 'n') {
			if (this.current.getNeigbhour()[0] != null) {
				this.current = this.current.getNeigbhour()[0];
				System.out.println(this.current.getDiscription());
			} else {
				System.out.println("there is no room in that direction try choicing other direction");
			}
		} else if (direction.charAt(0) == 'w') {
			if (this.current.getNeigbhour()[1] != null) {
				this.current = this.current.getNeigbhour()[1];
				System.out.println(this.current.getDiscription());
			} else {
				System.out.println("there is no room in that direction try choicing other direction");
			}
		} else if (direction.charAt(0) == 'e') {
			if (this.current.getNeigbhour()[2] != null) {
				this.current = this.current.getNeigbhour()[2];
				System.out.println(this.current.getDiscription());
			} else {
				System.out.println("there is no room in that direction try choicing other direction");
			}
		} else if (direction.charAt(0) == 's') {
			if (this.current.getNeigbhour()[3] != null) {
				this.current = this.current.getNeigbhour()[3];
				System.out.println(this.current.getDiscription());
			} else {
				System.out.println("there is no room in that direction try choicing other direction");
			}
		} else {
			System.out.println("invalid direction");
		}
	}

	public void description() {
		System.out.println(this.current.getDiscription());
		System.out.println("item on ground: ");
		int count=1;
		for (String i : this.current.getItems()) {
			System.out.println(count+": "+i);
			count++;
		}
	}

	public void pickup() {
		int count = 1;
		if (this.current.getItems().size() > 0) {
			for (String i : this.current.getItems()) {
				System.out.println(count + ": " + i);
				count++;
			}
			int i = in.nextInt();
			if (i <= count && i > 0) {
				inventory.add(this.current.getItems().get(i - 1));
				this.current.removeitem(this.current.getItems().get(i - 1));
			}
		} else {
			System.out.println("there is nothing in this room");
		}
	}

	public void drop() {
		int count = 1;
		if (inventory.size() > 0) {
			for (String i : inventory) {
				System.out.println(count + ": " + i);
				count++;
			}
			int i = in.nextInt();
			if (i > 0 && i <= count) {
				this.current.additem(inventory.get(i - 1));
				this.inventory.remove(i - 1);
			}
		} else {
			System.out.println("inventery is already empty");
		}
	}

	public void showInventory() {
		int count = 1;
		System.out.println("inventory has the following items");
		if (inventory.size() > 0) {
			for (String i : inventory) {
				System.out.println(count + ": " + i);
				count++;
			}
		} else {
			System.out.println("inventery is already empty");
		}
	}
}
