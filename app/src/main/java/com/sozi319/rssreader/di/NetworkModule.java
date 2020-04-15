package com.sozi319.rssreader.di;

import com.sozi319.rssreader.rssfeed.rssitem.api.NewsYandexService;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

@Module
public class NetworkModule {

    @Provides
    static NewsYandexService provideNewsYandexService(Retrofit retrofit) {
        return retrofit.create(NewsYandexService.class);
    }

    @Provides
    static Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl("https://news.yandex.ru/")
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    static OkHttpClient provideOkHttpClient(HttpLoggingInterceptor loggingInterceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();
    }

    @Provides
    static HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        return new HttpLoggingInterceptor();
    }
}
