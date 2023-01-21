package org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.cap12

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
import androidx.lifecycle.ViewModelProviders
import com.bignerdranch.android.criminalintent.CrimeDetailViewModel
import org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.AndroidBasicsStarter
import org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.R
import org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.cap12.Crime
import java.util.*

private const val TAG = "CrimeFragment"
private const val ARG_CRIME_ID = "crime_id"

class CrimeFragmentCap12: Fragment() {

    private lateinit var crime:Crime
    private lateinit var titleField:EditText
    private lateinit var dateButton:Button
    private lateinit var solvedCheckBox: CheckBox
    private val crimeDetailViewModelCap12: CrimeDetailViewModelCap12 by lazy {
        ViewModelProviders.of(this).get(CrimeDetailViewModelCap12::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        crime= Crime()
       // Toast.makeText(AndroidBasicsStarter.class,"onCreate in Fragment è pubblico",Toast.LENGTH_LONG).show()
        val crimeId: UUID = arguments?.getSerializable(ARG_CRIME_ID) as UUID

        crimeDetailViewModelCap12.loadCrime(crimeId)

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
    companion object {

        fun newInstance(crimeId: UUID): CrimeFragmentCap12 {
            val args = Bundle().apply {
                putSerializable(ARG_CRIME_ID, crimeId)
            }
            return CrimeFragmentCap12().apply {
                arguments = args
            }
        }
    }

}