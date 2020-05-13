import java.util.*;

public class SelectingTarget {

    public SelectingTarget(Stage.State currentState, int x, int y) {
        for (Cell c : Stage.cellOverlay) {
            if (c.contains(x, y)) {
                Optional<Actor> oa = actorAt(c);
                if (oa.isPresent()) {
                    oa.get().makeRedder(0.1f);
                }
            }
        }
        Stage.cellOverlay = new ArrayList<Cell>();
        int redsWithMovesLeft = 0;
        int totalRedness = 0;
        for (Actor a : Stage.actors) {
            if (a.isTeamRed()) {
                totalRedness++;
                if (a.turns > 0) {
                    redsWithMovesLeft++;
                }
            }
        }
        if (totalRedness == Stage.actors.size()) {
            Stage.menuOverlay.add(new MenuItem("You Won!", x, y, () -> System.exit(0)));
            Stage.currentState = Stage.State.SelectingMenuItem;
            return;
        }
        if (redsWithMovesLeft > 0) {
            Stage.currentState = Stage.State.ChoosingActor;
            return;
        }
        Stage.currentState = Stage.State.CPUMoving;
        return;
    }
    public static Optional<Actor> actorAt(Cell c) {
        for(Actor a: Stage.actors){
            if (a.loc == c){
                return Optional.of(a);
            }
        }
        return Optional.empty();
    }
}