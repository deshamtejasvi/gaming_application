

package maze;

public class MazeMoveCommand implements UndoableCommand { 

  public MazeMoveCommand(Maze maze, Direction direction) { 
    this.maze = maze;
    this.direction = direction; 
    System.out.println(" move command");
  }

  public void execute() {
	  System.out.println("excute move command");
    maze.move(direction); 
  }

  public void undo() {
	  System.out.println("undo move command");
    maze.move(direction.opposite()); 
  }

  protected Maze maze; 
  protected Direction direction; 

}
