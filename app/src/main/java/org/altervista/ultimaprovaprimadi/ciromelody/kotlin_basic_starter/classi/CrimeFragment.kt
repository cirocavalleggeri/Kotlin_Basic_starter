package org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.classi

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.AndroidBasicsStarter
import org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.R


class CrimeFragment: Fragment() {

    private lateinit var crime:Crime
    private lateinit var titleField:EditText
    private lateinit var dateButton:Button
    private lateinit var solvedCheckBox: CheckBox
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        crime=Crime()
       // Toast.makeText(AndroidBasicsStarter.class,"onCreate in Fragment è pubblico",Toast.LENGTH_LONG).show()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =inflater.inflate(R.layout.fragment_crime,container,false)
        titleField =view.findViewById(R.id.crime_title) as EditText
        dateButton=view.findViewById(R.id.crime_date)
        solvedCheckBox=view.findViewById(R.id.crime_solved)
        dateButton.apply {
            text=crime.date.toString()
            isEnabled=false
        }
        solvedCheckBox.apply {
            setOnCheckedChangeListener { _,isChecked ->
                crime.isSolved=isChecked
            }
        }

          return view
    }

    override fun onStart(){
        super.onStart()
        val titleWhatcher=object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, start: Int, count: Int, after: Int) {
                //non fare niente
            }

            override fun onTextChanged(sequence: CharSequence?,start: Int, count: Int, after: Int) {


                crime.title=sequence.toString()
            }

            override fun afterTextChanged(p0: Editable?) {
                //non fare niente
            }

        }
        //aggiungiamo un listner a titleWhatcher
        titleField.addTextChangedListener(titleWhatcher)

    }


}