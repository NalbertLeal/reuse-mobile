package br.ufrn.reuse.remote.rest.retrofit;

import java.io.IOException;

import br.ufrn.reuse.remote.auth.AuthRemoteService;
import br.ufrn.reuse.remote.rest.ApiConfig;
import br.ufrn.reuse.remote.DTO.AuthorizationDTO;
import br.ufrn.reuse.remote.rest.ClientDetails;
import br.ufrn.reuse.remote.rest.OAuth2Autenticator;
import br.ufrn.reuse.repository.local.config.DataAccessException;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Daniel on 11/19/2017.
 */

public class RetrofitFactory {


    private static final Retrofit retrofitBuilder = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(ApiConfig.getBaseUrl())
            .build();
    private static final OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();

    public static <T> T getOAuth2Client(Class<T> clientClass) {
        ClientDetails clientDetails = ApiConfig.getClientDetails();

        clientBuilder.addInterceptor(chain -> {
            Request oldRequest = chain.request();

            Request request = oldRequest.newBuilder()
                    .header("x-api-key", clientDetails.getApiKey())
                    .method(oldRequest.method(),oldRequest.body())
                    .build();

            return chain.proceed(oldRequest);
        });

        return retrofitBuilder.create(clientClass);
    }

}
