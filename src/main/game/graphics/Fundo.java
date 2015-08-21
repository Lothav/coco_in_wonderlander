package graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Fundo extends JPanel {
	private Image fundo;

	
	public void Fundo(){
		ImageIcon referencia = new ImageIcon("textures\\grassbg1.gif");
		fundo = referencia.getImage();
	}
	
	
	public void paint(Graphics g){
		Graphics graficos = (Graphics2D) g;
		graficos.drawImage(fundo, 0, 0, this);
	
		g.dispose();
		
	}
	
	public void actionPerformed(ActionEvent arg0){
		repaint();
		
	}
	
	public Image getFundo(){
		return fundo;
	}


	


	
	
}
