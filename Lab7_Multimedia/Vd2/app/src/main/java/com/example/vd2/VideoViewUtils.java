package com.example.vd2;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;
import android.widget.VideoView;

public class VideoViewUtils {
    public static final String RAW_VIDEO_SAMPLE = "myvideo";
    public static final String LOCAL_VIDEO_SAMPLE ="/storage/emulated/0/DCIM/Camera/VID_20180212_195520.mp4";
    public static final String URL_VIDEO_SAMPLE  = "https://youtu.be/Q6fstmL3HF0?list=RDQ6fstmL3HF0&t=63";
    public static final String LOG_TAG= "AndroidVideoView";
    public static void playRawVideo(Context context, VideoView videoView, String resName)  {
        try {
            int id = VideoViewUtils.getRawResIdByName( context, resName);
            Uri uri = Uri.parse("android.resource://" + context.getPackageName() + "/" + id);
            Log.i(LOG_TAG, "Video URI: "+ uri);
            videoView.setVideoURI(uri);
            videoView.requestFocus();
        } catch (Exception e) {
            Log.e(LOG_TAG, "Error Play Raw Video: "+e.getMessage());
            Toast.makeText(context,"Error Play Raw Video: "+ e.getMessage(),Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
    public static void playLocalVideo(Context context, VideoView videoView, String localPath)  {
        try {
        } catch(Exception e) {
            Log.e(LOG_TAG, "Error Play Local Video: "+ e.getMessage());
            Toast.makeText(context,"Error Play Local Video: "+ e.getMessage(),Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
    public static void playURLVideo(Context context, VideoView videoView, String videoURL)  {
        try {
            Log.i(LOG_TAG, "Video URL: "+ videoURL);
            Uri uri= Uri.parse( videoURL );
            videoView.setVideoURI(uri);
            videoView.requestFocus();
        } catch(Exception e) {
            Log.e(LOG_TAG, "Error Play URL Video: "+ e.getMessage());
            Toast.makeText(context,"Error Play URL Video: "+ e.getMessage(),Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
    public static int getRawResIdByName(Context context, String resName) {
        String pkgName = context.getPackageName();
        int resID = context.getResources().getIdentifier(resName, "raw", pkgName);
        Log.i(LOG_TAG, "Res Name: " + resName + "==> Res ID = " + resID);
        return resID;
    }

}
