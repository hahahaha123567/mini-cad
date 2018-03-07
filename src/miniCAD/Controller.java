package miniCAD;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    @FXML
    VBox body;
    @FXML
    ColorPicker colorPicker;
    @FXML
    BorderPane canvas;
    private State stateArray[] = {
            new ToSelect(this),
            new ToClickFirstPoint(this),
            new ToClickSecondPoint(this)
    };
    static final int toSelect = 0;
    static final int toSetFirstPoint = 1;
    static final int getToSetSecondPoint = 2;
    int state = toSelect;

    List<MyShape> myShapeList = new ArrayList<>();
    MyShape currentMyShape;

    public void canvasDragged(MouseEvent mouseEvent) {
        stateArray[state].canvasDragged(mouseEvent);
    }

    public void canvasPressed(MouseEvent mouseEvent) {
        stateArray[state].canvasPressed(mouseEvent);
    }

    public void canvasClicked(MouseEvent mouseEvent) {
        stateArray[state].canvasClicked(mouseEvent);
    }

    public void canvasMoved(MouseEvent mouseEvent) {
        stateArray[state].canvasMoved(mouseEvent);
    }

    public void buttonLineClicked(ActionEvent actionEvent) {
        stateArray[state].buttonLineClicked(actionEvent);
    }

    public void buttonRectangleClicked(ActionEvent actionEvent) {
        stateArray[state].buttonRectangleClicked(actionEvent);
    }

    public void buttonCircleClicked(ActionEvent actionEvent) {
        stateArray[state].buttonCircleClicked(actionEvent);
    }

    public void buttonTextClick(ActionEvent actionEvent) {
        stateArray[state].buttonTextClick(actionEvent);
    }

    public void itemOpenClicked(ActionEvent actionEvent) {
        stateArray[state].itemOpenClicked(actionEvent);
    }

    public void itemSaveClicked(ActionEvent actionEvent) {
        stateArray[state].itemSaveClicked(actionEvent);
    }

    public void buttonBiggerClicked(ActionEvent actionEvent) {
        stateArray[state].buttonBiggerClicked(actionEvent);
    }

    public void buttonSmallerClicked(ActionEvent actionEvent) {
        stateArray[state].buttonSmallerClicked(actionEvent);
    }

    public void buttonBoldClicked(ActionEvent actionEvent) {
        stateArray[state].buttonBoldClicked(actionEvent);
    }

    public void buttonLightClicked(ActionEvent actionEvent) {
        stateArray[state].buttonLightClicked(actionEvent);
    }

    public void buttonNicoClicked(ActionEvent actionEvent) {
        stateArray[state].buttonNicoClicked(actionEvent);
    }

    public void buttonElieClicked(ActionEvent actionEvent) {
        stateArray[state].buttonElieClicked(actionEvent);
    }

    public void buttonNozomiClicked(ActionEvent actionEvent) {
        stateArray[state].buttonNozomiClicked(actionEvent);
    }

    public void buttonHonokaClicked(ActionEvent actionEvent) {
        stateArray[state].buttonHonokaClicked(actionEvent);
    }

    public void buttonUmiClicked(ActionEvent actionEvent) {
        stateArray[state].buttonUmiClicked(actionEvent);
    }

    public void buttonKotoriClicked(ActionEvent actionEvent) {
        stateArray[state].buttonKotoriClicked(actionEvent);
    }

    public void buttonMakiClicked(ActionEvent actionEvent) {
        stateArray[state].buttonMakiClicked(actionEvent);
    }

    public void buttonRinClicked(ActionEvent actionEvent) {
        stateArray[state].buttonRinClicked(actionEvent);
    }

    public void buttonHanayoClicked(ActionEvent actionEvent) {
        stateArray[state].buttonHanayoClicked(actionEvent);
    }

    public void buttonDeleteClicked(ActionEvent actionEvent) {
        stateArray[state].buttonDeleteClicked(actionEvent);
    }

    public void colorPickerClicked(ActionEvent actionEvent) {
        stateArray[state].colorPickerClicked(actionEvent);
    }

//    private void writeObject (ObjectOutputStream s) throws IOException {
//        s.defaultWriteObject();
//    }
//
//    private void readObject (ObjectInputStream s) throws IOException, ClassNotFoundException {
//        s.defaultReadObject();
//    }
}
