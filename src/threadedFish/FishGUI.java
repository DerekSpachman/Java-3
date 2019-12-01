/*
 * 
 */
package threadedFish;

import java.util.Random;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;

public class FishGUI {
    private Paint fill;
    private Circle body;
    private Polygon tail;
    
    
    public FishGUI(double x, double y) {
        //body
        Random gen = new Random();
        fill = Color.rgb(gen.nextInt(256), gen.nextInt(256), gen.nextInt(256));
        body = new Circle(x, y, gen.nextInt(101)+50, fill);
        
        //tail
        tail = new Polygon();
        
        tail.getPoints().addAll(new Double[]{
            body.getCenterX()+body.getRadius()-10, body.getCenterY(),
            body.getCenterX()+body.getRadius()*2, body.getCenterY()-body.getRadius(),
            body.getCenterX()+body.getRadius()*2, body.getCenterY()+body.getRadius()
        });
        tail.setFill(fill);
    }
    
    
    public Circle getBody() { return body; }
    
    
    public Polygon getTail() { return tail; }
    
    
    public void moveUp() {
        body.setCenterY(body.getCenterY()-10);
        tail.getPoints().setAll(new Double[]{
            body.getCenterX()+body.getRadius()-10, body.getCenterY(),
            body.getCenterX()+body.getRadius()*2, body.getCenterY()-body.getRadius(),
            body.getCenterX()+body.getRadius()*2, body.getCenterY()+body.getRadius()
        });
    }
    
    
    public void moveDown() {
        body.setCenterY(body.getCenterY()+10);
        tail.getPoints().setAll(new Double[]{
            body.getCenterX()+body.getRadius()-10, body.getCenterY(),
            body.getCenterX()+body.getRadius()*2, body.getCenterY()-body.getRadius(),
            body.getCenterX()+body.getRadius()*2, body.getCenterY()+body.getRadius()
        });
    }
    
    
    public void moveLeft() {
        body.setCenterX(body.getCenterX()-10);
        tail.getPoints().setAll(new Double[]{
            body.getCenterX()+body.getRadius()-10, body.getCenterY(),
            body.getCenterX()+body.getRadius()*2, body.getCenterY()-body.getRadius(),
            body.getCenterX()+body.getRadius()*2, body.getCenterY()+body.getRadius()
        });
    }
    
    
    public void moveRight() {
        body.setCenterX(body.getCenterX()+10);
        tail.getPoints().setAll(new Double[]{
            body.getCenterX()+body.getRadius()-10, body.getCenterY(),
            body.getCenterX()+body.getRadius()*2, body.getCenterY()-body.getRadius(),
            body.getCenterX()+body.getRadius()*2, body.getCenterY()+body.getRadius()
        });
    }
}
