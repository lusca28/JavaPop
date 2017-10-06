package br.com.alcheno.javapop.config;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import br.com.alcheno.javapop.model.Dados;

/**
 * Created by lusca on 06/10/2017.
 */

public class GitHubResponse {

    @SerializedName("total_count")
    private int totalCount;

    @SerializedName("incomplete_results")
    private boolean incompleteResults;

    @SerializedName("items")
    private List<Dados> items;

    public GitHubResponse() {}

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public boolean isIncompleteResults() {
        return incompleteResults;
    }

    public void setIncompleteResults(boolean incompleteResults) {
        this.incompleteResults = incompleteResults;
    }

    public List<Dados> getItems() {
        return items;
    }

    public void setItems(List<Dados> items) {
        this.items = items;
    }
}
