package main;
import Things.Ob_Key;

import java.io.IOException;

public class AssetSetter {
    GamePanel gamePanel;

    public AssetSetter(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }
    public void setAsset() throws IOException {
        gamePanel.obj[0] = new Ob_Key();
        gamePanel.obj[0].worldX = 5 * gamePanel.tileSize;
        gamePanel.obj[0].worldY = 2*gamePanel.tileSize;

    }
}
