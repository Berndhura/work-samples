package com.example.guitest;

import android.os.Bundle;
import android.util.Log;

import com.example.guitest.data.Data;
import com.example.guitest.data.Employee;

import java.util.LinkedList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private HttpService httpService;
    private RecyclerView mRecyclerView;
    private PeopleAdapter mAdapter;
    private LinkedList<String> mWordList = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        httpService = new HttpService();

        getData();

        buildRecyclerView();
    }

    private void buildRecyclerView() {
        // Get a handle to the RecyclerView.
        mRecyclerView = findViewById(R.id.recyclerview);
        // Create an adapter and supply the data to be displayed.
        mAdapter = new PeopleAdapter(this, mWordList);
        // Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
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
                            mWordList.add(data.getEmployee_name());
                            Log.d("CONAN", "Name: " + data.getEmployee_name());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        int i = 0;
                    }

                    @Override
                    public void onComplete() {
                        Log.d("CONAN", "onComplete!!!!");
                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {

                                mRecyclerView.getAdapter().notifyDataSetChanged();

                            }
                        });
                    }
                });
    }
}