package miniCAD;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class MyCircle extends Circle implements MyShape {
    private double tempX;
    private double tempY;
    private double offsetX;
    private double offsetY;
    // I don't know how to implements Serializable elegantly
    private double centerX;
    private double centerY;
    private double radius;
    private double[] colorRGB = new double[3];
    private double strokeWidth;

    @Override
    public void setFirstPoint(MouseEvent mouseEvent) {
        tempX = mouseEvent.getX();
        tempY = mouseEvent.getY();
    }

    @Override
    public void setSecondPoint(MouseEvent mouseEvent) {
        double xx = mouseEvent.getX();
        double yy = mouseEvent.getY();
        double deltaX = Math.abs(tempX - xx);
        double deltaY = Math.abs(tempY - yy);
        this.setCenterX( (tempX + xx) / 2 );
        this.setCenterY( (tempY + yy) / 2 );
        this.setRadius( (deltaX > deltaY ? deltaX : deltaY) / 2 );
        this.setFill(null);
        this.setStroke(Color.BLACK);
        this.setStrokeWidth(3);
        update();
    }

    @Override
    public boolean isSelected(MouseEvent mouseEvent) {
        double x = mouseEvent.getX();
        double y = mouseEvent.getY();
        return Math.pow((x - getCenterX()), 2) + Math.pow((y - getCenterY()), 2) < Math.pow(getRadius(), 2) ;
    }

    @Override
    public void getLocation(MouseEvent mouseEvent) {
        offsetX = mouseEvent.getX() - getCenterX();
        offsetY = mouseEvent.getY() - getCenterY();
    }

    @Override
    public void setLocation(MouseEvent mouseEvent) {
        setCenterX(mouseEvent.getX() - offsetX);
        setCenterY(mouseEvent.getY() - offsetY);
        update();
    }

    @Override
    public void setBigger() {
        setRadius(getRadius() + 2);
        update();
    }

    @Override
    public void setSmaller() {
        if (getRadius() > 2) {
            setRadius(getRadius() - 2);
            update();
        }
    }

    @Override
    public void setBold() {
        setStrokeWidth(getStrokeWidth() + 1);
        update();
    }

    @Override
    public void setLight() {
        if (getStrokeWidth() > 1) {
            setStrokeWidth(getStrokeWidth() - 1);
            update();
        }
    }

    @Override
    public void setColor(Color color) {
        setStroke(color);
        update();
    }

    @Override
    public void reShape() {
        setCenterX(centerX);
        setCenterY(centerY);
        setRadius(radius);
        setFill(null);
        setStroke(Color.color(colorRGB[0], colorRGB[1], colorRGB[2]));
        setStrokeWidth(strokeWidth);
    }

    private void update() {
        centerX = getCenterX();
        centerY = getCenterY();
        radius = getRadius();
        colorRGB[0] = ((Color)getStroke()).getRed();
        colorRGB[1] = ((Color)getStroke()).getGreen();
        colorRGB[2] = ((Color)getStroke()).getBlue();
        strokeWidth = getStrokeWidth();
    }
}
