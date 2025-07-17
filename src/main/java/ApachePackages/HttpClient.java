package ApachePackages;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClient {
    public static void main(String[] args) throws IOException {
        try(CloseableHttpClient httpClient = HttpClients.createDefault()){
            HttpGet httpget = new HttpGet("https://httpbin.org/get");
            System.out.println("Executing Request: "+httpget.getRequestLine());

            try(CloseableHttpResponse response = httpClient.execute(httpget)){
                System.out.println("---------------------------------------");
                System.out.println(response.getStatusLine());
                String responseBody = EntityUtils.toString(response.getEntity());
                System.out.println("response Body: " + responseBody);
            }
        }
    }
}
