package mods.impl;

/**
 * @author anobis
 */
public class BootMods extends Mods {
    @Override
    public void notifyParsed(String line) {
        if (line.contains("mods.Boots.implicit")) {
            super.addExplicit(line.split("implicit.")[1], line);
        } else if (line.contains("mods.Boots.explicit")) {
            super.addImplicitMod(line.split("explicit.")[1], line);
        }
    }
}
