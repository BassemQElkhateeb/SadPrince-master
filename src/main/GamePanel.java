package main;

import Things.Super_Object;
import Tilez.TileManager;
import entity.Enemy;
import entity.Player;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GamePanel extends JPanel implements Runnable {
    final int oTileSize = 16; //16*16 original tile size
    final int scale = 3; //scale in which original tile size is enlarged by on monitor
    public final int tileSize = scale*oTileSize; //48*48
    final public int totalScreenCol = 16; //Number of columns displayed on screen
    final public int  totalScreenRow = 12; //Number of rows of displayed on screen
    final public int screenWidth = totalScreenCol*tileSize; //768 pixels
    final public int screenHeight = totalScreenRow*tileSize; // 576 pixels

    //Word
    final public int totalWorldCol =50;
    final public int totalWorldRow=50;

    final public int worldWidth = totalWorldCol*tileSize;
    final public int worldHeight = totalWorldRow*tileSize;

    Thread gameThread;
    KeyHandler keyHandler = new KeyHandler();
    TileManager tileManager =new TileManager(this);
    public CheckCollision checkCollision = new CheckCollision(this);
    public CheckLiquid checkLiquid = new CheckLiquid(this);
    public Player player = new Player(this,keyHandler);
    public Enemy enemy = new Enemy(this);

    public AssetSetter assetSetter = new AssetSetter(this);
    public Super_Object obj[] = new Super_Object[10];

    //Default player positions (testing)
    int playerX = 100;
    int playerY = 100;
    int playerSpeed =4;
    int FPS = 60;


    public GamePanel() throws IOException {
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.darkGray);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);


    }
    public void setGame() throws IOException {
        assetSetter.setAsset();
    }
    //Connects thread to its task (gamePanel)
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();

    }

    @Override
    //Game cycle
    public void run() {
        double drawInterval = (double) 1000000000 /FPS;
        double nextDraw = System.nanoTime() +drawInterval;

        while (gameThread!= null){
            update();
            repaint();



            try {
                double remainingTime = nextDraw - System.nanoTime();
                remainingTime = remainingTime/1000000;

                if (remainingTime <0){
                    remainingTime = 0;
                }
                Thread.sleep((long) remainingTime);
                nextDraw += drawInterval;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void update(){
        player.update();
        enemy.update();
    }


    public void paintComponent(Graphics g){
        Toolkit.getDefaultToolkit().sync();
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        tileManager.draw(g2);
        player.draw(g2);
        enemy.draw(g2);
        g2.dispose();
        }

    }

