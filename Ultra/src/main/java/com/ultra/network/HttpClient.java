package com.ultra.network;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

import okhttp3.Authenticator;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.CertificatePinner;
import okhttp3.ConnectionPool;
import okhttp3.ConnectionSpec;
import okhttp3.CookieJar;
import okhttp3.Dispatcher;
import okhttp3.Dns;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;

public final class HttpClient {
    private final Retrofit retrofit;

    private HttpClient(Retrofit.Builder retrofitBuilder, OkHttpClient.Builder okHttpClientBuilder) {
        retrofit = retrofitBuilder.client(okHttpClientBuilder.build()).build();
    }

    public Retrofit getRetrofit() {
        if (retrofit == null) {
            new NullPointerException("retrofit is null,Please configure HttpClient!");
        }
        return retrofit;
    }

    public <T> T create(final Class<T> service) {
        return retrofit.create(service);
    }

    public static final class Builder {
        private final Retrofit.Builder retrofitBuilder;
        private final OkHttpClient.Builder okHttpClientBuilder;

        public Builder() {
            retrofitBuilder = new Retrofit.Builder();
            okHttpClientBuilder = new OkHttpClient.Builder();
        }

        public Builder authenticator(Authenticator authenticator) {
            okHttpClientBuilder.authenticator(authenticator);
            return this;
        }

        public Builder addNetworkInterceptor(Interceptor interceptor) {
            okHttpClientBuilder.addNetworkInterceptor(interceptor);
            return this;
        }

        public Builder addInterceptor(Interceptor interceptor) {
            okHttpClientBuilder.addInterceptor(interceptor);
            return this;
        }

        public Builder cache(Cache cache) {
            okHttpClientBuilder.cache(cache);
            return this;
        }

        public Builder cookieJar(CookieJar cookieJar) {
            okHttpClientBuilder.cookieJar(cookieJar);
            return this;
        }

        public Builder connectTimeout(long timeout, TimeUnit unit) {
            if (timeout > 0) {
                okHttpClientBuilder.connectTimeout(timeout, unit);
            }
            return this;
        }

        public Builder connectionPool(ConnectionPool connectionPool) {
            okHttpClientBuilder.connectionPool(connectionPool);
            return this;
        }

        public Builder certificatePinner(CertificatePinner certificatePinner) {
            okHttpClientBuilder.certificatePinner(certificatePinner);
            return this;
        }

        public Builder connectionSpecs(List<ConnectionSpec> connectionSpecs) {
            okHttpClientBuilder.connectionSpecs(connectionSpecs);
            return this;
        }

        public Builder dns(Dns dns) {
            okHttpClientBuilder.dns(dns);
            return this;
        }

        public Builder dispatcher(Dispatcher dispatcher) {
            okHttpClientBuilder.dispatcher(dispatcher);
            return this;
        }

        public Builder followRedirects(boolean followRedirects) {
            okHttpClientBuilder.followRedirects(followRedirects);
            return this;
        }

        public Builder followSslRedirects(boolean followProtocolRedirects) {
            okHttpClientBuilder.followSslRedirects(followProtocolRedirects);
            return this;
        }

        public Builder hostnameVerifier(HostnameVerifier hostnameVerifier) {
            okHttpClientBuilder.hostnameVerifier(hostnameVerifier);
            return this;
        }

        public Builder proxySelector(ProxySelector proxySelector) {
            okHttpClientBuilder.proxySelector(proxySelector);
            return this;
        }

        public Builder proxy(Proxy proxy) {
            okHttpClientBuilder.proxy(proxy);
            return this;
        }

        public Builder protocols(List<Protocol> protocols) {
            okHttpClientBuilder.protocols(protocols);
            return this;
        }

        public Builder proxyAuthenticator(Authenticator proxyAuthenticator) {
            okHttpClientBuilder.proxyAuthenticator(proxyAuthenticator);
            return this;
        }

        public Builder retryOnConnectionFailure(boolean retryOnConnectionFailure) {
            okHttpClientBuilder.retryOnConnectionFailure(retryOnConnectionFailure);
            return this;
        }

        public Builder readTimeout(long timeout, TimeUnit unit) {
            if (timeout > 0) {
                okHttpClientBuilder.readTimeout(timeout, unit);
            }
            return this;
        }

        /**
         * @deprecated
         */
        public Builder sslSocketFactory(SSLSocketFactory sslSocketFactory) {
            okHttpClientBuilder.sslSocketFactory(sslSocketFactory);
            return this;
        }

        public Builder sslSocketFactory(
                SSLSocketFactory sslSocketFactory, X509TrustManager trustManager) {
            okHttpClientBuilder.sslSocketFactory(sslSocketFactory, trustManager);
            return this;
        }

        public Builder writeTimeout(long timeout, TimeUnit unit) {
            if (timeout > 0) {
                okHttpClientBuilder.writeTimeout(timeout, unit);
            }
            return this;
        }

        public Builder baseUrl(String baseUrl) {
            retrofitBuilder.baseUrl(baseUrl);
            return this;
        }

        public Builder baseUrl(HttpUrl baseUrl) {
            retrofitBuilder.baseUrl(baseUrl);
            return this;
        }

        public Builder callbackExecutor(Executor executor) {
            retrofitBuilder.callbackExecutor(executor);
            return this;
        }

        public Builder callFactory(Call.Factory callFactory) {
            retrofitBuilder.callFactory(callFactory);
            return this;
        }

        public Builder validateEagerly(boolean validateEagerly) {
            retrofitBuilder.validateEagerly(validateEagerly);
            return this;
        }

        public Builder addConverterFactory(Converter.Factory converterFactory) {
            retrofitBuilder.addConverterFactory(converterFactory);
            return this;
        }

        public Builder addCallAdapterFactory(CallAdapter.Factory callFactory) {
            retrofitBuilder.addCallAdapterFactory(callFactory);
            return this;
        }

        public HttpClient build() {
            return new HttpClient(retrofitBuilder, okHttpClientBuilder);
        }

    }
}
