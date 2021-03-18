// TimelineAnimationController.java
// Bounce a circle around a window using a Timeline animation. 
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.util.Duration;

public class TimelineAnimationController {
   //@FXML Circle c;
   @FXML Pane pane;

    List<Shape> shapes =  new ArrayList<>();
   
   public void initialize() {
       SecureRandom random = new SecureRandom();

       Bounds bounds = pane.getBoundsInLocal();
           
      // define a timeline animation
      Timeline timelineAnimation = new Timeline(
         new KeyFrame(Duration.millis(1000),
            new EventHandler<ActionEvent>() {
               // move the circle by the dx and dy amounts
               @Override
               public void handle(final ActionEvent e) {
                   int dShape = random.nextInt(3);
                   //int dShape = 0;
                   int dWidth = random.nextInt(40);
                   int dHeight = random.nextInt(40);

                   int posX = dWidth + random.nextInt( (int) pane.getPrefWidth() - (dWidth*2));
                   int posY = dHeight + random.nextInt((int) pane.getPrefHeight() - (dHeight*2));
                   switch (dShape) {
                       case 0:
                           AnimatedCircle c = new AnimatedCircle(posX, posY, Math.min(dWidth, dHeight));
                           c.setFill(new Color(random.nextDouble(), random.nextDouble(), random.nextDouble(), random.nextDouble()));
                           c.setStrokeWidth(random.nextDouble());
                           pane.getChildren().add(c);
                           c.animate(pane);
                           break;
                       case 1:
                           AnimatedEllipse el = new AnimatedEllipse(posX, posY, dWidth/2.0, dHeight/2.0);
                           el.setFill(new Color(random.nextDouble(), random.nextDouble(), random.nextDouble(), random.nextDouble()));
                           el.setStrokeWidth(random.nextDouble());
                           pane.getChildren().add(el);
                           el.animate(pane);
                           break;
                       case 2:
                           AnimatedRectangle rec = new AnimatedRectangle(posX, posY, dWidth, dHeight);
                           rec.setFill(new Color(random.nextDouble(), random.nextDouble(), random.nextDouble(), random.nextDouble()));
                           rec.setStrokeWidth(random.nextDouble());
                           pane.getChildren().add(rec);
                           rec.animate(pane);
                           break;
                   }
               }
            }
         )
      );

      // indicate that the timeline animation should run indefinitely
      timelineAnimation.setCycleCount(Timeline.INDEFINITE);
      timelineAnimation.play();
   }

}

/**************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
