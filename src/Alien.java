import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Alien extends GameObject{
	Random rand;
public Alien(int x, int y, int height, int width){
	this.x = x;
	this.height = height;
	this.width = width;
	 rand = new Random();
	 
}
public void draw(Graphics g){
	g.setColor(Color.YELLOW);
	g.fillRect(x, y, width, height);
}
public void update(){
	int n = rand.nextInt(50) + 1;
	y = n;
	y ++;
}
}
