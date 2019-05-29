import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel {
    private final MainWindow mainWindow;
    private long lastFrameTime;

    public GameCanvas(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        lastFrameTime = System.nanoTime();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //
        long currentTime = System.nanoTime();
        float deltaTime = (currentTime - lastFrameTime) * 0.000000001f;
        mainWindow.onDrawFrame(this, g, deltaTime);
        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();
        lastFrameTime = currentTime;
    }

    int getLeft() {
        return 0;
    }

    int getTop() {
        return 0;
    }

    int getRight() {
        return getWidth() - 1;
    }

    int getBottom() {
        return getHeight() - 1;
    }
}
