package equipment.impl;

import equipment.api.IArmour;
import org.apache.log4j.Logger;

/**
 * Created by anobis on 2/21/16.
 */
public class Armour implements IArmour {
    private static final Logger LOG = Logger.getLogger(Armour.class);
    private static final int RED = 0;
    private static final int GREEN = 1;
    private static final int BLUE = 2;
    private static final int WHITE = 3;

    public enum BaseType {
        NONE,
        AR,
        ARES,
        AREV,
        AREVES,
        EV,
        EVES,
        ES
    }

    private final int numSockets;
    private final int numLinks;
    private final int level;
    private final BaseType type;
    private final int[] colorSockets;

    public Armour(int level, int numSockets, int numLinks, BaseType type) {
        this.level = level;
        this.numSockets = numSockets;
        this.numLinks = numLinks;
        this.type = type;
        this.colorSockets = new int[4];
    }

    public int getLevel() {
        return level;
    }

    public int getNumSockets() {
        return numSockets;
    }

    public int getNumLinks() {
        return numLinks;
    }

    public BaseType getType() {
        return type;
    }

    public int[] getSockets() {
        return colorSockets;
    }

    public int getRedSockets() {
        return colorSockets[RED];
    }

    public int getGreenSockets() {
        return colorSockets[GREEN];
    }

    public int getBlueSockets() {
        return colorSockets[BLUE];
    }

    public int getWhiteSockets() {
        return colorSockets[WHITE];
    }

    public Armour setColorSocket(int numSockets, int color) {
        switch(color) {
            case RED:
                colorSockets[RED] = numSockets;
                break;
            case GREEN:
                colorSockets[GREEN] = numSockets;
                break;
            case BLUE:
                colorSockets[BLUE] = numSockets;
                break;
            case WHITE:
                colorSockets[WHITE] = numSockets;
                break;
        }
        return this;
    }
}
