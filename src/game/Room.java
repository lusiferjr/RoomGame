package game;

import java.util.ArrayList;
//room class cotain roomname,neighbours,list of items in room,description
public class Room {
	private Room[] neigbhour = new Room[4];
	private String name;
	private ArrayList<String> items = new ArrayList<String>();
	private String discription;
	//getter,setter for name
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
//getter,setter for items in room
	public ArrayList<String> getItems() {
		return items;
	}

	public void setItems(ArrayList<String> items) {
		this.items = items;
	}
	
	public Room( String name,  String discription) {
		super();
		for(Room i:neigbhour) {
			i=null;
		}
		this.name = name;
		
		this.discription = discription;
	}

	public void additem(String item) {
		items.add(item);
	}

	public void removeitem(String item) {
		if (items.indexOf(item) > -1) {
			items.remove(items.indexOf(item));
		}
	}

	public Room[] getNeigbhour() {
		return neigbhour;
	}

	public void setNeigbhour(Room[] neigbhour) {
		this.neigbhour = neigbhour;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}
}
