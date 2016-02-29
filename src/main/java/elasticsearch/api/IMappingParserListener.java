package elasticsearch.api;

/**
 * Created by anobis on 2/28/16.
 */

public interface IMappingParserListener {

    /**
     *
     * @param line
     */
    void notifyParsed(String line);
}
