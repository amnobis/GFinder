package mods.impl;

/**
 * Created by anobis on 2/28/16.
 */
public class GloveMods extends Mods{
    @Override
    public void notifyParsed(String line) {
        if (line.contains("mods.Gloves.implicit")) {
            super.addExplicit(line, line);
        } else if (line.contains("mods.Gloves.explicit")) {
            super.addImplicitMod(line, line);
        }
    }
}
