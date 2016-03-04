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

        Client client = new Client();
        client.init(args);
    }
}
