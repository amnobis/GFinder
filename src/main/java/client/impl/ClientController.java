package client.impl;

import mods.api.IModParser;
import mods.api.IMods;

/**
 * 3/1/16
 * @author {anobis}
 */
public class ClientController {
    private final IModParser mappingParser;
    private final IMods mods;

    public ClientController(IModParser mappingParser, IMods mods) {
        this.mappingParser = mappingParser;
        this.mods = mods;
    }

    public final IModParser getMappingParser() {
        return mappingParser;
    }

    public final IMods getMods() {
        return mods;
    }
}
