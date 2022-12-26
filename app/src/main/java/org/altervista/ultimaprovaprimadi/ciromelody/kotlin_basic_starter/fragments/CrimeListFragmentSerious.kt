package org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.fragments


import android.os.Bundle
import android.system.Os.bind
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.Button
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
import org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.adattatori.CategorieAdapter
import org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.adattatori.Categories
import org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.classi.Crime
import org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.classi.CrimeListViewModel
import org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.classi.Utility


private const val TAG="CrimeListFragment"
private const val TYPE_NO_REQUIRES_POLICE = 0
private const val TYPE_REQUIRES_POLICE = 1

class CrimeListFragmentSerious: Fragment() {

private lateinit var crimeRecyclerView: RecyclerView
private var adapter: CrimeAdapter? = null
private lateinit var mostraToast: Utility
    val crimeListViewModel: CrimeListViewModel by lazy { ViewModelProviders.of(this).get(CrimeListViewModel::class.java) }


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
    private inner class  CrimeHolderSerious(view:View):RecyclerView.ViewHolder(view),View.OnClickListener{


        lateinit var crime: Crime

        fun bind(crime: Crime) {
            this.crime=crime
            titleTextView.text=crime.title
            dateTextView.text=crime.date.toString()
            callButton.text="Call"
            Log.d(TAG,"CrimeHolderSerious->"+crime.title)
        }

        val titleTextView:TextView=itemView.findViewById(R.id.crime_title)
        val dateTextView:TextView=itemView.findViewById(R.id.crime_date)
        val callButton:Button=itemView.findViewById(R.id.id_btn_is_required_police)


        init {
            itemView.setOnClickListener(this)
            callButton.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            Toast.makeText(context,"${crime.title} premuto",Toast.LENGTH_LONG).show()
            Log.d(TAG,"${crime.title} premuto")


        }

    }
  private inner class  CrimeHolder(view:View):RecyclerView.ViewHolder(view),View.OnClickListener{


        lateinit var crime: Crime

        fun bind(crime: Crime) {
            this.crime=crime
            titleTextView.text=crime.title
            dateTextView.text=crime.date.toString()
            Log.d(TAG,"CrimeHolder->"+crime.title)
        }


        val titleTextView:TextView=itemView.findViewById(R.id.crime_title)
          val dateTextView:TextView=itemView.findViewById(R.id.crime_date)

        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            //Toast.makeText(context,"${crime.title} premuto",Toast.LENGTH_LONG).show()
            Log.d(TAG,"${crime.title} premuto")


        }

    }
    private inner class CrimeAdapter(var crimes:List<Crime>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


        override fun getItemViewType(position: Int): Int {
            Log.d("ALT", "getItemViewType(position: Int) ->" + crimes[position].toString())
            return if (crimes[position].isRequiresPolice) TYPE_REQUIRES_POLICE else TYPE_NO_REQUIRES_POLICE
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val view:View
            if(viewType==TYPE_NO_REQUIRES_POLICE){
                     view =layoutInflater.inflate(R.layout.list_item_crime,parent,false)
                     return CrimeHolder(view )
              }else{ view =layoutInflater.inflate(R.layout.list_item_crime_serious,parent,false)
                     return CrimeHolderSerious(view )
              }
            Log.d(TAG,"CrimeAdapter->")


        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            val crime =crimes[position]
            Log.d(TAG,"onBindViewHolder->"+position)
            when(holder){
                is CrimeHolder ->{  if(!crime.isRequiresPolice) {holder.bind(crime)}  }
                is CrimeHolderSerious ->{if(crime.isRequiresPolice) {holder.bind(crime)} }

            }

        }

        override fun getItemCount(): Int {
            Log.d(TAG,"${crimes.size} elementi")
           return crimes.size
        }


    }
    companion object{
        fun newInstance():CrimeListFragmentSerious{
            return CrimeListFragmentSerious()
                    }
    }
}