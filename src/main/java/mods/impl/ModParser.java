package mods.impl;

import mods.api.IModParser;
import mods.api.IModParserListener;
import org.apache.log4j.Logger;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
 * @author anobis
 */
@Singleton
public class ModParser implements IModParser {
    private static final Logger LOG = Logger.getLogger(ModParser.class);
    // Eventually the mapping will be a Key/Value pair in an ini file
    private static final String mappingUrl = "http://exiletools.com/endpoints/mapping";
    private final IModParserListener listener;

    @Inject
    public ModParser(IModParserListener listener) {
        this.listener = listener;
    }

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
            listener.notifyParsed(line);
        }
    }

    @Override
    public String toString() {
        return "ModParser{" +
                "listeners=" + listener +
                '}';
    }
}
