package elasticsearch.api;

/**
 * @author anobis
 */
public interface IMappingParserListener {

    /**
     *
     * @param line
     */
    void notifyParsed(String line);
}
