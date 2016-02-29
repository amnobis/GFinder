package mods.impl;

/**
 * Created by anobis on 2/28/16.
 */
public class ShieldMods extends Mods{
    @Override
    public void notifyParsed(String line) {
        if (line.contains("mods.Shield.implicit")) {
            super.addExplicit(line, line);
        } else if (line.contains("mods.Shield.explicit")) {
            super.addImplicitMod(line, line);
        }
    }
}
