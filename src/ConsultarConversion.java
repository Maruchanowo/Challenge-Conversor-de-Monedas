import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarConversion {
    public Valor buscarConversion(String primeraMoneda, String segundaMoneda, double cantidad) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/212463431e450ff47047518a/pair/"+primeraMoneda+"/"+segundaMoneda+"/"+cantidad);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = null;
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), Valor.class);
        } catch (Exception e) {
            throw new RuntimeException("no encontre esa conversion.");
        }
    }
}
