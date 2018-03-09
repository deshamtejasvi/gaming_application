

package maze; 

import java.awt.*;
import java.io.File;
import java.net.URL;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import java.applet.Applet;
import java.applet.AudioClip; 

public class Door implements MapSite { 

  public Door(Room room1, Room room2) { 
    this.room1 = room1;
    this.room2 = room2;
  }

  public Object clone() throws CloneNotSupportedException { 
    return super.clone();
  }

  public boolean isOpen() { 
    return open; 
  }

  public void setOpen(boolean open) { 
    this.open = open; 
  }

  public void setRooms(Room room1, Room room2) { 
    this.room1 = room1;
    this.room2 = room2;
  }

  public Orientation getOrientation() { 
    return orientation;
  }

  public void setOrientation(Orientation orientation) { 
    this.orientation = orientation;
  }

  public Room otherSideFrom(Room room) { 
    if (room != null) { 
      if (room == room1) {
	return room2; 
      } else if (room == room2) {
	return room1; 
      }
    }
    return null; 
  }

  public void enter(Maze maze) {
    if (open) { 
      Room otherRoom = otherSideFrom(maze.getCurrentRoom());
      if (otherRoom != null) { 
	otherRoom.enter(maze); 
      }
    } else { 
      //ding.play();
    	File f = new File("blip.wav");
  	  try
        {
            Clip clip=AudioSystem.getClip();    
            clip.open(AudioSystem.getAudioInputStream(f));
            clip.start();
        }
        catch(Exception e)
        {
            
        }
    }
  }

  public void draw(Graphics g, int x, int y, int w, int h) {
    g.setColor(Wall.WALL_COLOR); 
    g.fillRect(x, y, w, h); 
    if (orientation == Orientation.VERTICAL) { 
      y += 2 * w; h -= 4 * w;
    } else { 
      x += 2 * h; w -= 4 * h; 
    }
    if (open) { 
      g.setColor(Room.ROOM_COLOR);
      g.fillRect(x, y, w, h); 
    } else { 
      g.setColor(Color.red);
      g.fillRect(x, y, w, h); 
      g.setColor(Color.black);
      g.drawRect(x, y, w, h); 
    }    
  }

  protected Room room1;
  protected Room room2;
  protected boolean open; 
  protected Orientation orientation; 

  /*protected static AudioClip ding;
  static{
  try{
      ding = Applet.newAudioClip(new URL("http://www.wavsource.com/snds_2016-03-13_7646817315637486/sfx/floop2_x.wav"));
    	}
    	catch(Exception e){
    		
    	}
  }*/
  
  //protected static AudioClip ding = util.AudioUtility.getAudioClip("audio/ding.au"); 

}
