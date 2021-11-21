import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Timer;
import acm.graphics.GImage;
import acm.graphics.GRectangle;
import acm.graphics.GRect;

public class MainGame extends GraphicsPane implements KeyListener, ActionListener{
    
    private Timer timer;
    ArrayList <Enemy> enemies;
    ArrayList <Projectile> bullets;
    GImage background;
    KeyHandler keys;
    int enemyDx;
    GImage playerSprite;
    Player player;
    private MainApplication program; 
    boolean paused = false;
    private EnemyPack enemyLevelOne;
    private EnemyPack enemyLevelTwo;
    private EnemyPack enemyLevelThree;
    private EnemyPack enemyLevelFour;
	private int level;
    
    public MainGame(MainApplication app) {
        super();
        program = app;
        bullets = new ArrayList <Projectile>();
        //playerSprite = new GImage("/COMP55GroupProject/src/Bullets/Android Logo.png", 300, 300);
        player = new Player("test", program, this);
        background = new GImage("src/Images/bg.png", 0,0);
        
    }
    
    
    public void playGame() {
        //keys = new KeyHandler();
        //enemies = new ArrayList <Enemy>();
    	level = 1;
    	if(enemyLevelThree == null) {
    		level++;
    		//TODO:
    		//program.switchToTransition(level);
    	}
        enemyLevelThree = new EnemyPack(program, this, 3);
    }
    
    public void updatePlayer() {
    
        if(keys.keyDown(KeyEvent.VK_LEFT)) {
            playerSprite.move(0 - player.getVelocity(), 0);
        }
        else if(keys.keyDown(KeyEvent.VK_RIGHT)) {
            playerSprite.move(player.getVelocity(), 0);
        }
    }
    
    public boolean rectCollision(GRectangle gRectangle, GRectangle gRectangle2) {
    	double minX = gRectangle.getX();
    	double minY = gRectangle.getY();
    	double maxX = minX + gRectangle.getWidth();
    	double maxY = minY + gRectangle.getHeight();
    	
    	if(gRectangle2.getX() > maxX || minX > gRectangle2.getX() + gRectangle2.getWidth()) return false;
    	if(gRectangle2.getY() > maxY || minY > gRectangle2.getY() + gRectangle2.getHeight()) return false;
    	return true;
    }
    
    @Override
    public void showContents() {
        // TODO Auto-generated method stub
        program.add(background);
        player.show();
        timer = new Timer(10, this);
        timer.start();
    }

    @Override
    public void hideContents() {
        // TODO Auto-generated method stub
        program.remove(background);
        player.hide();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(paused) {
            return;
        }
        player.update();
        /*Iterator<Shots> iter = bullets.iterator();
        while(iter.hasNext()) {
        	Projectile temp = iter.next();
        	temp.update();
        	if(EnemyPack.checkCollision(temp.getImage().getBounds()))
        	if(rectCollision(temp.getImage().getBounds(),player.getBounds())) {
        		player.takedamage();
            	temp.hide();
            	iter.remove();
            }
        	else if(temp.getY() < 0 || temp.getY() > 600) {
        		
        	}
        }*/
    }

	@Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(!paused) {
            if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
                //player.move(-10,0);
                player.updateVelocity(-2, 0);
            }
            if(key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
                //player.move(10,0);
            	player.updateVelocity(2, 0);
            }
            if(key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
                player.updateVelocity(0,-2);
            }
            if(key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
                player.updateVelocity(0,2);
            }
            if(key == KeyEvent.VK_SPACE) {
                bullets.add(player.shoot(player.getPower()));
            }
        }
         if(key == KeyEvent.VK_ESCAPE) {
            if(paused) {
                paused = false;
            }
            else
                paused = true;
            	program.switchToSettings();
        }
    }


	public void changeLevel(int level) {
		// TODO Auto-generated method stub
		this.level = level;
	}
}