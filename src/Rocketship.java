import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject{
	int speed;
	int xspeed = 0;
	int yspeed = 0;
public Rocketship(int x, int y, int width, int height, int speed){
super();
this.x = x;
this.y = y;
this.width = width;
this.height = height;
this.speed = 10;
}
	public static void main(String[] args) {
	
}
	
	public void draw(Graphics g){
		g.drawImage(rocketImg, x, y, width, height, null);
	}
	public void update(){
		super.update();
		y += yspeed;
		x += xspeed;
	}
}
