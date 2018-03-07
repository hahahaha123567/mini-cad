package miniCAD;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class MyRectangle extends Rectangle implements MyShape {
    private double tempX;
    private double tempY;
    private double offsetX;
    private double offsetY;
    // I don't know how to implements Serializable elegantly
    private double x;
    private double y;
    private double width;
    private double height;
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
        super.setX(tempX < xx ? tempX : xx);
        super.setY(tempY < yy ? tempY : yy);
        super.setWidth(Math.abs(tempX - xx));
        super.setHeight(Math.abs(tempY - yy));
        super.setFill(null);
        super.setStroke(Color.BLACK);
        super.setStrokeWidth(3);
        update();
    }

    @Override
    public boolean isSelected(MouseEvent mouseEvent) {
        double x = mouseEvent.getX();
        double y = mouseEvent.getY();
        return getX() < x && x < getX() + getWidth() && getY() < y && y < getY() + getHeight();
    }

    @Override
    public void getLocation(MouseEvent mouseEvent) {
        offsetX = mouseEvent.getX() - getX();
        offsetY = mouseEvent.getY() - getY();
    }

    @Override
    public void setLocation(MouseEvent mouseEvent) {
        setX(mouseEvent.getX() - offsetX);
        setY(mouseEvent.getY() - offsetY);
        update();
    }

    @Override
    public void setBigger() {
        setX(getX() - 2);
        setY(getY() - 2);
        setWidth(getWidth() + 4);
        setHeight(getHeight() + 4);
        update();
    }

    @Override
    public void setSmaller() {
        if (getWidth() > 4 && getHeight() > 4) {
            setX(getX() + 2);
            setY(getY() + 2);
            setWidth(getWidth() - 4);
            setHeight(getHeight() - 4);
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
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
        setFill(null);
        setStroke(Color.color(colorRGB[0], colorRGB[1], colorRGB[2]));
        setStrokeWidth(strokeWidth);
    }

    private void update () {
        x = getX();
        y = getY();
        width = getWidth();
        height = getHeight();
        colorRGB[0] = ((Color)getStroke()).getRed();
        colorRGB[1] = ((Color)getStroke()).getGreen();
        colorRGB[2] = ((Color)getStroke()).getBlue();
        strokeWidth = getStrokeWidth();
    }
}
