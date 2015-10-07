// http://cr.openjdk.java.net/~michaelm/8087112/03/
import static java.net.httpclient.HttpRequest.*;
import static java.net.httpclient.HttpResponse.*;

public class Http2Example {
  public static void main(String [] args){
    List<URI> targets = Arrays.asList(
        new URI("http://www.foo.com/1"),
        new URI("http://www.foo.com/2"));

    List<CompletableFuture<File>> futures = targets
        .stream()
        .map(target -> {
          return HttpRequest
              .create(target)
              .GET()
              .responseAsync()
              .thenCompose(response -> {
                  Path dest = Paths.get("base", target.getPath());
                  if (response.statusCode() == 200) {
                      return response.bodyAsync(asFile(dest));
                  } else {
                      return CompletableFuture.completedFuture(dest);
                  }
              })
              .thenApply((Path dest) -> {
                  return dest.toFile();
              });
          })
      .collect(Collectors.toList());

    CompletableFuture.allOf(futures.toArray(new CompletableFuture<?>[0]))
        .join();

  }
}
