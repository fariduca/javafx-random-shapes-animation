import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Parent;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.security.SecureRandom;


public class AnimatedRectangle extends Rectangle implements AnimatedNode {
    public AnimatedRectangle(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void animate(Parent parent) {
        SecureRandom random = new SecureRandom();
        Timeline timelineAnimation = new Timeline(
                new KeyFrame(Duration.millis(20), new EventHandler<ActionEvent>() {
                    int dx = 1 + random.nextInt(3);
                    int dy = 1 + random.nextInt(3);
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        setX(getX() + dx);
                        setY(getY() + dy);
                        Bounds bounds = parent.getBoundsInLocal();

                        if ((getX() <= (bounds.getMinX() + getWidth())) ||
                                (getX() >= (bounds.getMaxX() - getWidth()))) {
                            dx *= -1;
                        }

                        if ((getY() <= (bounds.getMinY() + getHeight())) ||
                                (getY() >= (bounds.getMaxY() - getHeight()))) {
                            dy *= -1;
                        }
                    }
                })
        );
        timelineAnimation.setCycleCount(Timeline.INDEFINITE);
        timelineAnimation.play();
    }
}
