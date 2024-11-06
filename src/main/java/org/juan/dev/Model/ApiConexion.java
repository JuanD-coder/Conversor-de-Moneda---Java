package org.juan.dev.Model;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiConexion {

    private String valor1;
    private  String valor2;

    public ExchangeRateAPI getChangesMoney(int option, double valorChange) {

        HttpClient client = HttpClient.newHttpClient();
        setCurrencies(option);

        String url = String.format("https://v6.exchangerate-api.com/v6/e1bceb399250004f29e3c11a/pair/%s/%s/%f", valor1, valor2, valorChange);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), ExchangeRateAPI.class);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener el cambio de moneda: " + e.getMessage());
        }

    }

    private void setCurrencies(int option) {
        String USD = "USD";
        String ARS = "ARS";
        String BRL = "BRL";
        String COP = "COP";

        switch (option) {
            case 1:
                valor1 = USD;
                valor2 = ARS;
                break;
            case 2:
                valor1 = ARS;
                valor2 = USD;
                break;
            case 3:
                valor1 = USD;
                valor2 = BRL;
                break;
            case 4:
                valor1 = BRL;
                valor2 = USD;
                break;
            case 5:
                valor1 = USD;
                valor2 = COP;
                break;
            case 6:
                valor1 = COP;
                valor2 = USD;
                break;
            default:
                throw new IllegalArgumentException("Opción de moneda no válida.");
        }
    }

    public String getValor1() {
        return valor1;
    }

    public String getValor2() {
        return valor2;
    }


}
