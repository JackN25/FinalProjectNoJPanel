import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Apps{
    static final Apps[] apps = {new NotesApp()};
    private boolean appOpen;
    private BufferedImage icon;
    private String appName;
    private String filePath;
    public Apps(String fileName, String appName) {
        filePath = fileName;
        icon = readImage(fileName);
        this.appName = appName;
        appOpen = false;
    }

    private BufferedImage readImage(String fileName) {
        try {
            return ImageIO.read(new File(fileName));
        } catch (IOException e) {
            System.err.println("Failed to retrieve image for " + appName);
            try {
                return ImageIO.read(new File("images/placeholder.png"));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public String getFilePath() {
        return filePath;
    }
}
