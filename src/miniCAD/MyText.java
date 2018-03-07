package miniCAD;

import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.ObjectInput;
import java.io.ObjectOutput;

public class MyText extends Text implements MyShape {
    private double tempX;
    private double tempY;
    private double offsetX;
    private double offsetY;
    // I don't know how to implements Serializable elegantly
    private double x;
    private double y;
    private double fontSize;
    private double[] colorRGB = new double[3];
    private String str;

    MyText() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Input Text");
        dialog.setHeaderText("Please input the text:");
        dialog.showAndWait();
        String info = dialog.getEditor().getText();
        this.setText(info);
    }

    @Override
    public void setFirstPoint(MouseEvent mouseEvent) {
        tempX = mouseEvent.getX();
        tempY = mouseEvent.getY();
        setFont(new Font(1));
    }

    @Override
    public void setSecondPoint(MouseEvent mouseEvent) {
        double xx = mouseEvent.getX();
        double yy = mouseEvent.getY();
        this.setX(tempX < xx ? tempX : xx);
        this.setY(tempY > yy ? tempY : yy);
        this.setFont(new Font(Math.abs(tempY - yy)));
        update();
    }

    @Override
    public boolean isSelected(MouseEvent mouseEvent) {
        double x = mouseEvent.getX();
        double y = mouseEvent.getY();
        double size = getFont().getSize();
        // it is not accurate but I have no idea to get length of the text
        return getX() < x && x < getX() + getText().length() * size && getY() - size < y && y < getY();
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
        setX(getX() - 1);
        setY(getY() + 1);
        setFont(new Font(getFont().getSize() + 2));
        update();
    }

    @Override
    public void setSmaller() {
        if (getFont().getSize() > 1) {
            setX(getX() + 1);
            setY(getY() - 1);
            setFont(new Font(getFont().getSize() - 2));
            update();
        }
    }

    @Override
    public void setBold() {

    }

    @Override
    public void setLight() {

    }

    @Override
    public void setColor(Color color) {
        setFill(color);
        update();
    }

    @Override
    public void reShape() {
        setX(x);
        setY(y);
        setFont(new Font(fontSize));
        setFill(Color.color(colorRGB[0], colorRGB[1], colorRGB[2]));
        setText(str);
    }

    private void update () {
        x = getX();
        y = getY();
        fontSize = getFont().getSize();
        if (getFill() != null) {
            colorRGB[0] = ((Color) getFill()).getRed();
            colorRGB[1] = ((Color) getFill()).getGreen();
            colorRGB[2] = ((Color) getFill()).getBlue();
        }
        str = getText();
    }
}
