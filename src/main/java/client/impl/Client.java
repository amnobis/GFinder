package client.impl;

import elasticsearch.impl.PoeClient;
import equipment.api.IArmour;
import equipment.impl.Armour;
import equipment.impl.Body;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.ActionEvent;
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
        final ComboBox<String> league = new ComboBox<>();
        final TextField coldResist = new NumberTextField();
        final TextField fireResist = new NumberTextField();
        final TextField liteResist = new NumberTextField();
        final TextField currency = new TextField();
        final ListView<String> equipment = new ListView<>();
        final Button solve = new Button("Solve");
        solve.setAlignment(Pos.BASELINE_RIGHT);

        PoeClient poeClient = new PoeClient();

        List<String> equipmentList = new ArrayList<>(Arrays.asList("Body", "Boots", "Gloves", "Helm", "Shield",
                "Ring", "Ring", "Amulet", "Belt"));
        List<String> difficultyList = new ArrayList<>(Arrays.asList("Normal", "Cruel", "Merciless"));
        List<String> leagueList = new ArrayList<>(Arrays.asList("Hardcore", "Talisman", "Standard"));

        equipment.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        equipment.getItems().addAll(equipmentList);
        equipment.setMaxHeight(200);
        equipment.setMaxWidth(150);
        difficulty.getItems().addAll(difficultyList);
        difficulty.setValue("Normal");
        league.getItems().addAll(leagueList);
        league.setValue("Standard");

        BorderPane grid = new BorderPane();
        GearPane gearPane = new GearPane();
        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.setTop(difficulty);
        grid.setBottom(gearPane);
//        grid.add(difficulty, 2, 2);
//        grid.add(league, 3, 2);
//        grid.add(new Label("Cold Resist:"), 2, 3);
//        grid.add(coldResist, 3, 3);
//        grid.add(new Label("Fire Resist:"), 2, 4);
//        grid.add(fireResist, 3, 4);
//        grid.add(new Label("Light Resist:"), 2, 5);
//        grid.add(liteResist, 3, 5);
//        grid.add(new Label("Currency:"), 2, 7);
//        grid.add(currency, 3, 7);
//        grid.add(equipment, 4, 2, 1, 8);
//        grid.add(solve, 3, 8);

        solve.setOnAction(event -> {
            try {
                poeClient.startClient(league.getValue());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Group rew = (Group) scene.getRoot();
        rew.getChildren().add(grid);

        primaryStage.setTitle("POE Resist Finder");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public class GearPane extends GridPane {

        public GearPane() {
            CheckBox body = new CheckBox("Body Armour");
            CheckBox boots = new CheckBox("Boots");
            CheckBox gloves = new CheckBox("Gloves");
            CheckBox helm = new CheckBox("Helm");

            this.add(body, 1, 1);
            this.add(boots, 1, 2);
            this.add(gloves, 2, 1);
            this.add(helm, 2, 2);
        }
    }

    public class NumberTextField extends TextField
    {

        @Override
        public void replaceText(int start, int end, String text)
        {
            if (validate(text))
            {
                super.replaceText(start, end, text);
            }
        }

        @Override
        public void replaceSelection(String text)
        {
            if (validate(text))
            {
                super.replaceSelection(text);
            }
        }

        private boolean validate(String text)
        {
            return text.matches("^-?[0-9]*");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
