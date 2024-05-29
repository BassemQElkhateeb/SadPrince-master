package main;

import entity.Entity;

public class CheckCollision {
    GamePanel gamePanel;
    public CheckCollision(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }
    public void checkTile(Entity entity) {

        int boundaryLeftX = entity.worldX +entity.charBoundaries.x;
        int boundaryRightX= entity.worldX + entity.charBoundaries.x + entity.charBoundaries.width;
        int boundaryHighY= entity.worldY + entity.charBoundaries.y;
        int boundaryLowY = entity.worldY + entity.charBoundaries.y + entity.charBoundaries.height;

        int upperRow = boundaryHighY/gamePanel.tileSize;
        int lowerRow = boundaryLowY/gamePanel.tileSize;
        int leftCol = boundaryLeftX/gamePanel.tileSize;
        int rightCol= boundaryRightX/gamePanel.tileSize;
        int tileNum1;
        int tileNum2 ;


        switch (entity.direction) {
            case "up" -> {
                upperRow = (boundaryHighY - entity.speed) / gamePanel.tileSize;
                tileNum1 = gamePanel.tileManager.mapTiler[leftCol][upperRow];
                tileNum2 = gamePanel.tileManager.mapTiler[rightCol][upperRow];
                if (gamePanel.tileManager.tiles[tileNum1].collision == true ||
                        gamePanel.tileManager.tiles[tileNum2].collision == true) {
                    entity.collisionOn = true;

                }
            }
            case "down" -> {
                lowerRow = (boundaryLowY + entity.speed) / gamePanel.tileSize;
                tileNum1 = gamePanel.tileManager.mapTiler[leftCol][lowerRow];
                tileNum2 = gamePanel.tileManager.mapTiler[rightCol][lowerRow];
                if (gamePanel.tileManager.tiles[tileNum1].collision == true ||
                        gamePanel.tileManager.tiles[tileNum2].collision == true) {
                    entity.collisionOn = true;

                }
            }
            case "left" -> {
                leftCol = (boundaryLeftX - entity.speed) / gamePanel.tileSize;
                tileNum1 = gamePanel.tileManager.mapTiler[leftCol][lowerRow];
                tileNum2 = gamePanel.tileManager.mapTiler[leftCol][upperRow];
                if (gamePanel.tileManager.tiles[tileNum1].collision == true ||
                        gamePanel.tileManager.tiles[tileNum2].collision == true) {
                    entity.collisionOn = true;

                }
            }
            case "right" -> {
                rightCol = (boundaryRightX + entity.speed) / gamePanel.tileSize;
                tileNum1 = gamePanel.tileManager.mapTiler[rightCol][lowerRow];
                tileNum2 = gamePanel.tileManager.mapTiler[rightCol][upperRow];
                if (gamePanel.tileManager.tiles[tileNum1].collision == true ||
                        gamePanel.tileManager.tiles[tileNum2].collision == true) {
                    entity.collisionOn = true;

                }
            }
        }

    }}
