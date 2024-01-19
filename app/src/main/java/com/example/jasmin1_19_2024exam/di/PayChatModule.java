package com.example.jasmin1_19_2024exam.di;

import com.example.jasmin1_19_2024exam.data.api.PayChatService;
import com.example.jasmin1_19_2024exam.data.repository.PayChatRepositoryImpl;
import com.example.jasmin1_19_2024exam.domain.repository.PayChatRepository;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class PayChatModule {


    //I Couldn't use hilt dagger because of multidex error

    private static OkHttpClient provideOkHttpClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(chain -> {
                    Request original = chain.request();
                    Request request = original.newBuilder()
                            .header("Content-Type", "multipart/form-data")
                            .header("X-API-KEY", "kCXnaVqQEtdnvNnOACGjpzyYotHRYgY6")
                            .method(original.method(), original.body())
                            .build();
                    return chain.proceed(request);
                })
                .build();
    }


    private static Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://odin.paychat.ph/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(provideOkHttpClient())
                .build();
    }


    private static PayChatService provideApiService() {
        return provideRetrofit().create(PayChatService.class);
    }

    public static PayChatRepository providePayChatRepository() {
        return new PayChatRepositoryImpl(provideApiService());
    }


}
