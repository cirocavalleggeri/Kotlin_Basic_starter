package org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.cap12


import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.R
import org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.cap12.Crime
import org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.classi.Utility
import java.util.*
import androidx.lifecycle.Observer


private const val TAG="CrimeListFragmentCap12"

class CrimeListFragmentCap12: Fragment() {

private lateinit var crimeRecyclerView: RecyclerView
private var adapter: CrimeAdapter? = null
private lateinit var mostraToast: Utility
    val crimeListViewModelCap12: CrimeListViewModelCap12 by lazy { ViewModelProviders.of(this).get(CrimeListViewModelCap12::class.java) }

    interface Callbacks {
        fun onCrimeSelected(crimeId: UUID)
    }

    private var callbacks: Callbacks? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Log.d(TAG,"Crimini totali :${crimeListViewModelCap12.crimeListLiveData}")


    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        callbacks = context as Callbacks?
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //return super.onCreateView(inflater, container, savedInstanceState)
        val view =inflater.inflate(R.layout.fragment_crime_list,container,false)
        crimeRecyclerView=view.findViewById(R.id.id_crime_recycler_view) as RecyclerView
       crimeRecyclerView.layoutManager=LinearLayoutManager(context)

        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        crimeListViewModelCap12.crimeListLiveData.observe(
            viewLifecycleOwner,
            Observer { crimes ->
                crimes?.let {
                    Log.i(TAG, "Got crimes ${crimes.size}")

                    //updateUI(crimes)

                }
            })

    }

    override fun onDetach() {
        super.onDetach()
        callbacks = null
    }


    private fun updateUI(crimes: List<Crime>) {

        adapter = CrimeAdapter(crimes)
        crimeRecyclerView.adapter = adapter
    }
    private inner class  CrimeHolder(view:View):RecyclerView.ViewHolder(view),View.OnClickListener{


        lateinit var crime: Crime

        fun bind(crime: Crime) {
            this.crime=crime
            titleTextView.text=crime.title
            dateTextView.text=crime.date.toString()

             manette.visibility=if(crime.isSolved){View.GONE}else{View.VISIBLE}
                Log.d(TAG,"manette "+crime.isSolved)


            Log.d(TAG,"CrimeHolder->"+crime.title)
        }

        val titleTextView:TextView=itemView.findViewById(R.id.crime_title)
         val dateTextView:TextView=itemView.findViewById(R.id.crime_date    )
         val  manette:ImageView=itemView.findViewById(R.id.id_imageView2)


        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            Toast.makeText(context,"${crime.title} premuto",Toast.LENGTH_LONG).show()
            Log.d(TAG,"${crime.title} premuto")
            callbacks?.onCrimeSelected(crime.id)

        }

    }
    private inner class CrimeAdapter(var crimes:List<Crime>): RecyclerView.Adapter<CrimeHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrimeHolder {
            val view =layoutInflater.inflate(R.layout.list_item_crime,parent,false)
            Log.d(TAG,"CrimeAdapter->")
            return CrimeHolder(view )

        }

        override fun onBindViewHolder(holder: CrimeHolder, position: Int) {
            val crime =crimes[position]
            Log.d(TAG,"onBindViewHolder->"+position)
            holder.bind(crime)
        }

        override fun getItemCount(): Int {
            Log.d(TAG,"${crimes.size} elementi")
           return crimes.size
        }


    }
    companion object{
        fun newInstance():CrimeListFragmentCap12{
            return CrimeListFragmentCap12()
                    }
    }
}