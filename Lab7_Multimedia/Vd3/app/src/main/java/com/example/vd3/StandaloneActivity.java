package com.example.vd3;

import  android . content . Intent ;
import  android . os . Bundle ;
import  android . view . View ;
import  android . widget . Button ;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.youtube.player.YouTubeStandalonePlayer ;
public   class   StandaloneActivity   extends AppCompatActivity implements  View. OnClickListener {
    private   String  GOOGLE_API_KEY  =   "AIzaSyCmwnhxS8T2h8qx6k6YtLXkdHBPi2f5b6I" ;
    private   String  YOUTUBE_VIDEO_ID  =   "rc7veCcQBvk" ;
    private   String  YOUTUBE_PLAYLIST_ID =   "PLT00Q_YHmZSdASYh7xJxEtGw0pV34v0sw" ; //key_list vd
    private   Button  btnPlayVideo ;
    private    Button  btnPlayplaylist ;
    @Override
    protected   void  onCreate ( Bundle  savedInstanceState )   {
        super . onCreate ( savedInstanceState );
        setContentView ( R . layout . activity_standalone );
// ánh xạ và lắng nghe các nút button khi click vào.
        btnPlayplaylist =   ( Button )  findViewById ( R . id . btnPlayList );
        btnPlayVideo =   ( Button )  findViewById ( R . id . btnVideo );
        btnPlayVideo . setOnClickListener ( this );
        btnPlayplaylist . setOnClickListener ( this );
    }
    @Override
    public   void  onClick ( View  v )   {
        Intent  intent =   null ;
        switch   ( v . getId ()){
            case  R . id . btnVideo : // khi click vào btnvideo màn hình sẽ phát video được chọn thông qua Key video
                intent  = YouTubeStandalonePlayer . createVideoIntent ( this , GOOGLE_API_KEY , YOUTUBE_VIDEO_ID ); // gọi hoạt động phát video
                break ;
            case  R . id . btnPlayList :// khi click vào btnplaylist màn hình sẽ phát list video được chọn thông qua Key list
                intent  = YouTubeStandalonePlayer . createPlaylistIntent ( this , GOOGLE_API_KEY , YOUTUBE_PLAYLIST_ID );// gọi hoạt động phát list video
                break ;
            default :
        }
        if ( intent !=   null ){
            startActivity ( intent );
        }
    }
}
