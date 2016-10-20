
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
Timer timer;	
Font titleFont;
Rocketship ship;
ObjectManager manager;
final int MENU_STATE = 0;
final int GAME_STATE = 1;
final int END_STATE = 2;
int currentState = MENU_STATE;
public GamePanel(){
	timer = new Timer(1000/60, this);
	titleFont = new Font("Arial", Font.PLAIN, 48);
	ship = new Rocketship(250, 700, 50, 50, 5);
	manager = new ObjectManager();
	
	manager.addObject(ship);
}
public void startGame(){
	timer.start();
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
repaint();
if(currentState == MENU_STATE){
	updateMenuState();
}
else if(currentState == GAME_STATE){
	updateGameState();
}
else if(currentState == END_STATE){
	updateEndState();
}
}
public void paintComponent(Graphics g){
	if(currentState == MENU_STATE){
		drawMenuState(g);
	}
	else if(currentState == GAME_STATE){
		drawGameState(g);
	}
	else if(currentState == END_STATE){
		drawEndState(g);
	}
}
@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	System.out.println("Hello");
}
@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	System.out.println("Hi");
	if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		currentState ++;
	}
	if (currentState > END_STATE) {
		currentState = MENU_STATE;
	}
	if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
		ship.xspeed += ship.speed;
		
	}
	if (e.getKeyCode() == KeyEvent.VK_LEFT) {
		ship.xspeed -= ship.speed;
		
	}
	if (e.getKeyCode() == KeyEvent.VK_DOWN) {
		ship.yspeed += ship.speed;
		
	}
	if (e.getKeyCode() == KeyEvent.VK_UP) {
		ship.yspeed -= ship.speed;
		
	}
	if (e.getKeyCode() == KeyEvent.VK_SPACE) {
		manager.addObject(new Projectile(ship.x + ship.width/2 - 5,ship.y,10,10,20));
	}
}
@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	System.out.println("Hey");
	if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
		ship.xspeed -= ship.speed;
		
	}
	if (e.getKeyCode() == KeyEvent.VK_LEFT) {
		ship.xspeed += ship.speed;
		
	}
	if (e.getKeyCode() == KeyEvent.VK_DOWN) {
		ship.yspeed -= ship.speed;
		
	}
	if (e.getKeyCode() == KeyEvent.VK_UP) {
		ship.yspeed += ship.speed;
		
	}
}
public void updateMenuState(){
	
}
	
public void updateGameState(){
	manager.update();
	manager.manageEnemies();
	manager.checkCollision();
	if (!ship.isAlive) {
		currentState = END_STATE;
		manager.reset();
		ship = new Rocketship(250, 700, 50, 50, 5);
		manager.addObject(ship);
	}
}
public void updateEndState(){
	
}
public void drawMenuState(Graphics g){
	g.setColor(Color.BLUE);
	g.fillRect(0, 0, 500, 800);
	g.setColor(Color.MAGENTA);
	g.setFont(titleFont);
	g.drawString("League Invaders", 70, 400);
}
public void drawGameState(Graphics g){
	g.setColor(Color.BLACK);
	g.fillRect(0, 0, 500, 800);
	manager.draw(g);
	
}
public void drawEndState(Graphics g){
	g.setColor(Color.MAGENTA);
	g.setFont(titleFont);
	g.drawString("Game Over", 120, 400);
	g.drawString("You shot "+ manager.getScore() + " aliens", 50, 50);
}

}
