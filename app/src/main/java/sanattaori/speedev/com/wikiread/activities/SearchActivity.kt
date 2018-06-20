package sanattaori.speedev.com.wikiread.activities

import android.app.SearchManager
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_search.*
import sanattaori.speedev.com.wikiread.R
import sanattaori.speedev.com.wikiread.adapter.ArticleListItemRecyclerAdapter
import sanattaori.speedev.com.wikiread.models.WikiResult
import sanattaori.speedev.com.wikiread.providers.ArticleDataProvider

class SearchActivity : AppCompatActivity() {

    private var articleProvider: ArticleDataProvider = ArticleDataProvider()
    private var adapter: ArticleListItemRecyclerAdapter = ArticleListItemRecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)


        //reference to recycler view
        search_results_recycler.layoutManager = LinearLayoutManager(this)
        search_results_recycler.adapter = adapter
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item!!.itemId == android.R.id.home){
            finish()
        }
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)

        var searchItem = menu!!.findItem(R.id.android_search)

        var searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        var searchView = searchItem!!.actionView as SearchView
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.setIconifiedByDefault(false)
        searchView.requestFocus()

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                articleProvider.search(query!!, 0, 20, { wikiResult ->
                    adapter.currentResults.clear()
                    adapter.currentResults.addAll(wikiResult.query!!.pages)
                    runOnUiThread { adapter.notifyDataSetChanged() }

                })
                println("updated search")

                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
                 //To change body of created functions use File | Settings | File Templates.
            }
        })

        return super.onCreateOptionsMenu(menu)
    }
}
