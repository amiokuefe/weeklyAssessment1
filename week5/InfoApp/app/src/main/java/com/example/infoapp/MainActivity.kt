package com.example.infoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.infoapp.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

//    private lateinit var binding: ActivityMainBinding
        val arrayList = ArrayList<Model>()
        val displayList = ArrayList<Model>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
        setContentView(R.layout.activity_main)



        arrayList.add(Model("Newsfeed","This is newsfeed description", R.drawable.newsfeed1))
        arrayList.add(Model("Business","This is Business description", R.drawable.business))
        arrayList.add((Model("People","This is people description", R.drawable.people )))
        arrayList.add(Model("Notes","This is notes description", R.drawable.notes))
        arrayList.add(Model("FeedBack", "This is feedback description", R.drawable.feedback))
        displayList.addAll(arrayList)

        val myAdapter = MyAdapter(arrayList, this)

//        binding.recyclerView.layoutManager = LinearLayout(this)
//        binding.recyclerView.adapter = myAdapter

//        recyclerView.layoutManager = LinearLayout(this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = myAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        val menuItem = menu!!.findItem(R.id.search)

        if (menuItem != null) {
            val searchView = menuItem.actionView as SearchView
            val editText = searchView.findViewById<EditText>(androidx.appcompat.R.id.search_src_text)
            editText.hint = "Search..."

            searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {

                    if (newText!!.isNotEmpty()) {

                        displayList.clear()
                        val search = newText.lowercase(Locale.getDefault())
                        arrayList.forEach{
                            if (it.title.lowercase(Locale.getDefault()).contains(search)) {
                                displayList.add(it)
                            }
                        }
                    }

                    return true
                }
            })
        }

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }

}