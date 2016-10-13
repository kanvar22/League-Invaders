import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject{
	int speed;
	int xspeed = 0;
	int yspeed = 0;
public Rocketship(int x, int y, int width, int height, int speed){
this.x = x;
this.y = y;
this.width = width;
this.height = height;
this.speed = 10;
}
	public static void main(String[] args) {
	
}
	
	public void draw(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}
	public void update(){
		y += yspeed;
		x += xspeed;
	}
}
