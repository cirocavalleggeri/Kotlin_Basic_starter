package org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class ButtonActivity : AppCompatActivity() {
    private lateinit var bottoneVero:Button
    private lateinit var bottoneFalso:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button)
        bottoneVero=findViewById(R.id.id_btn_vero)
        bottoneFalso=findViewById(R.id.id_btn_falso)
        bottoneVero.setOnClickListener{view: View ->
            //fai qualcosa
            Toast.makeText(this,R.string.corretto,Toast.LENGTH_LONG).show()
        }
        bottoneFalso.setOnClickListener{

            view:View->//fai qualcosa
            Toast.makeText(this,R.string.non_corretto,Toast.LENGTH_LONG).show()
        }


    }
}


