package Tilez;

import entity.Player;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class TileManager {
    GamePanel gamePanel;
    public Tile[] tiles;

    public int[][] mapTiler;


    public TileManager(GamePanel gamePanel) throws IOException {
        this.gamePanel = gamePanel;
        tiles= new Tile[20];
        setTiles();
        mapTiler = new int[gamePanel.totalWorldCol][gamePanel.totalWorldRow];
        exportMap();

    }

    public void setTiles() throws IOException {
        try{
            //Wall tiles
            tiles[0] = new Tile();
            tiles[0].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tile/wall.png")));
            //Water tiles
            tiles[1] = new Tile();
            tiles[1].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tile/water.png")));
            tiles[1].liquid = true;
            //Grass Tiles
            tiles[2] = new Tile();
            tiles[2].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tile/grass1.png")));
            //Tree Tiles
            tiles[3] = new Tile();
            tiles[3].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tile/tree4.png")));
            //Palace theme
            tiles[4] = new Tile();
            tiles[4].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tile/palaceMat.png")));
            //Palace theme
            tiles[5] = new Tile();
            tiles[5].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tile/palaceMatref.png")));

            //right part of the throne
            tiles[7] = new Tile();
            tiles[7].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tile/throne1R.png")));

            //Inverted Walls
            tiles[8] = new Tile();
            tiles[8].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tile/walreal.png")));
            tiles[8].collision = true;







        }
        catch (IOException e){
            System.out.println("Image not Found");
        }
    }
    public void exportMap() throws IOException {


        try {
            InputStream is = getClass().getResourceAsStream("/maps/map1.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));


            int col = 0;
            int row = 0;

            while (col < gamePanel.totalWorldCol && row < gamePanel.totalWorldRow) {
                String line = bufferedReader.readLine();

                while (col < gamePanel.totalWorldCol) {
                    String[] nStrings = line.split(" ");
                    int v = Integer.parseInt(nStrings[col]);
                    mapTiler[col][row] = v;
                    col++;

                }
                if (col == gamePanel.totalWorldCol) {
                    col = 0;
                    row++;
                }
            }
            bufferedReader.close();
        }
        catch (Exception e){
            e.printStackTrace();


        }
    }
    public void draw(Graphics2D g2){
        int wCol =0;
        int wRow = 0;
        //Covering the Entire Map
        while (wCol < gamePanel.totalWorldCol  && wRow < gamePanel.totalWorldRow ) {
            //tileNumber being the number assigned per the map.txt to this specific tile;
            int tileNUm = mapTiler[wCol][wRow];
            //Translating Columns and Rows into actual world pieces, this step could be skipped simply.
            int worldX = wCol*gamePanel.tileSize;
            int worldY =  wRow*gamePanel.tileSize;
            // The Screen Drawn is the screen dimension that we set earlier, because we're only drawing what we see
            // on the screen in drawImage, we can determine what that the moving screen would be
            int screenX = worldX - gamePanel.player.worldX + gamePanel.player.screenX;
            int screenY = worldY - gamePanel.player.worldY + gamePanel.player.screenY;

            if (worldX < gamePanel.player.worldX + gamePanel.player.screenX &&
                    worldX > gamePanel.player.worldX - gamePanel.player.screenX -gamePanel.tileSize &&
                    worldY < gamePanel.player.worldY + gamePanel.player.screenY &&
                    worldY > gamePanel.player.worldY - gamePanel.player.screenY -gamePanel.tileSize )

            g2.drawImage(tiles[tileNUm].image, screenX,  screenY, gamePanel.tileSize, gamePanel.tileSize, null);
            wCol++;

            if (wCol== gamePanel.totalWorldCol){
                wCol=0;
                wRow++;

            }

            }
        }
    }

