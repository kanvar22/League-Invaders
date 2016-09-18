import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame;
final int width = 500;
final int height = 800;
GamePanel Game;
public LeagueInvaders(){
	frame = new JFrame();
Game = new GamePanel();
	setup();
}
public static void main(String[] args) {
	LeagueInvaders invaders = new LeagueInvaders();
}
public void setup(){
	frame.add(Game);
	Game.startGame();
	frame.addKeyListener(Game);
	frame.setSize(width, height);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

}
}
