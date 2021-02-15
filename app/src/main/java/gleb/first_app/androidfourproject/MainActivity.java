package gleb.first_app.androidfourproject;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private BluerImageView blur_img;
    private ImageButton play, stop;
    private MediaPlayer audio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        blur_img = findViewById(R.id.blur_img);
        blur_img.setBlur(0.5);
        play = findById(R.id.playBtn);
        stop = findById(R.id.stopBtn);

    }
    public void OnClickBtn(View view){
        switch(view.getId()){
            case R.id.playBtn:
                if(audio == null){
                    audio= MediaPlayer.create(getApplicationContext(), R.raw.music);
                    audio.start();
                    play.setImageResource(R.drawable.pause);
                }else if(audio.isPlaying()){
                    audio.pause();
                    pausePos = audio.getCurrentPosition();
                    play.setImageResource(R.drawable.play);
                }else if(!audio.isPlaying()){
                    audio.seekTo(pausePost);
                    audio.start();
                    play.setImageResource(R.drawable.pause);
                }
                break;
            case R.id.stopBtn:
                if(audio != null){
                    audio.stop();
                    audio = null;
                    play.setImageResource(R.drawable.play);
                }

                break;
        }
    }
}