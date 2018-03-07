package miniCAD;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Shape;

public class ToClickSecondPoint implements State {
    private Controller controller;

    ToClickSecondPoint(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void canvasClicked(MouseEvent mouseEvent) {
        MyShape myShape = controller.currentMyShape;
        myShape.setSecondPoint(mouseEvent);
        controller.myShapeList.add(myShape);
        controller.state = Controller.toSelect;
    }

    @Override
    public void canvasMoved(MouseEvent mouseEvent) {
        MyShape myShape = controller.currentMyShape;
        myShape.setSecondPoint(mouseEvent);
    }

    @Override
    public void canvasPressed(MouseEvent mouseEvent) {

    }

    @Override
    public void canvasDragged(MouseEvent mouseEvent) {

    }

    @Override
    public void buttonLineClicked(ActionEvent actionEvent) {

    }

    @Override
    public void buttonRectangleClicked(ActionEvent actionEvent) {

    }

    @Override
    public void buttonCircleClicked(ActionEvent actionEvent) {

    }

    @Override
    public void buttonTextClick(ActionEvent actionEvent) {

    }

    @Override
    public void itemOpenClicked(ActionEvent actionEvent) {

    }

    @Override
    public void itemSaveClicked(ActionEvent actionEvent) {

    }

    @Override
    public void buttonBiggerClicked(ActionEvent actionEvent) {

    }

    @Override
    public void buttonSmallerClicked(ActionEvent actionEvent) {

    }

    @Override
    public void buttonBoldClicked(ActionEvent actionEvent) {

    }

    @Override
    public void buttonLightClicked(ActionEvent actionEvent) {

    }

    @Override
    public void buttonNicoClicked(ActionEvent actionEvent) {

    }

    @Override
    public void buttonElieClicked(ActionEvent actionEvent) {

    }

    @Override
    public void buttonNozomiClicked(ActionEvent actionEvent) {

    }

    @Override
    public void buttonHonokaClicked(ActionEvent actionEvent) {

    }

    @Override
    public void buttonUmiClicked(ActionEvent actionEvent) {

    }

    @Override
    public void buttonKotoriClicked(ActionEvent actionEvent) {

    }

    @Override
    public void buttonMakiClicked(ActionEvent actionEvent) {

    }

    @Override
    public void buttonRinClicked(ActionEvent actionEvent) {

    }

    @Override
    public void buttonHanayoClicked(ActionEvent actionEvent) {

    }

    @Override
    public void colorPickerClicked(ActionEvent actionEvent) {

    }

    @Override
    public void buttonDeleteClicked(ActionEvent actionEvent) {

    }
}
