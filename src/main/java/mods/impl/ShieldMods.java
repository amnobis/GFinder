package mods.impl;

import javax.inject.Singleton;

/**
 * 2/28/16
 * @author {anobis}
 */
@Singleton
public class ShieldMods extends Mods{
    @Override
    public void notifyParsed(String line) {
        if (line.contains("mods.Shield.implicit")) {
            addImplicitMod(line, line);
        } else if (line.contains("mods.Shield.explicit")) {
            addExplicitMod(line, line);
        }
    }
}
