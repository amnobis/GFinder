package elasticsearch.impl;

import dagger.Module;
import elasticsearch.api.IMappingParser;
import elasticsearch.api.IMappingParserListener;
import org.apache.log4j.Logger;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author anobis
 */
@Module
public class MappingParser implements IMappingParser {
    private static final Logger LOG = Logger.getLogger(MappingParser.class);
    // Eventually the mapping will be a Key/Value pair in an ini file
    private static final String mappingUrl = "http://exiletools.com/info/mapping?field=*";
    private Set<IMappingParserListener> listeners = new HashSet<>();

    @Override
    public synchronized void start() {
        try {
            URL url = new URL(mappingUrl);
            Scanner scanner = new Scanner(url.openStream());
            parse(scanner);
        } catch (IOException e) {
            e.printStackTrace();
            LOG.error(e);
        }
    }

    private synchronized void parse(Scanner scanner) {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            for (IMappingParserListener listener : listeners) {
                listener.notifyParsed(line);
            }
        }
    }

    @Inject
    synchronized public void addListener(Set<IMappingParserListener> listeners) {
        this.listeners = listeners;
    }
}
