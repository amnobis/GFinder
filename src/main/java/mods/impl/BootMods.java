package mods.impl;

import javax.inject.Singleton;

/**
 * @author anobis
 */
@Singleton
public class BootMods extends Mods {
    @Override
    public void notifyParsed(String line) {
        if (line.contains("mods.Boots.implicit")) {
            addImplicitMod(line.split("implicit.")[1], line);
        } else if (line.contains("mods.Boots.explicit")) {
            System.out.println(line);
            addExplicitMod(line.split("explicit.")[1], line);
        }
    }
}
