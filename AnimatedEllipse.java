import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Parent;
import javafx.scene.shape.Ellipse;
import javafx.util.Duration;

import java.security.SecureRandom;

public class AnimatedEllipse extends Ellipse implements AnimatedNode {
    public AnimatedEllipse(double v, double v1, double v2, double v3) {
        super(v, v1, v2, v3);
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

                        if ((getCenterX() <= (bounds.getMinX() + (getRadiusX()*2) )) ||
                                (getCenterX() >= (bounds.getMaxX() - (getRadiusX()*2)))) {
                            dx *= -1;
                        }

                        if ((getCenterY() <= (bounds.getMinY() + (getRadiusY()*2))) ||
                                (getCenterY() >= (bounds.getMaxY() - (getRadiusY()*2)))) {
                            dy *= -1;
                        }
                    }
                })
        );
        timelineAnimation.setCycleCount(Timeline.INDEFINITE);
        timelineAnimation.play();
    }
}
