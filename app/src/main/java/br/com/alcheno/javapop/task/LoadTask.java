package br.com.alcheno.javapop.task;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;

import java.io.IOException;

import br.com.alcheno.javapop.R;
import br.com.alcheno.javapop.config.GitHubInterface;
import br.com.alcheno.javapop.config.GitHubResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lusca on 06/10/2017.
 */

public class LoadTask extends AsyncTask {

    private Activity mActivity;
    private ProgressDialog dialog;
    private LoadInterface mLoadInterface;

    public LoadTask(Activity activity, LoadInterface loadInterface){
        mActivity = activity;
        mLoadInterface = loadInterface;
        dialog = new ProgressDialog(mActivity);
    }

    @Override
    protected void onPreExecute() {
        dialog.setMessage("Procurando repositórios...");
        dialog.show();
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(mActivity.getString(R.string.url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GitHubInterface gitHubInterface = retrofit.create(GitHubInterface.class);
        Call<GitHubResponse> call = gitHubInterface.getJavaPopRepositories();
        call.enqueue(new Callback<GitHubResponse>() {
            @Override
            public void onResponse(Call<GitHubResponse> call, Response<GitHubResponse> response) {
                if(response.isSuccessful()){
                    dialog.dismiss();
                    mLoadInterface.onLoadTaskCompleted(response.body().getItems());
                } else {
                    dialog.dismiss();
                    mLoadInterface.onLoadTaskFailed("Não foi possível procurar repositórios, tente novamente mais tarde.");
                }
            }

            @Override
            public void onFailure(Call<GitHubResponse> call, Throwable t) {
                if(t instanceof IOException){
                    mLoadInterface.onLoadTaskFailed("Falha na conexão ao servidor, verifique sua conexão com a Internet.");
                } else {
                    mLoadInterface.onLoadTaskFailed("Há algo de errado, tente novamente mais tarde.");
                }
                dialog.dismiss();
            }
        });
        return null;
    }
}
