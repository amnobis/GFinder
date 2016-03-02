package mods.api;

import java.util.Map;

/**
 * @author anobis
 */
public interface IMods {
    Map<String, String> getImplicit();

    Map<String, String> getExplicit();
}
