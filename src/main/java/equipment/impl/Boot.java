package equipment.impl;

import java.util.Map;

/**
 * 2/20/16
 * @author {anobis}
 */
public class Boot extends Armour {
    private static final int MAX_SOCKETS = 4;
    private static final int MAX_LINKS = 4;

    public Boot(int level, int numSockets, int numLinks, BaseType type) {
        super(level, numSockets, numLinks, type);
    }
}
