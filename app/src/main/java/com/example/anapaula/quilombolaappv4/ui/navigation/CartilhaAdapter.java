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

    List<String> titulos;
    List<String> textos;

    public CartilhaAdapter(List<String> titulos, List<String> textos) {
        this.titulos = titulos;
        this.textos = textos;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView titulo, texto;
        ImageView imagem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.tituloPagina);
            texto = itemView.findViewById(R.id.textoPagina);
            imagem = itemView.findViewById(R.id.imagemPagina);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.page_cartilha, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.titulo.setText(titulos.get(position));
        holder.texto.setText(textos.get(position));

        // imagem opcional por enquanto
        holder.imagem.setImageResource(R.mipmap.quilombola_icon);
    }

    @Override
    public int getItemCount() {
        return titulos.size();
    }
}
