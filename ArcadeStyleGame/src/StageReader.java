import java.io.*;
import java.util.*;
import java.util.regex.*;

class StageReader {
    public static Stage readStage(String path){
        Stage stage = new Stage();
        try{
            Properties props = (new Properties());
            props.load(new FileInputStream(path));
            for (String key : props.stringPropertyNames()) {
                String value = props.getProperty(key);
                Pattern range = Pattern.compile("(.)(\\d+)->(.)(\\d+)");
                Pattern cell = Pattern.compile("(.)(\\d+)");
                List<Cell> cellsInQuestion = new ArrayList<Cell>();
                Matcher rangeMatcher = range.matcher(key);
                Matcher cellMatcher = cell.matcher(key);
                if(rangeMatcher.matches()){
                    cellsInQuestion = Stage.grid.cellsInRange(rangeMatcher.group(1).charAt(0),
                                                              Integer.parseInt(rangeMatcher.group(2)),
                                                              rangeMatcher.group(3).charAt(0),
                                                              Integer.parseInt(rangeMatcher.group(4))
                                                             );
                } else if (cellMatcher.matches()) {
                    Stage.grid.cellAtColRow(cellMatcher.group(1).charAt(0), Integer.parseInt(cellMatcher.group(2)))
                            .ifPresent(cellsInQuestion::add);
                } else {System.out.println("no match");}
                for (Cell c : cellsInQuestion) {
                    if (value.equals("road")){
                        Stage.grid.replaceCell(c, new Road(c.col, c.row, c.x, c.y));
                    }else if (value.equals("water")){
                        Stage.grid.replaceCell(c, new Water(c.col, c.row, c.x, c.y));
                    }else if (value.equals("mountain")){
                        Stage.grid.replaceCell(c, new Mountain(c.col, c.row, c.x, c.y));
                    }else if (value.equals("puppy red")){
                        Stage.actors.add(new Puppy(c, 1.0f));
                    }else if (value.equals("puppy blue")){
                        Stage.actors.add(new Puppy(c, 0.0f));
                    }else if (value.equals("lion red")){
                        Stage.actors.add(new Lion(c, 1.0f));
                    }else if (value.equals("lion blue")){
                        Stage.actors.add(new Lion(c, 0.0f));
                    }else if (value.equals("bunny red")){
                        Stage.actors.add(new Rabbit(c, 1.0f));
                    }else if (value.equals("bunny blue")){
                        Stage.actors.add(new Rabbit(c, 0.0f));
                    }
                }
            }
        } catch (IOException e){

        }
        return stage;
    }
}