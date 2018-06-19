package sanattaori.speedev.com.wikiread.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_explore.*
import sanattaori.speedev.com.wikiread.R
import sanattaori.speedev.com.wikiread.holders.CardHolder

class ArticleCardRecyclerAdapter() : RecyclerView.Adapter<CardHolder>(){
    override fun getItemCount(): Int {

        return 15 //temp
    }

    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        //update views

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        var cardItem = LayoutInflater.from(parent?.context).inflate(R.layout.article_card_item,parent,false)
        return CardHolder(cardItem)
    }


}