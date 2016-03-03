package ui.impl;

import elasticsearch.impl.SearchQuery;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import mods.api.Category;
import mods.impl.Mods;

/**
 * 3/2/16
 *
 * @author {anobis}
 */
public class SimplePane {
    private final BorderPane root;
    private final TableView<TableColumn> recentSearches;
    private final TabPane searchPane;
    private final TreeView watchPane;
    private final MenuBar menuPane;

    public SimplePane() {
        this.root = new BorderPane();
        this.recentSearches = new TableView<>();
        this.searchPane = new TabPane();
        this.watchPane = new TreeView();
        this.menuPane = new MenuBar();
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
        GridPane searchGrid = new GridPane();
        Tab searchQuery = new Tab("Query");
        Tab searchResult = new Tab("Result");
        searchQuery.setClosable(false);
        ComboBox<String> leagueBox = new ComboBox<>();


        AutoCompleteComboBox<String> autoLeagueBox = new AutoCompleteComboBox<>(leagueBox);
        leagueBox.getItems().addAll("Standard", "Hardcore", "Talisman");

        searchQuery.setContent(searchGrid);
        searchGrid.add(leagueBox, 0, 0);
        searchPane.getTabs().addAll(searchQuery, searchResult);
    }

    private void addWatchPane() {

    }

    private void addMenuPane() {
        Menu menuFile = new Menu("File");
        menuPane.getMenus().addAll(menuFile);
    }
}
