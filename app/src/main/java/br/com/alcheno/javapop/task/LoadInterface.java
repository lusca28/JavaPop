package br.com.alcheno.javapop.task;

import java.util.List;

import br.com.alcheno.javapop.model.Dados;

/**
 * Created by lusca on 06/10/2017.
 */

public interface LoadInterface {
    void onLoadTaskCompleted(List<Dados> dadosList);
    void onLoadTaskFailed(String message);
}
