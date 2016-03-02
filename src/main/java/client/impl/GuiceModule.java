package client.impl;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import elasticsearch.api.IMappingParser;
import elasticsearch.api.IMappingParserListener;
import elasticsearch.impl.MappingParser;
import mods.api.IMods;
import mods.impl.*;

/**
 * @author anobis
 */
public class GuiceModule extends AbstractModule {
    @Override protected void configure() {
        Multibinder<IMappingParserListener> multibinder = Multibinder.newSetBinder(binder(), IMappingParserListener.class);

        multibinder.addBinding().to(BodyMods.class);
        multibinder.addBinding().to(BootMods.class);
        multibinder.addBinding().to(GloveMods.class);
        multibinder.addBinding().to(HelmMods.class);
        multibinder.addBinding().to(ShieldMods.class);

        bind(IMappingParser.class).to(MappingParser.class);
        bind(IMods.class).to(BodyMods.class);
    }
}
