package com.netcracker;

        import org.apache.http.HttpResponse;
        import org.apache.http.client.HttpClient;
        import org.apache.http.client.methods.HttpGet;
        import org.apache.http.impl.client.HttpClientBuilder;


        import javax.ws.rs.client.Client;
        import javax.ws.rs.client.ClientBuilder;
        import javax.ws.rs.client.WebTarget;
        import javax.ws.rs.core.MediaType;
        import java.io.*;

public class CalculationRestClient {

    public static void main(String[] args) throws IOException {



        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpRequest = new HttpGet("http://localhost:8082/rest/calc/add/20/5/");
        HttpResponse httpResponse = httpClient.execute(httpRequest);
        System.out.println("httpResponse = " + httpResponse);
        InputStream content = httpResponse.getEntity().getContent();
        BufferedReader br = new BufferedReader(new InputStreamReader(content));
        String output;
        while ((output = br.readLine()) !=null){
            System.out.println(output);
        }

        // Client, WebTarget
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8082/rest/calc/div/{a}/{b}").resolveTemplate("a", "40").resolveTemplate("b","8");
        System.out.println(target.request(MediaType.TEXT_PLAIN).get(String.class));



    }
}
