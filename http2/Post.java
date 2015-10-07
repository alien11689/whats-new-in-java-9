// http://cr.openjdk.java.net/~michaelm/8087112/03/
import static java.net.httpclient.HttpRequest.*;
import static java.net.httpclient.HttpResponse.*;

public class Http2Example {
  public static void main(String [] args){
    HttpResponse response = HttpRequest
        .create(new URI("http://www.foo.com"))
        .body(fromString("param1=foo,param2=bar"))
        .POST()
        .response();
  }
}
