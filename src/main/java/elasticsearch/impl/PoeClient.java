package elasticsearch.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.apache.log4j.Logger;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * 2/20/16
 * @author {anobis}
 */
public class PoeClient {
    private static final Logger LOG = Logger.getLogger(PoeClient.class);
    private static final String connectionUrl = "http://api.exiletools.com:80";


    public void startClient(String league) throws Exception {
        JestClientFactory factory = new JestClientFactory();
        factory.setHttpClientConfig(new HttpClientConfig
            .Builder(connectionUrl)
            .build());

        JestClient client = factory.getObject();

        String query = readFile("src/main/resources/test.json", Charset.defaultCharset());
        Map<String, Object> headers = new HashMap<>();

        headers.put("Authorization", "DEVELOPMENT-Indexer");

        Search search = new Search.Builder(query)
                .setHeader(headers)
                .addIndex("index").build();

        SearchResult result = client.execute(search);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(result.getJsonString());
        System.out.println(gson.toJson(je));
    }

    private static String readFile(String path, Charset encoding) {
        byte[] encoded;
        try {
            encoded = Files.readAllBytes(Paths.get(path));
        } catch (Exception e) {
            throw new RuntimeException("Fuck");
        }
        return new String(encoded, encoding);
    }
}