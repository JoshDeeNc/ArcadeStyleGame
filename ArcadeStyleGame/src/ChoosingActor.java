import java.util.*;

public class ChoosingActor {

    public ChoosingActor(Stage.State currentState, int x, int y) {
        Stage.actorInAction = Optional.empty();
        for (Actor a : Stage.actors) {
            if (a.loc.contains(x, y) && a.isTeamRed() && a.turns > 0) {
                Stage.cellOverlay = Stage.grid.getRadius(a.loc, a.moves, true);
                Stage.actorInAction = Optional.of(a);
                Stage.currentState = Stage.State.SelectingNewLocation;
            }
        }
        if (!Stage.actorInAction.isPresent()) {
            Stage.currentState = Stage.State.SelectingMenuItem;
            Stage.menuOverlay.add(new MenuItem("Oops", x, y, () -> Stage.currentState = Stage.State.ChoosingActor));
            Stage.menuOverlay.add(
                    new MenuItem("End Turn", x, y + MenuItem.height, () -> Stage.currentState = Stage.State.CPUMoving));
            Stage.menuOverlay.add(new MenuItem("End Game", x, y + MenuItem.height * 2, () -> System.exit(0)));
        }
    }
}