package equipment.impl;

import equipment.api.IArmour;

/**
 * Created by anobis on 2/20/16.
 */
public class Body extends Armour {
    private static final int MAX_SOCKETS = 6;
    private static final int MAX_LINKS = 6;

    public Body(int level, int numSockets, int numLinks, BaseType type) {
        super(level, numSockets, numLinks, type);
    }
}
