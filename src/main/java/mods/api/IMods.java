package mods.api;

import mods.impl.Mods;

import java.util.Map;

/**
 * @author anobis
 */
public interface IMods {
    Mods.Mod getMod(Category category);

    Map<String, String> getPseudoMods();
}
