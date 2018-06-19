package sanattaori.speedev.com.wikiread.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_history.*

import sanattaori.speedev.com.wikiread.R
import sanattaori.speedev.com.wikiread.adapter.ArticleCardRecyclerAdapter
import sanattaori.speedev.com.wikiread.adapter.ArticleListItemRecyclerAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class HistoryFragment : Fragment() {

    var historyFragment : RecyclerView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_history, container, false)

        historyFragment = view.findViewById<RecyclerView>(R.id.history_article_recycler)

        historyFragment!!.layoutManager = LinearLayoutManager(context)
        historyFragment!!.adapter = ArticleCardRecyclerAdapter()

        return view
    }
}
