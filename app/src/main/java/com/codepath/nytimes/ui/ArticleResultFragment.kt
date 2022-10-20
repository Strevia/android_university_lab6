package com.codepath.nytimes.ui

import android.R
import android.os.Bundle
import android.view.*
import androidx.core.view.MenuItemCompat
import androidx.fragment.app.Fragment
import com.codepath.nytimes.R


class ArticleResultFragment: Fragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(com.codepath.nytimes.R.layout.fragment_article_result,container,false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)
    }
    fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = getMenuInflater()
        inflater.inflate(com.codepath.nytimes.R.menu.main, menu)
        val searchItem: MenuItem = menu.findItem(com.codepath.nytimes.R.id.action_search)
        val searchView: SearchView = MenuItemCompat.getActionView(searchItem) as SearchView
        searchView.setOnQueryTextListener(object : OnQueryTextListener() {
            fun onQueryTextSubmit(query: String?): Boolean {
                // perform query here

                // workaround to avoid issues with some emulators and keyboard devices firing twice if a keyboard enter is used
                // see https://code.google.com/p/android/issues/detail?id=24599
                searchView.clearFocus()
                return true
            }

            fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
        return super.onCreateOptionsMenu(menu)
    }
}