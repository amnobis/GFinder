package mods.impl;

import javax.inject.Singleton;

/**
 * @author anobis
 */
@Singleton
public class GloveMods extends Mods {
    @Override
    public void notifyParsed(String line) {
        if (line.contains("mods.Gloves.implicit")) {
            addImplicitMod(line, line);
        } else if (line.contains("mods.Gloves.explicit")) {
            addExplicitMod(line, line);
        }
    }
}
