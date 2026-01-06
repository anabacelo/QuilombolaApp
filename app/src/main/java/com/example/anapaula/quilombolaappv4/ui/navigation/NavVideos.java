package com.example.anapaula.quilombolaappv4.ui.navigation;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.google.android.material.button.MaterialButton;

import com.example.anapaula.quilombolaappv4.R;
import com.example.anapaula.quilombolaappv4.VideoPlayerActivity;

import java.util.ArrayList;
import java.util.List;

public class NavVideos extends Fragment {

    public NavVideos() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nav_videos, container, false);
        LinearLayout containerVideos = view.findViewById(R.id.container_videos);

        // Definindo os vídeos manualmente para evitar pegar recursos internos do Android/ExoPlayer
        int[] rawVideos = {
            R.raw.videoplayback,
            R.raw.videoplayback2,
            R.raw.videoplayback3,
            R.raw.videoplayback4
        };

        String[] videoTitles = {
            "Vídeo Institucional 1",
            "Vídeo Institucional 2",
            "Vídeo Institucional 3",
            "Vídeo Institucional 4"
        };

        for (int i = 0; i < rawVideos.length; i++) {
            final int videoId = rawVideos[i];
            final String title = videoTitles[i];
            
            MaterialButton btn = new MaterialButton(getContext());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, 
                    ViewGroup.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(0, 10, 0, 10);
            btn.setLayoutParams(params);
            
            btn.setText(title);
            btn.setIconResource(android.R.drawable.ic_media_play);
            btn.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            btn.setTextColor(getResources().getColor(R.color.white));
            btn.setCornerRadius(20);
            
            btn.setOnClickListener(v -> {
                Intent intent = new Intent(getActivity(), VideoPlayerActivity.class);
                intent.putExtra("VIDEO_RES_ID", videoId);
                startActivity(intent);
            });
            containerVideos.addView(btn);
        }

        return view;
    }
}
