package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity{
    GamePanel gamePanel;
    KeyHandler keyHandler;

    public final int screenX;
    public final int screenY;

     public int size;


    String state;



    public Player(GamePanel gamePanel,KeyHandler keyHandler){
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;
        screenY = gamePanel.screenHeight /2 + (gamePanel.tileSize/2);
        screenX = gamePanel.screenWidth/2 + (gamePanel.tileSize);
        charBoundaries = new Rectangle(8,16,24,24);
        setDefault();
        getPlayerImage();



    }
    public void setDefault(){
         size= gamePanel.tileSize;
        worldX= gamePanel.tileSize*23;
        worldY = gamePanel.tileSize*21;
        speed = 4;
        direction = "down";
    }
    public void getPlayerImage(){
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/pu1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/pu2.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/player/pu3.png"));
            up4 = ImageIO.read(getClass().getResourceAsStream("/player/pu4.png"));
            up5 = ImageIO.read(getClass().getResourceAsStream("/player/pu5.png"));
            up6 = ImageIO.read(getClass().getResourceAsStream("/player/pu6.png"));

            down1 = ImageIO.read(getClass().getResource("/player/pd1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/pd2.png"));
            down3 = ImageIO.read(getClass().getResource("/player/pd3.png"));
            down4 = ImageIO.read(getClass().getResourceAsStream("/player/pd4.png"));
            down5 = ImageIO.read(getClass().getResource("/player/pd5.png"));
            down6 = ImageIO.read(getClass().getResourceAsStream("/player/pd6.png"));

            right1 = ImageIO.read(getClass().getResourceAsStream("/player/pr1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/pr2.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/player/pr3.png"));
            right4 = ImageIO.read(getClass().getResourceAsStream("/player/pr4.png"));
            right5 = ImageIO.read(getClass().getResourceAsStream("/player/pr5.png"));
            right6 = ImageIO.read(getClass().getResourceAsStream("/player/pr6.png"));

            left1 = ImageIO.read(getClass().getResourceAsStream("/player/pl1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/pl2.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/player/pl3.png"));
            left4 = ImageIO.read(getClass().getResourceAsStream("/player/pl4.png"));
            left5 = ImageIO.read(getClass().getResourceAsStream("/player/pl5.png"));
            left6 = ImageIO.read(getClass().getResourceAsStream("/player/pl6.png"));

        }
        catch (IOException e){
            e.printStackTrace();
        }

    }





    public void update(){
        if(keyHandler.upPress || keyHandler.downPress
                || keyHandler.rightPress || keyHandler.leftPress){
        if(keyHandler.upPress){
            direction ="up";}

        else if(keyHandler.downPress){
            direction ="down";}

        else if(keyHandler.rightPress){
            direction ="right";}

        else if(keyHandler.leftPress){
            direction ="left";}

        collisionOn = false;
        swimming = false;
        gamePanel.checkCollision.checkTile(this);
        gamePanel.checkLiquid.checkTile(this);

        if (collisionOn == false && swimming ==false){
            switch (direction){
                case "up":  worldY -= speed; break;
                case  "down": worldY += speed; break;
                case "right": worldX += speed; break;
                case "left": worldX -= speed; break;
            }

        }
        else if(swimming == true){
            switch (direction){
                case "up":  worldY -= speed/2; break;
                case  "down": worldY += speed/2; break;
                case "right": worldX += speed/2; break;
                case "left": worldX -= speed/2; break;
            }

        }


        spriteCounter++;
        if (spriteCounter>2){
            if (spriteNum==1 ||spriteNum==2||spriteNum==3||spriteNum==4||spriteNum==5){
                spriteNum++;
            }
            else if(spriteNum==6){
                spriteNum=1;
            }
            spriteCounter=0;
        }}


    }


    public void draw(Graphics2D g2){
       // g2.setBackground(Color.GRAY);
       // g2.fillRect(x,y,gamePanel.tileSize, gamePanel.tileSize)
        BufferedImage image = null;

        switch (direction){
            case "up":
                if (spriteNum==1){
                image=up1;}
                if (spriteNum==2){
                    image=up2;}
                if (spriteNum==3){
                    image=up3;}
                if (spriteNum==4){
                    image=up4;}
                if (spriteNum==5){
                    image=up5;}
                if (spriteNum==6){
                    image=up6;}

                break;
            case "down":
                if (spriteNum==2){
                    image=down2;}
                if (spriteNum==1){
                    image=down1;}
                if (spriteNum==3){
                    image=down3;}
                if (spriteNum==4){
                    image=down4;}
                if (spriteNum==5){
                    image=down5;}
                if (spriteNum==6){
                    image=down6;}
                break;
            case "right":

                if (spriteNum==2){
                    image=right2;}
                if (spriteNum==1){
                    image=right1;}
                if (spriteNum==3){
                    image=right3;}
                if (spriteNum==4){
                    image=right4;}
                if (spriteNum==5){
                    image=right5;}
                if (spriteNum==6){
                    image=right6;}

                break;
            case "left":

                if (spriteNum==1){
                    image=left1;}
                if (spriteNum==2){
                    image=left2;}
                if (spriteNum==3){
                    image=left3;}
                if (spriteNum==4){
                    image=left4;}
                if (spriteNum==5){
                    image=left5;}
                if (spriteNum==6){
                    image=left6;}

                break;
        }

        g2.drawImage(image,screenX,screenY,gamePanel.tileSize, gamePanel.tileSize,null);

        if (Objects.equals(state, "active")){
        }









    }




}
