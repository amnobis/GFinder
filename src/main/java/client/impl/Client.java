package client.impl;

import elasticsearch.api.IMappingParser;
import elasticsearch.impl.PoeClient;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import mods.api.IMods;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author anobis
 */

public class Client extends Application {
    private IMods mods;
    private IMappingParser mappingParser;

    @Inject
    public void setMods(IMods mods) {
        this.mods = mods;
    }

    @Inject
    public void setMappingParser(IMappingParser mappingParser) {
        this.mappingParser = mappingParser;
    }

    public void startUp(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new Group(), 500, 250);

        final ComboBox<String> difficulty = new ComboBox<>();
        final ComboBox<String> league = new ComboBox<>();
        final TextField coldResist = new NumberTextField();
        final TextField fireResist = new NumberTextField();
        final TextField liteResist = new NumberTextField();
        final TextField currency = new TextField();
        final ComboBox<String> equipment = new ComboBox<>();
        final ComboBox<String> modBox = new ComboBox<>();
        final Button solve = new Button("Solve");

        PoeClient poeClient = new PoeClient();
        mappingParser.start();

        List<String> equipmentList = new ArrayList<>(Arrays.asList("Body", "Boot", "Glove", "Helm", "Shield",
                "Ring", "Ring", "Amulet", "Belt"));
        List<String> difficultyList = new ArrayList<>(Arrays.asList("Normal", "Cruel", "Merciless"));
        List<String> leagueList = new ArrayList<>(Arrays.asList("Hardcore", "Talisman", "Standard"));
        List<String> implicit = new ArrayList<>();


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
        grid.setTop(solve);
        grid.setBottom(modBox);
        grid.setRight(equipment);


        equipment.setOnAction(event -> {
            try {
                for (String key : mods.getImplicit().keySet()) {
                    System.out.println(key);
                    implicit.add(key);
                }

                modBox.getItems().addAll(implicit);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

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
            CheckBox boots = new CheckBox("Boot");
            CheckBox gloves = new CheckBox("Glove");
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
}
