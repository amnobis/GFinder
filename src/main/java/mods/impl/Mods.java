package mods.impl;

import mods.api.IModParserListener;
import mods.api.Category;
import mods.api.IMods;

import javax.inject.Singleton;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author anobis
 */
@Singleton
public class Mods implements IMods, IModParserListener {
    private final Map<Category, Mod> mods;
    private final Map<String, String> pseudoMods;

    public Mods() {
        this.mods = new HashMap<>();
        this.pseudoMods = new HashMap<>();
        for (Category cat : Category.values()) {
            addMod(cat, new Mod());
        }
    }

    private Mods addMod(Category category, Mod mod) {
        mods.put(category, mod);
        return this;
    }

    private Mods addPseudoMod(String key, String value) {
        pseudoMods.put(key, value);
        return this;
    }

    @Override
    public Mod getMod(Category category) {
        return mods.get(category);
    }

    @Override
    public Map<String, String> getPseudoMods() {
        return Collections.unmodifiableMap(pseudoMods);
    }

    @Override
    public void notifyParsed(String line) {
        Category category = Category.BLANK;

        for (Category value : Category.values()) {
            if (line.contains("mods." + value)) {
                category = value;
            }
        }

        if (line.contains("implicit") && category != Category.BLANK) {
            getMod(category).addImplicitMod(line.split("implicit.")[1], line);
        } else if (line.contains("explicit") && category != Category.BLANK) {
            getMod(category).addExplicitMod(line.split("explicit.")[1], line);
        }
    }

    public static class Mod {
        // Key: Display Name | Value: JSON query name
        private final Map<String, String> explicitMods;
        private final Map<String, String> implicitMods;

        public Mod() {
            this.explicitMods = new HashMap<>();
            this.implicitMods = new HashMap<>();
        }

        public Mod addImplicitMod(String key, String value) {
            implicitMods.put(key, value);
            return this;
        }

        public Mod addExplicitMod(String key, String value) {
            explicitMods.put(key, value);
            return this;
        }

        public Map<String, String> getImplicitMods() {
            return Collections.unmodifiableMap(implicitMods);
        }

        public Map<String, String> getExplicitMods() {
            return Collections.unmodifiableMap(explicitMods);
        }
    }
}