import java.awt.*;

public class Ball extends Sprite {
    private float vx = 150 + (float) (Math.random() * 200f);
    private float vy = 150 + (float) (Math.random() * 200f);
    private final Color color = new Color((int) (Math.random() * 255f), (int) (Math.random() * 255f), (int) (Math.random() * 255f));
//    private final Color color = new Color((int) (255f), (int) (255f), (int) (Math.random() * 255f));

    Ball() {
        halfHeight = 20f + (float) (Math.random() * 50f);
        halfWidth = halfHeight;
    }

    @Override
    void update(GameCanvas gameCanvas, float deltaTime) {
//        super.update(gameCanvas, deltaTime);
        x += vx * deltaTime;
        y += vy * deltaTime;

        if (getBottom() > gameCanvas.getBottom()) {
            setBottom(gameCanvas.getBottom());
            vy = -vy;
        }

        if (getTop() < gameCanvas.getTop()) {
            setTop(gameCanvas.getTop());
            vy = -vy;
        }

        if (getLeft() < gameCanvas.getLeft()) {
            setLeft(gameCanvas.getLeft());
            vx = -vx;
        }

        if (getRight() > gameCanvas.getRight()) {
            setRight(gameCanvas.getRight());
            vx = -vx;
        }
    }

    @Override
    void render(GameCanvas gameCanvas, Graphics g) {
//        super.render(gameCanvas, g);
        g.setColor(color);
        g.fillOval((int) getLeft(), (int) getTop(), (int) getWidth(), (int) getHeight());
    }
}
