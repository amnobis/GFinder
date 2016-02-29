package mods.impl;

/**
 * Created by anobis on 2/28/16.
 */
public class HelmMods extends Mods {
    @Override
    public void notifyParsed(String line) {
        if (line.contains("mods.Helmet.implicit")) {
            super.addExplicit(line, line);
        } else if (line.contains("mods.Helmet.explicit")) {
            super.addImplicitMod(line, line);
        }
    }
}
