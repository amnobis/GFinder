package equipment.impl;

/**
 * 2/20/16
 * @author {anobis}
 */
public class Helm extends Armour {
    private static final int MAX_SOCKETS = 4;
    private static final int MAX_LINKS = 4;

    public Helm(int level, int numSockets, int numLinks, BaseType type) {
        super(level, numSockets, numLinks, type);
    }

}
