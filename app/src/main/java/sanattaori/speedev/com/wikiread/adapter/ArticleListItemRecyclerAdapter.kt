package sanattaori.speedev.com.wikiread.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import sanattaori.speedev.com.wikiread.R
import sanattaori.speedev.com.wikiread.holders.ListItemHolder

class ArticleListItemRecyclerAdapter() : RecyclerView.Adapter<ListItemHolder>(){
    override fun getItemCount(): Int {

        return 15 //temp
    }

    override fun onBindViewHolder(holder: ListItemHolder, position: Int) {
        //update views

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemHolder {
        var cardItem = LayoutInflater.from(parent?.context).inflate(R.layout.article_list_item,parent,false)
        return ListItemHolder(cardItem)
    }


}