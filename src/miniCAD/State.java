package miniCAD;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;

interface State {
    void canvasClicked(MouseEvent mouseEvent);

    void canvasMoved(MouseEvent mouseEvent);

    void canvasPressed(MouseEvent mouseEvent);

    void canvasDragged(MouseEvent mouseEvent);

    void buttonLineClicked(ActionEvent actionEvent);

    void buttonRectangleClicked(ActionEvent actionEvent);

    void buttonCircleClicked(ActionEvent actionEvent);

    void buttonTextClick(ActionEvent actionEvent);

    void itemOpenClicked(ActionEvent actionEvent);

    void itemSaveClicked(ActionEvent actionEvent);

    void buttonBiggerClicked(ActionEvent actionEvent);

    void buttonSmallerClicked(ActionEvent actionEvent);

    void buttonBoldClicked(ActionEvent actionEvent);

    void buttonLightClicked(ActionEvent actionEvent);

    void buttonNicoClicked(ActionEvent actionEvent);

    void buttonElieClicked(ActionEvent actionEvent);

    void buttonNozomiClicked(ActionEvent actionEvent);

    void buttonHonokaClicked(ActionEvent actionEvent);

    void buttonUmiClicked(ActionEvent actionEvent);

    void buttonKotoriClicked(ActionEvent actionEvent);

    void buttonMakiClicked(ActionEvent actionEvent);

    void buttonRinClicked(ActionEvent actionEvent);

    void buttonHanayoClicked(ActionEvent actionEvent);

    void colorPickerClicked(ActionEvent actionEvent);

    void buttonDeleteClicked(ActionEvent actionEvent);
}
