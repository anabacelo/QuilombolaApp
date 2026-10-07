package com.example.anapaula.quilombolaappv4.ui.navigation;

import android.graphics.Bitmap;
import android.graphics.pdf.PdfRenderer;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.anapaula.quilombolaappv4.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class NavVisualizarPdf extends Fragment {

    private ImageView imagePdf;

    private PdfRenderer pdfRenderer;
    private PdfRenderer.Page paginaAtual;
    private ParcelFileDescriptor parcelFileDescriptor;

    private int numeroPagina = 0;
    private String nomePdf;

    public NavVisualizarPdf() {
        // Construtor obrigatório
    }

    public static NavVisualizarPdf newInstance(String nomePdf) {
        NavVisualizarPdf fragment = new NavVisualizarPdf();

        Bundle args = new Bundle();
        args.putString("nome_pdf", nomePdf);
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.nav_visualizar_pdf, container, false);

        imagePdf = view.findViewById(R.id.imagePdf);

        Button btnPaginaAnterior = view.findViewById(R.id.btnPaginaAnterior);
        Button btnProximaPagina = view.findViewById(R.id.btnProximaPagina);

        btnPaginaAnterior.setOnClickListener(v -> paginaAnterior());
        btnProximaPagina.setOnClickListener(v -> proximaPagina());

        if (getArguments() != null) {
            nomePdf = getArguments().getString("nome_pdf");
        }

        abrirPdf();

        return view;
    }

    private void abrirPdf() {

        try {
            File arquivoPdf = copiarPdfParaCache(nomePdf);

            parcelFileDescriptor = ParcelFileDescriptor.open(
                    arquivoPdf,
                    ParcelFileDescriptor.MODE_READ_ONLY
            );

            pdfRenderer = new PdfRenderer(parcelFileDescriptor);

            mostrarPagina(numeroPagina);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private File copiarPdfParaCache(String nomeArquivo) throws IOException {

        File arquivoDestino = new File(
                requireContext().getCacheDir(),
                nomeArquivo
        );

        if (!arquivoDestino.exists()) {

            InputStream inputStream = requireContext()
                    .getAssets()
                    .open("www/cartilhas/" + nomeArquivo);

            FileOutputStream outputStream =
                    new FileOutputStream(arquivoDestino);

            byte[] buffer = new byte[4096];
            int tamanho;

            while ((tamanho = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, tamanho);
            }

            outputStream.close();
            inputStream.close();
        }

        return arquivoDestino;
    }

    private void mostrarPagina(int numero) {

        if (pdfRenderer == null) {
            return;
        }

        if (paginaAtual != null) {
            paginaAtual.close();
        }

        paginaAtual = pdfRenderer.openPage(numero);

        Bitmap bitmap = Bitmap.createBitmap(
                paginaAtual.getWidth(),
                paginaAtual.getHeight(),
                Bitmap.Config.ARGB_8888
        );

        paginaAtual.render(
                bitmap,
                null,
                null,
                PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY
        );

        imagePdf.setImageBitmap(bitmap);
    }

    public void proximaPagina() {

        if (pdfRenderer != null &&
                numeroPagina < pdfRenderer.getPageCount() - 1) {

            numeroPagina++;
            mostrarPagina(numeroPagina);
        }
    }

    public void paginaAnterior() {

        if (pdfRenderer != null &&
                numeroPagina > 0) {

            numeroPagina--;
            mostrarPagina(numeroPagina);
        }
    }

    @Override
    public void onDestroyView() {

        try {

            if (paginaAtual != null) {
                paginaAtual.close();
            }

            if (pdfRenderer != null) {
                pdfRenderer.close();
            }

            if (parcelFileDescriptor != null) {
                parcelFileDescriptor.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        super.onDestroyView();
    }
}