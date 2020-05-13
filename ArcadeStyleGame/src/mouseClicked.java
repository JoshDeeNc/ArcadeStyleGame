import java.util.*;

public class mouseClicked {

    private static final Map<Stage.State, MouseOpInterface> mouseOperations;

    static {
        final Map<Stage.State, MouseOpInterface> operations = new HashMap<>();
        operations.put(Stage.State.ChoosingActor, new MouseOpInterface() {
            @Override
            public void mouseClicked(Stage.State currentState, int x, int y) {
                new ChoosingActor(currentState, x, y);
            }
        });

        operations.put(Stage.State.SelectingNewLocation, new MouseOpInterface() {
            @Override
            public void mouseClicked(Stage.State currentState, int x, int y) {
                new SelectingNewLocation(currentState, x, y);
            }
        });

        operations.put(Stage.State.SelectingMenuItem, new MouseOpInterface() {
            @Override
            public void mouseClicked(Stage.State currentState, int x, int y) {
                new SelectingMenuItem(currentState, x, y);
            }
        });
        
        operations.put(Stage.State.SelectingTarget, new MouseOpInterface() {
            @Override
            public void mouseClicked(Stage.State currentState, int x, int y) {
                new SelectingTarget(currentState, x, y);
            }
        });

        mouseOperations = Collections.unmodifiableMap(operations);
    }

    public void mouseClick(List<MenuItem> menuOverlay, Grid grid, ArrayList<Actor> actors, List<Cell> cellOverlay, Optional<Actor> actorInAction, Stage.State currentState, int x, int y) {
        MouseOpInterface command = mouseOperations.get(currentState);

        if (command == null) {
            throw new IllegalArgumentException("Invalid state: " + currentState);
        }

        command.mouseClicked(currentState, x, y);
    }
}