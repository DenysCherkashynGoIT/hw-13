package ua.hw13.http;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Objects;
import java.util.function.UnaryOperator;

public class HttpBaseClient {
    private final String host;
    private final HttpClient httpClient = HttpClient.newBuilder().build();
    private HttpResponse<String> response = null;
    private final Gson gson = new Gson();

    public HttpBaseClient(String host) {
        this.host = host;
    }

    public <T> HttpResponse<String> doPOST(T body, String endPoint, String queries) {
        UnaryOperator<HttpRequest.Builder> method = (builder) ->
                builder.POST(HttpRequest.BodyPublishers.ofString(gson.toJson(body)));
        this.response = doSendMethod(method, endPoint, queries);
        return this.response;
    }

    public HttpResponse<String> doGET(String endPoint, String queries) {
        UnaryOperator<HttpRequest.Builder> method = HttpRequest.Builder::GET;
        this.response = doSendMethod(method, endPoint, queries);
        return this.response;
    }

    public <T> HttpResponse<String> doPUT(T body, String endPoint, String queries) {
        UnaryOperator<HttpRequest.Builder> method = (builder) ->
                builder.PUT(HttpRequest.BodyPublishers.ofString(gson.toJson(body)));
        this.response = doSendMethod(method, endPoint, queries);
        return this.response;
    }

    public HttpResponse<String> doDELETE(String endPoint, String queries) {
        UnaryOperator<HttpRequest.Builder> method = HttpRequest.Builder::DELETE;
        this.response = doSendMethod(method, endPoint, queries);
        return this.response;
    }

    private HttpResponse<String> doSendMethod(UnaryOperator<HttpRequest.Builder> method, String endPoint, String queries) {
        StringBuilder url = new StringBuilder(host);
        if (Objects.nonNull(endPoint)) {
            url.append("/").append(endPoint);
        }
        if (Objects.nonNull(queries)) {
            url.append("?").append(queries);
        }
        URI uri = null;
        try {
            uri = new URI(url.toString());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        HttpRequest.Builder builder = HttpRequest.newBuilder();
        HttpRequest request = method.apply(builder)
                .uri(uri)
                .header("Content-Type", "application/json; charset=UTF-8")
                .build();
        try {
            return this.httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public HttpResponse<String> response() {
        return this.response;
    }

    public String responseToString() {
        return this.response.body();
    }

    public <T> T responseToObject(Class<T> classOfT) {
        return gson.fromJson(this.responseToString(), classOfT);
    }

}
