package client.impl;

import com.google.inject.Guice;
import com.google.inject.Injector;
import mods.api.IModParserListener;
import mods.impl.ModParser;
import mods.api.IMods;

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
        Set<IModParserListener> listeners = new HashSet<>();

        Injector injector = Guice.createInjector(new GuiceModule());
        injector.getInstance(ModParser.class).start();

//        Mods bodyMods = new BodyMods();
//        Mods bootMods = new BootMods();
//        Mods gloveMods = new GloveMods();
//        Mods helmMods = new HelmMods();
//        Mods shieldMods = new ShieldMods();
//
//        mods.addAll(Arrays.asList(bodyMods, bootMods, gloveMods, helmMods, shieldMods));
//        listeners.addAll(Arrays.asList(bodyMods, bootMods, gloveMods, helmMods, shieldMods));
//        IModParser mappingParser = new ModParser(listeners);
//        mappingParser.start();
        Client client = new Client();
        client.init(args);
    }
}
