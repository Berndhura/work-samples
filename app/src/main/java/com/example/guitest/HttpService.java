package com.example.guitest;

import com.example.guitest.data.Employee;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class HttpService {

    private final WebService mWebService;

    private static final String WEB_SERVICE_BASE_URL = "http://dummy.restapiexample.com/api/v1/";

    public HttpService() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();

        okHttpBuilder.addInterceptor(logging);

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(WEB_SERVICE_BASE_URL)
                .client(okHttpBuilder.build());

        Retrofit restAdapter = retrofitBuilder.build();

        mWebService = restAdapter.create(WebService.class);
    }

    private interface WebService {

        /* GET /employees
        response:
        {
        "status": "success",
        "data": [
            {
            "id": "1",
            "employee_name": "Tiger Nixon",
            "employee_salary": "320800",
            "employee_age": "61",
            "profile_image": ""
            },
            ....
            ]
         }*/
        @GET("employees")
        Observable<Employee> getEmployees();
    }

    public Observable<Employee> getEmployeesObservable() {
        return mWebService.getEmployees();
    }
}
