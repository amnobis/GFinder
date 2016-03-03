package mods.api;

/**
 * 3/2/16
 *
 * @author {anobis}
 */
public enum Category {
    AMULET("Amulet"),
    AXE("Axe"),
    BELT("Belt"),
    BODY("Body"),
    BOOTS("Boots"),
    BOW("Bow"),
    CLAW("Claw"),
    DAGGER("Dagger"),
    GLOVES("Gloves"),
    HELMET("Helmet"),
    MACE("Mace"),
    QUIVER("Quiver"),
    RING("Ring"),
    SCEPTRE("Sceptre"),
    SHIELD("Shield"),
    STAFF("Staff"),
    SWORD("Sword"),
    WAND("Wand"),
    PSEUDO("Pseudo"),
    BLANK("Blank");

    private String label;

    Category(String label) {
        this.label = label;
    }

    public String toString() {
        return label;
    }
}
