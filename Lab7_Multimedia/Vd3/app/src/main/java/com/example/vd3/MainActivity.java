package com.example.vd3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public   class   MainActivity   extends AppCompatActivity implements   View.OnClickListener {
    private Button btnSingle ;
    private    Button  btnNext ;
    @Override
    protected   void  onCreate ( Bundle  savedInstanceState )   {
        super . onCreate ( savedInstanceState );
        setContentView ( R . layout . activity_main );
        btnSingle  =   ( Button )  findViewById ( R . id . btnVideo );
        btnNext =   ( Button )  findViewById ( R . id . next );
        btnSingle . setOnClickListener ( this );
        btnNext . setOnClickListener ( this );
    }        @Override
    public   void  onClick ( View  v )   {
        Intent  intent =   null ;
        switch   ( v . getId ()){
            case  R . id . btnVideo :  // khi click btnvideo sẽ gọi class YoutubeActivity
                intent  =   new Intent(( MainActivity . this ),   YoutubeActivity . class );
                break ;
            case  R . id . next :// khi click next sẽ gọi class StandaloneActivity
                intent  =   new   Intent (( MainActivity . this )   ,   StandaloneActivity . class );
                break ;
            default :
        }
        if ( intent !=   null ){
            startActivity ( intent );
        }
    }
}
