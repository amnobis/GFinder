package mods.impl;

import javax.inject.Singleton;

/**
 * @author anobis
 */
@Singleton
public class BodyMods extends Mods {
    @Override
    public void notifyParsed(String line) {
        if (line.contains("mods.Body.implicit")) {
            addImplicitMod(line.split("implicit.")[1], line);
        } else if (line.contains("mods.Body.explicit")) {
           addExplicitMod(line.split("explicit.")[1], line);
        }
    }
}
