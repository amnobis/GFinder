package client.impl;

import com.google.inject.Guice;
import com.google.inject.Injector;
import elasticsearch.api.IMappingParser;
import elasticsearch.api.IMappingParserListener;
import elasticsearch.impl.MappingParser;
import elasticsearch.impl.PoeClient;
import javafx.stage.Stage;
import mods.api.IMods;
import mods.impl.*;

import java.util.*;

/**
 * @author anobis
 */
public class ClientApplication {
    public static void main(String[] args) throws Exception {
        Client client = new Client();
        ClientApplication clientApplication = new ClientApplication();
        clientApplication.init(args);
        //client.startUp(args);
    }

    public void init(String[] args) {
        Set<IMods> mods = new HashSet<>();
        Set<IMappingParserListener> listeners = new HashSet<>();

        Injector injector = Guice.createInjector(new GuiceModule());
        injector.getInstance(MappingParser.class).start();

//        Mods bodyMods = new BodyMods();
//        Mods bootMods = new BootMods();
//        Mods gloveMods = new GloveMods();
//        Mods helmMods = new HelmMods();
//        Mods shieldMods = new ShieldMods();
//
//        mods.addAll(Arrays.asList(bodyMods, bootMods, gloveMods, helmMods, shieldMods));
//        listeners.addAll(Arrays.asList(bodyMods, bootMods, gloveMods, helmMods, shieldMods));
//        IMappingParser mappingParser = new MappingParser(listeners);
//        mappingParser.start();
        Client client = new Client();
        client.init(args);
    }
}
