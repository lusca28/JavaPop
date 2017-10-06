package br.com.alcheno.javapop.config;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by lusca on 06/10/2017.
 */

public interface GitHubInterface {

    @GET("search/repositories?q=language:Java&sort=stars&page=1")
    Call<GitHubResponse> getJavaPopRepositories();
}
