package client.impl;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by anobis on 2/21/16.
 */
public class Client extends Application {

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new Group(), 500, 250);

        final ComboBox<String> difficulty = new ComboBox<>();
        final TextField coldResist = new TextField();
        final TextField fireResist = new TextField();
        final TextField liteResist = new TextField();
        final TextField currency = new TextField();
        final Button solve = new Button("Solve");
        solve.setAlignment(Pos.BASELINE_RIGHT);

        List<String> options = new ArrayList<>(Arrays.asList("Normal", "Cruel", "Merciless"));

        difficulty.getItems().addAll(options);
        difficulty.setValue("Normal");

        GridPane grid = new GridPane();
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.add(difficulty, 2, 2);
        grid.add(new Label("Cold Resist:"), 2, 3);
        grid.add(coldResist, 3, 3);
        grid.add(new Label("Fire Resist:"), 2, 4);
        grid.add(fireResist, 3, 4);
        grid.add(new Label("Light Resist:"), 2, 5);
        grid.add(liteResist, 3, 5);
        grid.add(new Label("Currency:"), 2, 7);
        grid.add(currency, 3, 7);
        grid.add(solve, 3, 10);


        Group rew = (Group)scene.getRoot();
        rew.getChildren().add(grid);

        primaryStage.setTitle("POE Resist Finder");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
