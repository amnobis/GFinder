package client.impl;

import com.google.inject.AbstractModule;
import mods.api.IModParser;
import mods.api.IModParserListener;
import mods.api.IMods;
import mods.impl.ModParser;
import mods.impl.Mods;

/**
 * @author anobis
 */
public class GuiceModule extends AbstractModule {
    @Override protected void configure() {
        bind(IModParser.class).to(ModParser.class);
        bind(IMods.class).to(Mods.class);
        bind(IModParserListener.class).to(Mods.class);
    }
}
