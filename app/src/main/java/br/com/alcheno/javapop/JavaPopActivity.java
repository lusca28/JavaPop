package br.com.alcheno.javapop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;
import java.util.List;

import br.com.alcheno.javapop.model.Dados;
import br.com.alcheno.javapop.task.LoadInterface;
import br.com.alcheno.javapop.task.LoadTask;

public class JavaPopActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private JavaPopAdapter mJavaPopAdapter;
    private LinearLayoutManager mLayoutManager;
    private List<Dados> mDadosList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_pop);

        //universal image
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(config);

        //componentes
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        LoadInterface loadInterface = new LoadInterface() {
            @Override
            public void onLoadTaskCompleted(List<Dados> dadosList) {
                mDadosList = dadosList;
                mJavaPopAdapter = new JavaPopAdapter(mDadosList);
                mRecyclerView.setAdapter(mJavaPopAdapter);
            }

            @Override
            public void onLoadTaskFailed(String message) {

            }
        };
        LoadTask service = new LoadTask(JavaPopActivity.this, loadInterface);
        service.execute();
    }
}
