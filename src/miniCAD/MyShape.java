package miniCAD;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.io.Externalizable;
import java.io.Serializable;

public interface MyShape extends Serializable {
    void setFirstPoint (MouseEvent mouseEvent);
    void setSecondPoint (MouseEvent mouseEvent);
    boolean isSelected (MouseEvent mouseEvent);
    void getLocation (MouseEvent mouseEvent);
    void setLocation (MouseEvent mouseEvent);
    void setBigger ();
    void setSmaller ();
    void setBold ();
    void setLight ();
    void setColor (Color color);
    void reShape ();
}
