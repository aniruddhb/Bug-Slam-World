import java.awt.Color;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class PlainBug extends Bug {
	public PlainBug() {
		setColor(Color.RED);
	}
	
	public PlainBug(Color c) {
		setColor(c);
	}
	
	public void move() {
		Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (gr.isValid(next))
            moveTo(next);
        else
            removeSelfFromGrid();
	}
	
	public boolean hasPlace(Location x) {
		if (getGrid().isValid(x)) {
			return true;
		} 
		return false;
	}
	
	public boolean hasOtherBug(Location x) {
		if (getGrid().get(x) != null) {
			return true;
		}
		return false;
	}
	
	public Color getColor() {
		return getColor();
	}
}
