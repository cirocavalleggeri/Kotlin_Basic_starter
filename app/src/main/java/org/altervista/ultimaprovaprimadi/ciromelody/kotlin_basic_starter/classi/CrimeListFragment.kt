package org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.classi


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.res.ColorStateListInflaterCompat.inflate
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_crime_list.*
import kotlinx.android.synthetic.main.fragment_crime_list.view.*
import org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.R


private const val TAG="CrimeListFragment"

class CrimeListFragment: Fragment() {
private lateinit var crimeRecyclerView: RecyclerView
private var adapter: CrimeAdapter? = null
    val crimeListViewModel:CrimeListViewModel by lazy { ViewModelProviders.of(this).get(CrimeListViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d(TAG,"Crimini totali :${crimeListViewModel.crimes.size}")


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
       updateUI()
        return view
    }
    private fun updateUI() {
        val crimes = crimeListViewModel.crimes
        adapter = CrimeAdapter(crimes)
        crimeRecyclerView.adapter = adapter
    }
    private inner class  CrimeHolder(view:View):RecyclerView.ViewHolder(view){
         val titleTextView:TextView=itemView.findViewById(R.id.crime_title)
          val dateTextView:TextView=itemView.findViewById(R.id.crime_date)

    }
    private inner class CrimeAdapter(var crimes:List<Crime>): RecyclerView.Adapter<CrimeHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrimeHolder {
            val view =layoutInflater.inflate(R.layout.list_item_crime,parent,false)
           return CrimeHolder(view )

        }

        override fun onBindViewHolder(holder: CrimeHolder, position: Int) {
            val crime =crimes[position]
            holder.apply {
                titleTextView.text=crime.title
                dateTextView.text=crime.date.toString()
            }
        }

        override fun getItemCount(): Int {
           return crimes.size
        }


    }
    companion object{
        fun newInstance():CrimeListFragment{
            return CrimeListFragment()
                    }
    }
}