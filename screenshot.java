// Author: #Captain_Nemo
import java.lang.*;
import javax.sound.sampled.*;
import java.io.*;
import java.awt.AWTException; 
import java.awt.Rectangle; 
import java.awt.Toolkit; 
import java.awt.Robot; 
import java.awt.image.BufferedImage; 
import java.io.IOException; 
import java.io.File; 
import javax.imageio.ImageIO; 


 public class screenshot {
   static int incr =1;  
     static final long serialVersionUID = 1L;
     void start_ss_cap(){  
    try {
          
            Thread.sleep(300);  // wait for 300 millisecond
            Robot robo = new Robot(); 
            String loc = System.getenv("TEMP"); 
            System.out.println(loc);
            String Filename = "Shot";
            Rectangle cap = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()); 
            BufferedImage Im = robo.createScreenCapture(cap); 
            ImageIO.write(Im, "jpg", new File(loc + "\\" +  Filename + incr +  ".jpg"));
           
         } //end try 
               catch (AWTException | IOException | InterruptedException ex){} 
              //End Catch
        } // end start_ss_cap method

        public static void main(String args[]) { 

             final screenshot sc = new  screenshot(); //instantaniate  a new screenshot object         
           Thread t1 = new Thread(new Runnable() 
            {
                public void run()
                 {
                   try {
                          Thread.sleep(300);
                              while (true)
                              {
                              sc.start_ss_cap(); //call method start_ss_cap()
                              incr ++;
                              }
                       }catch (InterruptedException ex)
                            {
                              ex.printStackTrace();
                            } //end catch
                 } //end run
             }); //end thread def t1
                t1.start(); //start thread
         } //end main
 } //end class def
   
