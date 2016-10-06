import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject{
int speed;
public Projectile(int x,int y,int height,int width, int speed){
	this.x = x;
	this.y =y;
	this.height = height;
	this.width = width;
	this.speed = 10;
}
public void update(){
	y = y - speed;
	if (y <= 0) {
		isAlive = false;
	}
}
public void draw(Graphics g){
	g.setColor(Color.RED);
	g.drawRect(x, y, width, height);
}
}
