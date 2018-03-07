package miniCAD;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class MyLine extends Line implements MyShape {
    private double offsetX;
    private double offsetY;
    // I don't know how to implements Serializable elegantly
    private double startX;
    private double startY;
    private double endX;
    private double endY;
    private double[] colorRGB = new double[3];
    private double strokeWidth;

    @Override
    public void setFirstPoint(MouseEvent mouseEvent) {
        super.setStartX(mouseEvent.getX());
        super.setStartY(mouseEvent.getY());
        super.setEndX(mouseEvent.getX());
        super.setEndY(mouseEvent.getY());
    }

    @Override
    public void setSecondPoint(MouseEvent mouseEvent) {
        super.setEndX(mouseEvent.getX());
        super.setEndY(mouseEvent.getY());
        update();
    }

    @Override
    public boolean isSelected(MouseEvent mouseEvent) {
        double x1 = this.getStartX();
        double y1 = this.getStartY();
        double x2 = this.getEndX();
        double y2 = this.getEndY();
        double x3 = mouseEvent.getX();
        double y3 = mouseEvent.getY();
        double xNormal = y2 - y1;
        double yNormal = x1 - x2;
        double xVector = x3 - x1;
        double yVector = y3 - y1;
        double distance = Math.abs(xNormal * xVector + yNormal * yVector) / Math.sqrt(xNormal * xNormal + yNormal * yNormal);
        return distance < 5;
    }

    @Override
    public void getLocation(MouseEvent mouseEvent) {
        offsetX = mouseEvent.getX() - getStartX();
        offsetY = mouseEvent.getY() - getStartY();
    }

    @Override
    public void setLocation(MouseEvent mouseEvent) {
        double width = getEndX() - getStartX();
        double height = getEndY() - getStartY();
        setStartX(mouseEvent.getX() - offsetX);
        setStartY(mouseEvent.getY() - offsetY);
        setEndX(getStartX() + width);
        setEndY(getStartY() + height);
        update();
    }

    @Override
    public void setBigger() {
        setStartX(getStartX() - 2);
        setStartY(getStartY() - 2);
        setEndX(getEndX() + 2);
        setEndY(getEndY() + 2);
        update();
    }

    @Override
    public void setSmaller() {
        setStartX(getStartX() + 2);
        setStartY(getStartY() + 2);
        setEndX(getEndX() - 2);
        setEndY(getEndY() - 2);
        update();
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
        setStartX(startX);
        setStartY(startY);
        setEndX(endX);
        setEndY(endY);
        setStroke(Color.color(colorRGB[0], colorRGB[1], colorRGB[2]));
        setStrokeWidth(strokeWidth);
    }

    private void update() {
        // store info
        startX = getStartX();
        startY = getStartY();
        endX = getEndX();
        endY = getEndY();
        colorRGB[0] = ((Color)getStroke()).getRed();
        colorRGB[1] = ((Color)getStroke()).getGreen();
        colorRGB[2] = ((Color)getStroke()).getBlue();
        strokeWidth = getStrokeWidth();
    }
}
