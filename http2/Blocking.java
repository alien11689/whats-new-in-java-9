// http://cr.openjdk.java.net/~michaelm/8087112/03/
import static java.net.httpclient.HttpRequest.*;
import static java.net.httpclient.HttpResponse.*;

public class Http2Example {
  public static void main(String [] args){
    HttpResponse r1 = HttpRequest.create(new URI("http://www.foo.com/1"))
        .GET()
        .response();
    int responseCode = r1.statusCode());
    String body = r1.body(asString());

    HttpResponse r2 = HttpRequest.create(new URI("http://www.foo.com/2"))
        .GET()
        .response();

    System.out.println("Response was " + r1.statusCode());
    Path body = r2.body(asFile(Paths.get("/tmp/response.txt")));
    // Content stored in /tmp/response.txt

    HttpResponse r3 = HttpRequest.create(new URI("http://www.foo.com/"))
        .body(fromString("param1=1, param2=2"))
        .POST()
        .response();

    Void body = r3.body(ignoreBody());
  }
}
