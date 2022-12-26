package org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.adattatori

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.R
import org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.adattatori.CategorieAdapter.ArticlesViewHolder.Companion.create

class CategorieAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_CATEGORIES = 0
        private const val TYPE_ARTICLES = 1
    }

    private val items: MutableList<Any> by lazy {
        ArrayList<Any>()
    }


    fun setItems(list: List<Any>) {
        items.clear()

            for(name in list){
                items.add(name)
                Log.d("ALT","Carico i dati "+  name.toString())
                notifyDataSetChanged()
            }





    }


    override fun getItemViewType(position: Int): Int {
        Log.d("ALT", "getItemViewType(position: Int) ->" + items[position].toString())
        return if (items[position] is Categories) TYPE_CATEGORIES else TYPE_ARTICLES
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        Log.d("ALT", " onCreateViewHolder ->" + viewType.toString())
        return when (viewType) {

            TYPE_CATEGORIES -> CategoriesViewHolder.Companion.create(viewGroup)
            else -> ArticlesViewHolder.Companion.create(viewGroup)
        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.d("ALT", "onBindViewHolder ->" + items[position].toString())
        when (holder) {

            is CategoriesViewHolder -> {
                Log.d("ALT", "CategoriesViewHolder ->" +holder.toString())
                if (items[position] is Categories)
                    holder.bind(items[position] as Categories)
            }
            is ArticlesViewHolder -> {
                Log.d("ALT", "ArticlesViewHolder ->" + items[position].toString())
                if (items[position] is Articles)
                    holder.bind(items[position] as Articles)
            }

        }
    }


    override fun getItemCount(): Int {
        Log.d("ALT", "items.size ->" + items.size.toString())
        return items.size
    }


   class CategoriesViewHolder(parent: View) : RecyclerView.ViewHolder(parent) {

        val textView: TextView = parent.findViewById(R.id.categories_textView)

        fun bind(category: Categories) {
            textView.text = category.categoryName
            Log.d("ALT", "Associo il vaolore di Categoria alla textview")


        }

        companion object {
            fun create(parent: ViewGroup): CategoriesViewHolder {
                Log.d("ALT", "Inietto il layout di categoria in parent")
                return CategoriesViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.categories_item_layout, parent, false)

                )
            }
        }
    }

   class ArticlesViewHolder(parent: View) : RecyclerView.ViewHolder(parent) {

        val textView: TextView = parent.findViewById(R.id.titleText)

        fun bind(articles: Articles) {
            textView.text = articles.articleName
            Log.d("ALT", "Associo il vaolore di Articoli alla textview")
        }

        companion object {
            fun create(parent: ViewGroup): ArticlesViewHolder {
                Log.d("ALT", "Inietto il layout di articoli in parent")
                return ArticlesViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.article_item_layout, parent, false)
                )
            }
        }
    }


}