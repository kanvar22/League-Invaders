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
final int MENU_STATE = 0;
final int GAME_STATE = 1;
final int END_STATE = 2;
int currentState = MENU_STATE;
public GamePanel(){
	timer = new Timer(1000/60, this);
	titleFont = new Font("Arial", Font.PLAIN, 48);
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
}
@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	System.out.println("Hey");
}
public void updateMenuState(){
	
}
	
public void updateGameState(){
	
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
}
public void drawEndState(Graphics g){
	g.setColor(Color.MAGENTA);
	g.setFont(titleFont);
	g.drawString("Game Over", 120, 400);
}

}
