import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GameObject {
boolean isAlive = true;
int x;
int y;
int width;
int height;
public static BufferedImage alienImg;
public static BufferedImage rocketImg;
public static BufferedImage bulletImg;

Rectangle collisionBox;
GameObject(){
	collisionBox = new Rectangle( x,  y,  width,  height);
	try {
		alienImg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));
		rocketImg = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));
		bulletImg = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
 public void update(){
collisionBox.setBounds(x, y, width, height);
 }
 public void draw(Graphics g){
	 
 }
}
