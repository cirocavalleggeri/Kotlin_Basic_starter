package org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.capitolo2

import android.content.Context
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.R
import org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.capitolo2.Question
import org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.capitolo2.Utility

class Android_and_ModelView_Controller_capitolo_2 : AppCompatActivity() {
    private val TAG="KOT"
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var  nextButton: Button
    private lateinit var  sxButton: Button
    private lateinit var  nextButton_vettore_dx: Button
    private lateinit var  testoDomanda: TextView
    private  val questionBank= listOf(
        Question(R.string.domanda_mideast,true),
        Question(R.string.domanda_africa,true),
        Question(R.string.domanda_oceani,true),
        Question(R.string.domanda_americhe,false),
        Question(R.string.domanda_mideast,true),
        Question(R.string.domanda_oceano_indiano,false)

    )
    private var currentIndex=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("KOT","fun onCreate()")
        setContentView(R.layout.activity_android_and__model_view__controller)
        sxButton=findViewById(R.id.bn_vettore_sx)
        nextButton=findViewById(R.id.bn_next)
         nextButton_vettore_dx = findViewById(R.id.bn_vettore_dx)
        trueButton=findViewById(R.id.bn_vero_cap2)
        falseButton=findViewById(R.id.bn_falso_cap2)
        testoDomanda=findViewById(R.id.tx_titolo_quiz_cap2)
        trueButton.setOnClickListener {
                view: View? ->  //visualizza_il_dato_ricevuto(R.string.correct_toast.toString())
                checkAnswer(true)
        }
        falseButton.setOnClickListener {
                view: View? ->  //visualizza_il_dato_ricevuto(R.string.incorrect_toast.toString())
                checkAnswer(false)

        }
        sxButton.setOnClickListener {view:View-> vai_a_domandaPrecedente()
        }
        nextButton.setOnClickListener {view:View-> vai_a_prossimaDomanda()
        }
        nextButton_vettore_dx.setOnClickListener {view:View-> vai_a_prossimaDomanda()
        }
        val questionTextREsId=questionBank[currentIndex].textResId
            testoDomanda.setText(questionTextREsId)
        val profileName=intent.getStringExtra("Orientamento")
        if(profileName=="Landscape"){
            visualizza_il_dato_ricevuto(profileName)
            ruota_il_dispositivo()}
      }


    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() called")
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        Log.d("KOT","onSaveInstanceState called")

    }

    override fun isChangingConfigurations(): Boolean {
        Log.d("KOT","Change configuration")
        return super.isChangingConfigurations()
    }

    private fun ruota_il_dispositivo() {
        ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
    }

    private fun vai_a_domandaPrecedente() {
        if(currentIndex==0){currentIndex=1}
        currentIndex=(currentIndex-1)%questionBank.size
        Log.i("KOT","Indice corrente precedente:"+currentIndex.toString())
        val questionTextREsId=questionBank[currentIndex].textResId
        testoDomanda.setText(questionTextREsId)

    }

    private fun checkAnswer(bool:Boolean) {
        if(questionBank[currentIndex].answer==bool){visualizza_il_dato_ricevuto("Bravo!")} else{
            visualizza_il_dato_ricevuto("Sbagliato!")                }
    }

    private fun vai_a_prossimaDomanda() {
        Log.i("KOT",questionBank.size.toString())

        currentIndex=(currentIndex+1)%questionBank.size
        Log.i("KOT","Indice corrente:"+currentIndex.toString())
        val questionTextREsId=questionBank[currentIndex].textResId
        testoDomanda.setText(questionTextREsId)
    }

    private fun visualizza_il_dato_ricevuto(profileName: String?) {

        var toast = Toast.makeText(
            this,
            profileName,
            Toast.LENGTH_SHORT
        )
        toast.setGravity(Gravity.TOP or Gravity.RIGHT, 21, 34)
        toast.show()
    }

}