package equipment.impl;

import equipment.api.IAccessory;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by anobis on 2/21/16.
 */
public class Accessory implements IAccessory {
    public enum Type {
        RING,
        AMULET,
        BELT,
        QUIVER
    }

    private final Map<String, String> attributes;

    public Accessory() {
        this.attributes = new HashMap<String, String>();
    }

    public Map<String, String> getAttributes() {
        return Collections.unmodifiableMap(attributes);
    }

    public Accessory addAttribute(String name, String value) {
        attributes.put(name, value);
        return this;
    }
}
