package miniCAD;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ToSelect implements State {
    private Controller controller;

    ToSelect (Controller controller) {
        this.controller = controller;
    }

    private MyShape getSelectedMyShape (MouseEvent mouseEvent) {
        for (MyShape myShape : controller.myShapeList) {
            if (myShape.isSelected(mouseEvent)) {
                return myShape;
            }
        }
        return null;
    }

    @Override
    public void canvasClicked(MouseEvent mouseEvent) {
       controller.currentMyShape = getSelectedMyShape(mouseEvent);
    }

    @Override
    public void canvasMoved(MouseEvent mouseEvent) {

    }

    @Override
    public void canvasPressed(MouseEvent mouseEvent) {
        canvasClicked(mouseEvent);
        if (controller.currentMyShape != null) {
            controller.currentMyShape.getLocation(mouseEvent);
        }
    }

    @Override
    public void canvasDragged(MouseEvent mouseEvent) {
        if (controller.currentMyShape != null) {
            controller.currentMyShape.setLocation(mouseEvent);
        }
    }

    @Override
    public void buttonLineClicked(ActionEvent actionEvent) {
        controller.currentMyShape = new MyLine();
        controller.state = Controller.toSetFirstPoint;
    }

    @Override
    public void buttonRectangleClicked(ActionEvent actionEvent) {
        controller.currentMyShape = new MyRectangle();
        controller.state = Controller.toSetFirstPoint;
    }

    @Override
    public void buttonCircleClicked(ActionEvent actionEvent) {
        controller.currentMyShape = new MyCircle();
        controller.state = Controller.toSetFirstPoint;
    }

    @Override
    public void buttonTextClick(ActionEvent actionEvent) {
        controller.currentMyShape = new MyText();
        controller.state = Controller.toSetFirstPoint;
    }

    @Override
    public void itemOpenClicked(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open CAD file");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CAD File", "*.cad"));
        File file = fileChooser.showOpenDialog(controller.body.getScene().getWindow());
        if (file != null) {
            FileInputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                controller.canvas.getChildren().removeAll(controller.canvas.getChildren());
                controller.myShapeList = (ArrayList<MyShape>) objectInputStream.readObject();
                for (MyShape myShape : controller.myShapeList) {
                    myShape.reShape();
                    controller.canvas.getChildren().add((Node)myShape);
                }
                objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                //
            }
        }
    }

    @Override
    public void itemSaveClicked(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save CAD file");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CAD File", "*.cad"));
        File file = fileChooser.showSaveDialog(controller.body.getScene().getWindow());
        if (file != null) {
            FileOutputStream fileOutputStream;
            try {
                fileOutputStream = new FileOutputStream(file);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(controller.myShapeList);
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void buttonBiggerClicked(ActionEvent actionEvent) {
        if (controller.currentMyShape != null) {
            controller.currentMyShape.setBigger();
        }
    }

    @Override
    public void buttonSmallerClicked(ActionEvent actionEvent) {
        if (controller.currentMyShape != null) {
            controller.currentMyShape.setSmaller();
        }
    }

    @Override
    public void buttonBoldClicked(ActionEvent actionEvent) {
        if (controller.currentMyShape != null) {
            controller.currentMyShape.setBold();
        }
    }

    @Override
    public void buttonLightClicked(ActionEvent actionEvent) {
        if (controller.currentMyShape != null) {
            controller.currentMyShape.setLight();
        }
    }

    @Override
    public void buttonNicoClicked(ActionEvent actionEvent) {
        if (controller.currentMyShape != null) {
            controller.currentMyShape.setColor(Color.web("0xffc0cb"));
        }
    }

    @Override
    public void buttonElieClicked(ActionEvent actionEvent) {
        if (controller.currentMyShape != null) {
            controller.currentMyShape.setColor(Color.web("0x00ffff"));
        }
    }

    @Override
    public void buttonNozomiClicked(ActionEvent actionEvent) {
        if (controller.currentMyShape != null) {
            controller.currentMyShape.setColor(Color.web("0x800080"));
        }
    }

    @Override
    public void buttonHonokaClicked(ActionEvent actionEvent) {
        if (controller.currentMyShape != null) {
            controller.currentMyShape.setColor(Color.web("0xffb11b"));
        }
    }

    @Override
    public void buttonUmiClicked(ActionEvent actionEvent) {
        if (controller.currentMyShape != null) {
            controller.currentMyShape.setColor(Color.web("0x0000ff"));
        }
    }

    @Override
    public void buttonKotoriClicked(ActionEvent actionEvent) {
        if (controller.currentMyShape != null) {
            controller.currentMyShape.setColor(Color.web("0xffffff"));
        }
    }

    @Override
    public void buttonMakiClicked(ActionEvent actionEvent) {
        if (controller.currentMyShape != null) {
            controller.currentMyShape.setColor(Color.web("0xff0000"));
        }
    }

    @Override
    public void buttonRinClicked(ActionEvent actionEvent) {
        if (controller.currentMyShape != null) {
            controller.currentMyShape.setColor(Color.web("0xffff00"));
        }
    }

    @Override
    public void buttonHanayoClicked(ActionEvent actionEvent) {
        if (controller.currentMyShape != null) {
            controller.currentMyShape.setColor(Color.web("0xadff2f"));
        }
    }

    @Override
    public void colorPickerClicked(ActionEvent actionEvent) {
        if (controller.currentMyShape != null) {
            controller.currentMyShape.setColor(controller.colorPicker.getValue());
        }
    }

    @Override
    public void buttonDeleteClicked(ActionEvent actionEvent) {
        if (controller.currentMyShape != null) {
            controller.myShapeList.remove(controller.currentMyShape);
            controller.canvas.getChildren().remove(controller.currentMyShape);
            controller.currentMyShape = null;
        }
    }
}
