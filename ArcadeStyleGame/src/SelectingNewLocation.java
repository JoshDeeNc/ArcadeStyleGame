import java.util.*;
public class SelectingNewLocation {

    public SelectingNewLocation(Stage.State currentState, int x, int y) {
        Optional<Cell> clicked = Optional.empty();
        for (Cell c : Stage.cellOverlay) {
            if (c.contains(x, y)) {
                clicked = Optional.of(c);
            }
        }
        if (clicked.isPresent() && Stage.actorInAction.isPresent()) {
            Stage.cellOverlay = new ArrayList<Cell>();
            Stage.actorInAction.get().setLocation(clicked.get());
            Stage.actorInAction.get().turns--;
            Stage.menuOverlay.add(new MenuItem("Fire", x, y, () -> {
                Stage.cellOverlay = Stage.grid.getRadius(Stage.actorInAction.get().loc, Stage.actorInAction.get().range, false);
                Stage.cellOverlay.remove(Stage.actorInAction.get().loc);
                Stage.currentState = Stage.State.SelectingTarget;
            }));
            Stage.currentState =  Stage.State.SelectingMenuItem;
        }
    }
}