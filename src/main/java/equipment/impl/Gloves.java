package equipment.impl;

/**
 * Created by anobis on 2/20/16.
 */
public class Gloves extends Armour {
    private static final int MAX_SOCKETS = 4;
    private static final int MAX_LINKS = 4;

    public Gloves(int level, int numSockets, int numLinks, BaseType type) {
        super(level, numSockets, numLinks, type);
    }
}
