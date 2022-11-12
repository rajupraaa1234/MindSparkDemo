package com.example.mindsparkdemo.Utility;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.util.Log;


public class AudioSound {
    static Boolean isPlaying = false, isStreaming = false;
    private MediaPlayer mediaPlayer;

    public void startAudioStream(String url) {
        if (mediaPlayer == null)
            mediaPlayer = new MediaPlayer();
        try {
            Log.d("mylog", "Playing: " + url);
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setDataSource(url);
            //descriptor.close();
            mediaPlayer.prepare();
            mediaPlayer.setVolume(1f, 1f);
            mediaPlayer.setLooping(false);
            mediaPlayer.start();
        } catch (Exception e) {
            Log.d("mylog", "Error playing in SoundHandler: " + e.toString());
        }
    }

    public void stopPlaying() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = new MediaPlayer();
            mediaPlayer.reset();
        }
    }



}
