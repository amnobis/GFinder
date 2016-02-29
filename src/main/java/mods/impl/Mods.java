package mods.impl;

import elasticsearch.api.IMappingParserListener;
import mods.api.IMods;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author anobis
 */
public abstract class Mods implements IMods, IMappingParserListener {
    private final Map<String, String> explicitMods;
    private final Map<String, String> implicitMods;

    public Mods() {
        this.explicitMods = new HashMap<>();
        this.implicitMods = new HashMap<>();
    }

    public Mods addImplicitMod(String key, String mod) {
        implicitMods.put(key, mod);
        return this;
    }

    public Mods addExplicit(String key, String mod) {
        explicitMods.put(key, mod);
        return this;
    }

    @Override
    public Map<String, String> getImplicit() {
        return Collections.unmodifiableMap(implicitMods);
    }

    @Override
    public Map<String, String> getExplicit() {
        return Collections.unmodifiableMap(explicitMods);
    }
}
