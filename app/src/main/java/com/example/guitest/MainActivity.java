package com.example.guitest;

import android.os.Bundle;
import android.util.Log;

import com.example.guitest.data.Data;
import com.example.guitest.data.Employee;

import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private HttpService httpService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        httpService = new HttpService();

        getData();
    }

    private void getData() {

        httpService.getEmployeesObservable()
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Employee>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Employee value) {

                        for (Data data : value.getData()) {
                            Log.d("CONAN", "Name: " + data.getEmployee_name());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        int i = 0;
                    }

                    @Override
                    public void onComplete() {
                        int i = 0;
                    }
                });
    }
}