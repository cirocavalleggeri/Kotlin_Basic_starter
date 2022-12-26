package org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.classi


import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.makeText
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
private lateinit var mostraToast:Utility
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
    private inner class  CrimeHolder(view:View):RecyclerView.ViewHolder(view),View.OnClickListener{


        lateinit var crime:Crime

        fun bind(crime: Crime) {
            this.crime=crime
            titleTextView.text=crime.title
            dateTextView.text=crime.date.toString()
            Log.d(TAG,"CrimeHolder->"+crime.title)
        }

        val titleTextView:TextView=itemView.findViewById(R.id.crime_title)
          val dateTextView:TextView=itemView.findViewById(R.id.crime_date
          )

        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            Toast.makeText(context,"${crime.title} premuto",Toast.LENGTH_LONG).show()
            Log.d(TAG,"${crime.title} premuto")


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
        fun newInstance():CrimeListFragment{
            return CrimeListFragment()
                    }
    }
}