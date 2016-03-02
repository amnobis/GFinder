package client.impl;

import elasticsearch.api.IMappingParser;
import mods.api.IMods;

/**
 * 3/1/16
 * @author {anobis}
 */
public class ClientController {
    private final IMappingParser mappingParser;
    private final IMods mods;

    public ClientController(IMappingParser mappingParser, IMods mods) {
        this.mappingParser = mappingParser;
        this.mods = mods;
    }

    public final IMappingParser getMappingParser() {
        return mappingParser;
    }

    public final IMods getMods() {
        return mods;
    }
}
