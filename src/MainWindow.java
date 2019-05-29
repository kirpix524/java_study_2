import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private static final int POS_X = 300;
    private static final int POS_Y = 100;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    private GameCanvas canvas;

    private Sprite[] sprites = new Sprite[10];

    public MainWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(POS_X, POS_Y);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
//        setResizable(false);
        setTitle("Circles");
        //
        canvas=new GameCanvas(this);
        add(canvas, BorderLayout.CENTER);
        //
        initGame();
        //
        setVisible(true);
    }

    private void initGame() {
        for (int i=0; i<sprites.length; i++) sprites[i] = new Ball();
    }
    void onDrawFrame(GameCanvas gameCanvas, Graphics g, float deltaTime) {
        update(gameCanvas, deltaTime);
        render(gameCanvas, g);
    }

    private void update(GameCanvas gameCanvas, float deltaTime) {
        for (int i=0; i<sprites.length; i++) sprites[i].update(gameCanvas, deltaTime);
    }

    private void render(GameCanvas gameCanvas,Graphics g) {
        for (int i=0; i<sprites.length; i++) {
            sprites[i].render(gameCanvas, g);
        }
    }
}
