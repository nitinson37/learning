public class Client {

  public static void main(String[] args) {

    AuthenticationHandler handler = new BasicAuthenticationHandler(new ClientCertificateAuthenticationHandler(new DigestAuthenticationHandler(null)));

    handler.handleRequest("basic");
    handler.handleRequest("digest");

  }

}
