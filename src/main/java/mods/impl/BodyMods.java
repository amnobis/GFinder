package mods.impl;

import dagger.Module;
import dagger.Provides;

/**
 * @author anobis
 */
@Module
public class BodyMods extends Mods {
    @Provides
    @Override
    public void notifyParsed(String line) {
        if (line.contains("mods.Body.implicit")) {
            System.out.println(line);
            super.addImplicitMod(line.split("implicit.")[1], line);
        } else if (line.contains("mods.Body.explicit")) {
            super.addImplicitMod(line.split("explicit.")[1], line);
        }
    }
}
