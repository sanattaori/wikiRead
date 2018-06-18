package sanattaori.speedev.com.wikiread.activities

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import sanattaori.speedev.com.wikiread.R
import sanattaori.speedev.com.wikiread.fragments.ExploreFragment
import sanattaori.speedev.com.wikiread.fragments.FavoritesFragment
import sanattaori.speedev.com.wikiread.fragments.HistoryFragment

class MainActivity : AppCompatActivity() {

    private val exploreFragment: ExploreFragment
    private val favoritesFragment: FavoritesFragment
    private val historyFragment: HistoryFragment

    init {
        exploreFragment = ExploreFragment()
        favoritesFragment = FavoritesFragment()
        historyFragment = HistoryFragment()
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->

        val transaction = supportFragmentManager.beginTransaction()
        transaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)

        when(item.itemId) {
            R.id.title_explore -> transaction.replace(R.id.fragment_container, exploreFragment)
            R.id.title_favorites ->transaction.replace(R.id.fragment_container,favoritesFragment)
            R.id.title_history ->transaction.replace(R.id.fragment_container,historyFragment)

        }

        transaction.commit()

        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container, exploreFragment)
        transaction.commit()
    }
}
