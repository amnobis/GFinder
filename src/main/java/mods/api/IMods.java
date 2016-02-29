package mods.api;

import java.util.Map;

/**
 * Created by anobis on 2/28/16.
 */
public interface IMods {
    Map<String, String> getImplicit();

    Map<String, String> getExplicit();
}
