import java.awt.Color;
import java.util.ArrayList;
import info.gridworld.actor.*;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;

public class GameDriver {
	public static void main(String[] args) {
		BoundedGrid<Actor> grid = new BoundedGrid<Actor>(10, 10);
		BugSlamWorld world = new BugSlamWorld(grid);
		
		// Adding 2 plain bugs of color 0
		PlainBug b1 = new PlainBug(world.getColorList().get(0));
		PlainBug b2 = new PlainBug(world.getColorList().get(0));
		ArrayList<PlainBug> arrList = new ArrayList<PlainBug>();
		arrList.add(b1);
		arrList.add(b2);
		world.push(arrList);
		world.add(new Location(5, 5), b1);
		world.add(new Location(7, 7), b2);
		
		world.show();
	}
}
