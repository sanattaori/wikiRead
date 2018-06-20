package sanattaori.speedev.com.wikiread.holders

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import sanattaori.speedev.com.wikiread.R
import sanattaori.speedev.com.wikiread.activities.ArticleDetailActivity
import sanattaori.speedev.com.wikiread.models.WikiPage

class ListItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val articleImageView: ImageView = itemView.findViewById<ImageView>(R.id.result_icon)
    private val titleTextView: TextView = itemView.findViewById<TextView>(R.id.result_title)

    private var currentPage:WikiPage? = null

    init {
        itemView.setOnClickListener { v: View? ->
            var detailPageIntent = Intent(itemView.context, ArticleDetailActivity::class.java)
            var pageJson = Gson().toJson(currentPage)
            detailPageIntent.putExtra("page",pageJson)
            itemView.context.startActivity(detailPageIntent)
        }
    }

    fun updateWithPage(page: WikiPage) {
        if (page.thumbmail != null) {
            Picasso.get().load(page.thumbmail!!.source).into(articleImageView)
        }

        titleTextView.text = page.title

        currentPage = page
    }

}