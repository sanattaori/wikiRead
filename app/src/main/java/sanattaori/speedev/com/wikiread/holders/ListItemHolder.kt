package sanattaori.speedev.com.wikiread.holders

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import sanattaori.speedev.com.wikiread.R
import sanattaori.speedev.com.wikiread.models.WikiPage

class ListItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val articleImageView: ImageView = itemView.findViewById<ImageView>(R.id.result_icon)
    private val titleTextView: TextView = itemView.findViewById<TextView>(R.id.result_title)

    private var currentPage:WikiPage? = null

    fun updateWithPage(page: WikiPage) {
        if (page.thumbmail != null) {
            Picasso.get().load(page.thumbmail!!.source).into(articleImageView)

        }

        titleTextView.text = page.title

        currentPage = page
    }

}