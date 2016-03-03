package client.impl;

import com.gluonhq.ignite.guice.GuiceContext;
import mods.api.Category;
import mods.api.IModParser;
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
import mods.impl.Mods;
import ui.impl.SimplePane;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author anobis
 */

public class Client extends Application {
    @Inject IMods mods;
    @Inject IModParser mappingParser;
    private GuiceContext context = new GuiceContext(this, () -> Arrays.asList(new GuiceModule()));

    public void init(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        PoeClient poeClient = new PoeClient();
        SimplePane simplePane = new SimplePane();
        Scene scene = new Scene(simplePane.create());
        context.init();
        mappingParser.start();

        primaryStage.setScene(scene);
        primaryStage.show();
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

    public void setMods(IMods mods) {
        this.mods = mods;
    }

    public void setMappingParser(IModParser mappingParser) {
        this.mappingParser = mappingParser;
    }
}
