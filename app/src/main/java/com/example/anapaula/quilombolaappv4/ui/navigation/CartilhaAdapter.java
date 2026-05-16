package com.example.anapaula.quilombolaappv4.ui.navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.anapaula.quilombolaappv4.R;

import java.util.List;

public class CartilhaAdapter extends RecyclerView.Adapter<CartilhaAdapter.ViewHolder> {

    private final List<String> titulos;
    private final List<String> textos;
    private final List<Integer> imagens;

    public CartilhaAdapter(List<String> titulos,
                           List<String> textos,
                           List<Integer> imagens) {

        this.titulos = titulos;
        this.textos = textos;
        this.imagens = imagens;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView titulo;
        TextView texto;
        ImageView imagem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.tituloCartilha);
            texto = itemView.findViewById(R.id.textoCartilha);
            imagem = itemView.findViewById(R.id.imagemCartilha);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.page_cartilha_sb, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.titulo.setText(titulos.get(position));
        holder.texto.setText(textos.get(position));
        holder.imagem.setImageResource(imagens.get(position));
    }

    @Override
    public int getItemCount() {
        return titulos.size();
    }
}
