import java.util.*;
public class SelectingMenuItem {

    public SelectingMenuItem(Stage.State currentState, int x, int y) {
    for(MenuItem mi : Stage.menuOverlay){
            if (mi.contains(x,y)){
                mi.action.run();
                Stage.menuOverlay = new ArrayList<MenuItem>();
            }
        }
    }
}