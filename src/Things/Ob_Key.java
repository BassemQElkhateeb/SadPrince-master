package Things;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Ob_Key extends Super_Object {
    public Ob_Key() throws IOException {
        name = "key";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("objects/key.png"));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
