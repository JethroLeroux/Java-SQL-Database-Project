/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JethroLeroux;

import java.io.*;
import javax.swing.JOptionPane;
import javazoom.jl.decoder.JavaLayerException;//javazoom sound decoder. javazoom is a resource from a library JAR file
import javazoom.jl.player.*;//javazoom player

/**
 *
 * @author Jethro
 */
public class PlaySound {
    public PlaySound()
    {
    try     //for playing sound effect
        {
            File sound = new File("confirm sound effect.MP3");//create new file
            FileInputStream fis = new FileInputStream(sound);//create new FileInputStream object using File Object
            BufferedInputStream bis = new BufferedInputStream(fis);//create new BufferedInputStream object using FileInputStream Object
            
            try{
                Player soundPlayer  = new Player(bis);  //create a new Player object to play the action performed sound
                soundPlayer.play(); //play the sound
            }catch(JavaLayerException ex){JOptionPane.showMessageDialog(null, "Could not play sound");} //catch error
            
            
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Could not load MP3 file"+e);
            e.printStackTrace();
        }
    }
   
}
