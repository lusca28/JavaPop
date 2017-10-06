package br.com.alcheno.javapop;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import br.com.alcheno.javapop.model.Dados;

/**
 * Created by lusca on 06/10/2017.
 */

public class JavaPopAdapter extends RecyclerView.Adapter<JavaPopAdapter.JavaPopViewHolder> {

    private List<Dados> mListDados;

    public JavaPopAdapter(List<Dados> listDados) {
        this.mListDados = listDados;
    }

    @Override
    public JavaPopViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.dados_item, parent, false);
        return new JavaPopViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(JavaPopViewHolder holder, int position) {
        Dados dados = (Dados) mListDados.toArray()[position];

        if(dados != null){
            holder.mRepoName.setText(dados.getName());

            ImageLoader imageLoader = ImageLoader.getInstance();
            imageLoader.displayImage(dados.getOwner().getAvatarUrl(), holder.mAvatar);

            holder.mDescricao.setText(dados.getDescription());
            holder.mAvatarName.setText(dados.getOwner().getLogin());
            holder.mForks.setText(String.valueOf(dados.getForks()));
            holder.mStars.setText(String.valueOf(dados.getStars()));
        }
    }

    @Override
    public int getItemCount() {
        return mListDados.size();
    }

    //viewholder
    public class JavaPopViewHolder extends RecyclerView.ViewHolder {
        public TextView mRepoName, mDescricao, mForks, mStars, mAvatarName, mAvatarFullName;
        public ImageView mAvatar;

        public JavaPopViewHolder(View itemView) {
            super(itemView);
            mRepoName = (TextView) itemView.findViewById(R.id.repo_name);
            mDescricao = (TextView) itemView.findViewById(R.id.descricao);
            mForks = (TextView) itemView.findViewById(R.id.forks);
            mStars = (TextView) itemView.findViewById(R.id.stars);
            mAvatarName = (TextView) itemView.findViewById(R.id.avatar_name);
            mAvatarFullName = (TextView) itemView.findViewById(R.id.avatar_full_name);
            mAvatar = (ImageView) itemView.findViewById(R.id.avatar);
        }
    }
}
