

package maze; 

import java.awt.*;
import java.io.File;
import java.net.URL;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import java.applet.Applet;
import java.applet.AudioClip; 

public class Wall implements MapSite { 

  public static final Color WALL_COLOR = Color.orange;

  public Object clone() throws CloneNotSupportedException { 
    return super.clone();
  }

  public void enter(Maze maze) {
   //hurts.play();
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

  public void draw(Graphics g, int x, int y, int w, int h) {
    g.setColor(WALL_COLOR); 
    g.fillRect(x, y, w, h); 
  }
 /* protected static AudioClip hurts;
  static{
  try{
      hurts = Applet.newAudioClip(new URL("http://www.wavsource.com/snds_2016-03-13_7646817315637486/sfx/floop2_x.wav"));
    	}
    	catch(Exception e){
    		
    	}
  }*/
  

  //protected static AudioClip hurts = util.AudioUtility.getAudioClip("audio/that.hurts.au"); 

}
