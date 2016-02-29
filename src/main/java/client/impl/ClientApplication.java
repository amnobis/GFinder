package client.impl;

/**
 * @author anobis
 */
public class ClientApplication {
    public static void main(String[] args) throws Exception {
        Client client = new Client();

        client.startUp(args);
    }
}
