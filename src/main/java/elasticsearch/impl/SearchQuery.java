package elasticsearch.impl;

import java.util.ArrayList;
import java.util.List;

/**
 * 3/2/16
 *
 * @author {anobis}
 */
public class SearchQuery {
    private String league;
    private String query;
    private String implicitMod;
    private List<String> explicitMods;

    public SearchQuery() {
        this.query = "Query";
        this.implicitMod = "Implicit";
        this.explicitMods = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "SearchQuery{" +
                "query='" + query + '\'' +
                '}';
    }
}
