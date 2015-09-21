import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;
import java.awt.Color;
import java.util.ArrayList;

public class BugSlamWorld extends World {
	ArrayList<Color> colorList = new ArrayList<Color>();
	ArrayList<PlainBug> arrOfBugs;
	
	public BugSlamWorld(Grid<Actor> g) {
		super(g);
		colorList.add(Color.red);
		colorList.add(Color.orange);
		colorList.add(Color.green);
		colorList.add(Color.blue);
		colorList.add(Color.pink);
		colorList.add(Color.magenta);
		colorList.add(Color.black);
	}
	
	public ArrayList<Color> getColorList() {
		return colorList;
	}
	
	public boolean keyPressed(String description, Location loc) {
		if (description.equals("UP")) {
			// System.out.println(description);
			for (int i = 0; i < arrOfBugs.size(); i++) {
				Location above = new Location(arrOfBugs.get(i).getLocation().getRow() - 1, arrOfBugs.get(i).getLocation().getCol());
				while (arrOfBugs.get(i).hasPlace(above)) {
					if (arrOfBugs.get(i).hasOtherBug(above)) {
						PlainBug other = (PlainBug) (getGrid().get(above));
						Color otherColor = other.getColor();
						int levelOfOther = getLevel(otherColor);
						if (otherColor.equals(arrOfBugs.get(i).getColor())) {
			        arrOfBugs.get(i).moveTo(above);
							other.removeSelfFromGrid();
			        arrOfBugs.get(i).setColor(colorList.get(levelOfOther + 1));
						} else {
						  arrOfBugs.get(i).moveTo(above);
						}
					}
	        arrOfBugs.get(i).moveTo(new Location(loc.getRow() - 1, loc.getCol()));
				}
			}
	} else if (description.equals("DOWN")) {
			// System.out.println(description);
			for (PlainBug pb : arrOfBugs) {
				pb.setDirection(Location.SOUTH);
				while (pb.canMove()) {
					pb.move();
				}
			}
		} else if (description.equals("LEFT")) {
			// System.out.println(description);
			for (PlainBug pb : arrOfBugs) {
				pb.setDirection(Location.WEST);
			}
      
      while (pb.canMove()) {
					pb.move();
				}
			}
		} else if (description.equals("RIGHT")) {
			// System.out.println(description);
			for (PlainBug pb : arrOfBugs) {
				pb.setDirection(Location.EAST);
				while (pb.canMove()) {
					pb.move();
				}
			}
		}
		return false;
	}
	
	public int getLevel(Color c) {
		if (c.equals(colorList.get(0))) {
	    return 0;
		} else if (c.equals(colorList.get(1))) {
			return 1;
		} else if (c.equals(colorList.get(2))) {
			return 2;
		} else if (c.equals(colorList.get(3))) {
			return 3;
		} else if (c.equals(colorList.get(4))) {
			return 4;
		} else if (c.equals(colorList.get(5))) {
			return 5;
	  } else if (c.equals(colorList.get(6))) {
			return 6;
		} else if (c.equals(colorList.get(7))) {
			return 7;
		}
		return 0;
	}

	public void push(ArrayList<PlainBug> arrList) {
		arrOfBugs = arrList;
	}
}
