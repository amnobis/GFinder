package equipment.impl;

import java.util.Map;

/**
 * Created by anobis on 2/20/16.
 */
public class Boot extends Armour {
    private static final int MAX_SOCKETS = 4;
    private static final int MAX_LINKS = 4;

    public Boot(int level, int numSockets, int numLinks, BaseType type) {
        super(level, numSockets, numLinks, type);
    }
}
