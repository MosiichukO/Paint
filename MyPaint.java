package Paint;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.control.ColorPicker;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;



public class MyPaint extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("My paint");
        Canvas canvas = new Canvas(800, 500);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1);

        ColorPicker cp = new ColorPicker();
        cp.setValue(Color.BLACK);
        cp.setOnAction(e -> {
            gc.setStroke(cp.getValue());
        });

        Slider sl = new Slider();
        sl.setMin(1);
        sl.setMax(10);
        sl.setLayoutX(150);
        sl.setLayoutY(5);
        sl.setShowTickLabels(true);
        sl.setShowTickMarks(true);
        sl.valueProperty().addListener(e -> {
            double value = sl.getValue();
            gc.setLineWidth(value);
        });

        Pane pane = new Pane();
        Scene scene = new Scene(pane, 800, 500);
        stage.setScene(scene);
        stage.show();

        scene.setOnMousePressed(e ->{
        gc.beginPath();
        gc.lineTo(e.getSceneX(), e.getSceneY());
        gc.stroke();
        } );

       scene.setOnMouseDragged(e ->{
       gc.lineTo(e.getSceneX(), e.getSceneY());
       gc.stroke();
       } );

       pane.getChildren().addAll(canvas, cp, sl);
       }
}


