package ui.impl;

import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import mods.api.Category;
import mods.api.IMods;
import mods.impl.Mods;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 3/2/16
 *
 * @author {anobis}
 */
@Singleton
public class SimplePane {
    private final BorderPane root;
    private final TableView<TableColumn> recentSearches;
    private final TabPane searchPane;
    private final TreeView watchPane;
    private final MenuBar menuPane;
    private final IMods mods;

    public SimplePane(IMods mods) {
        this.root = new BorderPane();
        this.recentSearches = new TableView<>();
        this.searchPane = new TabPane();
        this.watchPane = new TreeView();
        this.menuPane = new MenuBar();
        this.mods = mods;
    }

    public BorderPane create() {
        root.setLeft(recentSearches);
        root.setCenter(searchPane);
        root.setRight(watchPane);
        root.setTop(menuPane);
        addRecentSearchPane();
        addSearchPane();
        addWatchPane();
        addMenuPane();
        return(root);
    }

    private void addRecentSearchPane() {
        TableColumn category = new TableColumn("Category");
        TableColumn mods = new TableColumn("Mods");

        recentSearches.getColumns().addAll(category, mods);
        recentSearches.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
//        equipment.getItems().setAll(Category.values());
//        equipment.setMaxHeight(200);
//        equipment.setMaxWidth(150);
//        difficulty.getItems().addAll(difficultyList);
//        difficulty.setValue("Normal");
//        league.getItems().addAll(leagueList);
//        league.setValue("Standard");
//
//        BorderPane grid = new BorderPane();
//        grid.setPadding(new Insets(5, 5, 5, 5));
//        grid.setTop(solve);
//        grid.setBottom(modBox);
//        grid.setRight(equipment);
//
//        equipment.setOnAction(event -> {
//            try {
//                modBox.getItems().clear();
//                Mods.Mod mod = mods.getMod(equipment.getValue());
//                modBox.getItems().addAll(mod.getExplicitMods().keySet());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });
    }


    private void addSearchPane() {
        Label leagueLabel = new Label("League");
        Label typeLabel = new Label("Type");
        Label implicitLabel = new Label("Implicit");
        Label explicitLabel = new Label("Explicit");

        GridPane searchGrid = new GridPane();
        Tab searchQuery = new Tab("Query");
        Tab searchResult = new Tab("Result");
        searchQuery.setClosable(false);
        ComboBox<String> leagueBox = new ComboBox<>();
        ComboBox<Category> typeBox = new ComboBox<>();
        ComboBox<String> implicitModBox = new ComboBox<>();
        List<ExplicitModRow> explicitModRows = new ArrayList<>();
        Button addMod = new Button("Add mod");

        explicitModRows.add(new ExplicitModRow());

        Event rowAdded = new RowEvent();


        leagueBox.getItems().addAll("Standard", "Hardcore", "Talisman");
        typeBox.getItems().setAll(Category.values());

        implicitModBox.setMaxWidth(600);

        searchQuery.setContent(searchGrid);

        searchGrid.setAlignment(Pos.TOP_LEFT);
        searchGrid.setHgap(20);
        searchGrid.setVgap(10);
        searchGrid.setPadding(new Insets(10, 10, 10, 10));
        searchGrid.add(leagueLabel, 0, 0);
        searchGrid.add(leagueBox, 0, 1);
        searchGrid.add(typeLabel, 2, 0);
        searchGrid.add(typeBox, 2, 1);
        searchGrid.add(implicitLabel, 0, 4);
        searchGrid.add(implicitModBox, 0, 5, 4, 1);
        searchGrid.add(explicitLabel, 0, 6);
        searchGrid.add(explicitModRows.get(0).row, 0, 7, 6, 1);
        searchGrid.add(addMod, 2, 8);

        System.out.println(mods.getMod(Category.AMULET).getExplicitMods().size());


        typeBox.addEventHandler(RowEvent.ROW_ADDED, event -> {
            Mods.Mod mod = mods.getMod(typeBox.getValue());
            List<String> sortedExplicit = new ArrayList<>(mod.getExplicitMods().keySet());
            Collections.sort(sortedExplicit);

            explicitModRows.get(explicitModRows.size() - 1).explicitModBox.getItems().addAll(sortedExplicit);
        });

        typeBox.setOnAction(event -> {
            try {
                Mods.Mod mod = mods.getMod(typeBox.getValue());


                implicitModBox.getItems().clear();
                List<String> sortedImplicit = new ArrayList<>(mod.getImplicitMods().keySet());
                List<String> sortedExplicit = new ArrayList<>(mod.getExplicitMods().keySet());
                Collections.sort(sortedImplicit);
                Collections.sort(sortedExplicit);
                implicitModBox.getItems().addAll(sortedImplicit);

                for (ExplicitModRow explicit : explicitModRows) {
                    explicit.explicitModBox.getItems().clear();
                    explicit.explicitModBox.getItems().addAll(sortedExplicit);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });



        addMod.setOnAction(event -> {
            final int addModRow = GridPane.getRowIndex(addMod);
            searchGrid.getChildren().remove(addMod);
            explicitModRows.add(new ExplicitModRow());
            searchGrid.add(explicitModRows.get(explicitModRows.size() - 1).row, 0, addModRow, 6, 1);
            searchGrid.add(addMod, 2, addModRow+1);
            typeBox.fireEvent(rowAdded);
        });

        searchPane.getTabs().addAll(searchQuery, searchResult);
    }

    private void addWatchPane() {

    }

    private void addMenuPane() {
        Menu menuFile = new Menu("File");
        menuPane.getMenus().addAll(menuFile);
    }

    public class ExplicitModRow {
        private final HBox row;
        private final ComboBox<String> explicitModBox;
        private final AutoCompleteComboBox<String> autoCompleteBox;
        private final NumberTextField min;
        private final NumberTextField max;
        private final HBox minMax;
        private final Button removeMod;

        public ExplicitModRow() {
            this.row = new HBox(10);
            this.explicitModBox = new ComboBox<>();
            this.autoCompleteBox = new AutoCompleteComboBox<>(explicitModBox);
            this.min = new NumberTextField();
            this.max = new NumberTextField();
            this.minMax = new HBox();
            this.removeMod = new Button("X");
            init();
        }

        private void init() {
            min.setMaxWidth(50);
            max.setMaxWidth(50);
            min.setText("MIN");
            max.setText("MAX");
            minMax.getChildren().addAll(min, max);
            row.getChildren().addAll(explicitModBox, minMax, removeMod);
            row.setMaxWidth(1000);
        }
    }
}


