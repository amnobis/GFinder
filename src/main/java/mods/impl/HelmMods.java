package mods.impl;

import javax.inject.Singleton;

/**
 * 2/28/16
 * @author {anobis}
 */
@Singleton
public class HelmMods extends Mods {
    @Override
    public void notifyParsed(String line) {
        if (line.contains("mods.Helmet.explicit")) {
            addExplicitMod(line, line);
        } else if (line.contains("mods.Helmet.implicit")) {
            addImplicitMod(line, line);
        }
    }
}
