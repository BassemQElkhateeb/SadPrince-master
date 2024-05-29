package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Enemy extends  Entity {
    GamePanel gamePanel;
    int size;
    int counter = 0;
    int steps = 4;
    int ScreenX;
    int ScreenY;
    String state;
    public Enemy(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        charBoundaries = new Rectangle(8,16,24,24);
        setDefault();
        getEnemyImage();
    }

    private void setDefault() {
        size= gamePanel.tileSize;
        worldX= gamePanel.tileSize*21;
        worldY = gamePanel.tileSize*21;
        speed = 3;
        direction = "down";
    }

    private void getEnemyImage(){
        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/enemy/Sprite-0001.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/enemy/Sprite-0001.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/enemy/Sprite-0001.png"));
            up4 = ImageIO.read(getClass().getResourceAsStream("/enemy/Sprite-0001.png"));
            up5 = ImageIO.read(getClass().getResourceAsStream("/enemy/Sprite-0001.png"));
            up6 = ImageIO.read(getClass().getResourceAsStream("/enemy/Sprite-0001.png"));

            down1 = ImageIO.read(getClass().getResource("/enemy/Sprite-0001.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/enemy/Sprite-0001.png"));
            down3 = ImageIO.read(getClass().getResource("/enemy/Sprite-0001.png"));
            down4 = ImageIO.read(getClass().getResourceAsStream("/enemy/Sprite-0001.png"));
            down5 = ImageIO.read(getClass().getResource("/enemy/Sprite-0001.png"));
            down6 = ImageIO.read(getClass().getResourceAsStream("/enemy/Sprite-0001.png"));

            right1 = ImageIO.read(getClass().getResourceAsStream("/enemy/Sprite-0001.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/enemy/Sprite-0001.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/enemy/Sprite-0001.png"));
            right4 = ImageIO.read(getClass().getResourceAsStream("/enemy/Sprite-0001.png"));
            right5 = ImageIO.read(getClass().getResourceAsStream("/enemy/Sprite-0001.png"));
            right6 = ImageIO.read(getClass().getResourceAsStream("/enemy/Sprite-0001.png"));

            left1 = ImageIO.read(getClass().getResourceAsStream("/enemy/Sprite-0001.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/enemy/Sprite-0001.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/enemy/Sprite-0001.png"));
            left4 = ImageIO.read(getClass().getResourceAsStream("/enemy/Sprite-0001.png"));
            left5 = ImageIO.read(getClass().getResourceAsStream("/enemy/Sprite-0001.png"));
            left6 = ImageIO.read(getClass().getResourceAsStream("/enemy/Sprite-0001.png"));


        }
        catch (IOException e){
            e.printStackTrace();

        }
    }

    public void update(){

            while (counter < steps ){
                counter++;}

            if (counter == steps){

                switch (direction){
                    case "up":  direction = "left"  ; break;
                    case  "down": direction = "right"; break;
                    case "right": direction = "up"; break;
                    case "left": direction = "down"; break;
                }
                counter = 0;

            }
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

        g2.drawImage(image,worldX,worldY,gamePanel.tileSize, gamePanel.tileSize,null);

        if (Objects.equals(state, "active")){
        }









    }


    }

