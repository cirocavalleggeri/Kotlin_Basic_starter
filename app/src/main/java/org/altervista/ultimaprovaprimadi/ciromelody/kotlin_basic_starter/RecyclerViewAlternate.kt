package org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.adattatori.Articles
import org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.adattatori.CategorieAdapter
import org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.adattatori.Categories
import org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.classi.CrimeListFragment

class RecyclerViewAlternate : AppCompatActivity() {

    private lateinit var mrecyclerView: RecyclerView
    private var adapter: CategorieAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_alternate)
        val mrecyclerView = findViewById(R.id.categories_recycle_view) as RecyclerView
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
         mrecyclerView.layoutManager=layoutManager
        //mrecyclerView.setHasFixedSize(true)

        mrecyclerView.addItemDecoration(
            DividerItemDecoration(
                this,
                layoutManager.orientation
            ))
      /* adapter = CategorieAdapter()
        adapter?.setItems(listOf(Categories("capelli","sciarpe"),Categories("capelli","sciarpe"),
            Articles("lavacapelli","arricciacapelli","lavacapelli"),
            Categories("capelli","sciarpe"),
            Articles("lavacapelli","arricciacapelli","lavacapelli"))
        )
       mrecyclerView.adapter=adapter*/


        //originale
        mrecyclerView.adapter = CategorieAdapter()
        adapter?.setItems(listOf(Categories("capelli","sciarpe"),Categories("capelli","sciarpe"),
            Articles("lavacapelli","arricciacapelli","lavacapelli"),
            Categories("capelli","sciarpe"),
            Articles("lavacapelli","arricciacapelli","lavacapelli")))
        //fine originale
    }
}


