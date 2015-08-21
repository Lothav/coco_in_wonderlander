package entity;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Audio {
	
	private Clip clip = null;
	
	public Clip runs = loadClip("/Run3.wav");
	public Clip cocoatiras = loadClip("/CocoAtira.wav");
	public Clip cocosofres = loadClip("/Sofre.wav");
	public Clip porcos = loadClip("/Porco.wav");
	public Clip porcoexpls = loadClip("/PorcoExplode.wav");
	public Clip cocoexpls = loadClip("/CocoExplode.wav");
	public Clip macacooncoco = loadClip("/MacacoOnCoco.wav");
	public Clip toincoammo = loadClip("/ToincoAmmo.wav");
	public Clip freeze = loadClip("/Freeze.wav");
	public Clip chave = loadClip("/Chave.aif");
	public Clip pAbrindo = loadClip("/PAbrindo.wav");
	//public Clip credits = loadClip("/Credits.wav");
	public Clip Ranieri = loadClip("/Ranieri.wav");
	public Clip Ranieri2 = loadClip("/Ranieri2.wav");
	public Clip RanieriScream = loadClip("/RanieriScream.wav");

	
	private float volume;


	//println
	public Clip loadClip( String filemname )
	{
		try{
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(getClass().getResource( filemname ));
			clip = AudioSystem.getClip();
			clip.open(audioIn);
		}
		catch(Exception e){
			e.printStackTrace();
			
		}	
		
		return clip;
	}
	
	 public void playClip( Clip clip, float volume ){
         clip.setFramePosition(0);  // Must always rewind!
         clip.loop(0);
         this.volume  = volume;
         if (volume == 0) volume = -20.0f;
         
         FloatControl gainControl = 
        		    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        		gainControl.setValue(volume);
        		
         clip.start();
     }
     public void loop(){
         clip.loop(Clip.LOOP_CONTINUOUSLY);
     }
     public void stop(){
         clip.stop();
     }
	
}
