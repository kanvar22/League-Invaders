import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Alien extends GameObject{
	Random rand;
public Alien(int x, int y, int height, int width){
	super();
	this.x = x;
	this.height = height;
	this.width = width;
	 rand = new Random();
	 
}
public void draw(Graphics g){
	g.drawImage(alienImg, x, y, width, height, null);

}
public void update(){
	super.update();
	y += 5
			;
}
}
