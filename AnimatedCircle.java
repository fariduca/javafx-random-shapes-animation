import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Parent;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.security.SecureRandom;

public class AnimatedCircle extends Circle implements AnimatedNode {
    public AnimatedCircle(double v, double v1, double v2) {
        super(v, v1, v2);
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
                        setCenterX(getCenterX() + dx);
                        setCenterY(getCenterY() + dy);
                        Bounds bounds = parent.getBoundsInLocal();

                        if ((getCenterX() <= (bounds.getMinX() + (getRadius()) )) ||
                                (getCenterX() >= (bounds.getMaxX() - (getRadius())))) {
                            dx *= -1;
                        }

                        if ((getCenterY() <= (bounds.getMinY() + (getRadius()))) ||
                                (getCenterY() >= (bounds.getMaxY() - (getRadius())))) {
                            dy *= -1;
                        }
                    }
                })
        );
        timelineAnimation.setCycleCount(Timeline.INDEFINITE);
        timelineAnimation.play();
    }
}
