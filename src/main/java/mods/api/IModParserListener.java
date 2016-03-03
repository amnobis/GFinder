package mods.api;

/**
 * @author anobis
 */
public interface IModParserListener {

    /**
     *
     * @param line
     */
    void notifyParsed(String line);
}
