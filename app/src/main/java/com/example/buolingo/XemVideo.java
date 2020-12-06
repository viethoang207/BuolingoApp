package com.example.buolingo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.buolingo.Model.ChuDeVideo;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.io.IOException;
import java.io.InputStream;

public class XemVideo extends AppCompatActivity {
    YouTubePlayerView youTubePlayerView;
    TextView tvLyThuyet,tvChuDe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xem_video);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Init();


        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = DanhSachVideo.cd.getIdYoutube();
                youTubePlayer.loadVideo(videoId, 0);
            }
        });

        tvChuDe.setText("CHỦ ĐỀ : "+DanhSachVideo.cd.getTenChuDeVideo());

        loadFile(DanhSachVideo.cd.getFileLyThuyet());
    }



    private void Init() {
        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player_view);
        tvLyThuyet = (TextView) findViewById(R.id.XemVideo_tvLyThuyet);
        tvChuDe = (TextView) findViewById(R.id.XemVideo_tvChuDe);
    }

    private void loadFile(String fileName) {
        String text ="";

        try {
            InputStream is = getAssets().open(fileName);
            int sizes = is.available();
            byte[] buffer = new byte[sizes];
            is.read(buffer);
            is.close();
            text = new String(buffer);

        } catch (IOException e) {
            e.printStackTrace();
        }

        tvLyThuyet.setText(text);
    }
}