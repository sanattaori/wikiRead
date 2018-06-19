package sanattaori.speedev.com.wikiread.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import sanattaori.speedev.com.wikiread.R
import sanattaori.speedev.com.wikiread.holders.ListItemHolder
import sanattaori.speedev.com.wikiread.models.WikiPage

class ArticleListItemRecyclerAdapter() : RecyclerView.Adapter<ListItemHolder>(){

    val currentResults : ArrayList<WikiPage> = ArrayList<WikiPage>()


    override fun getItemCount(): Int {
        return currentResults.size //temp
    }

    override fun onBindViewHolder(holder: ListItemHolder, position: Int) {
        //update views
        var page = currentResults[position]
        holder.updateWithPage(page)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemHolder {
        var cardItem = LayoutInflater.from(parent?.context).inflate(R.layout.article_list_item,parent,false)
        return ListItemHolder(cardItem)
    }


}