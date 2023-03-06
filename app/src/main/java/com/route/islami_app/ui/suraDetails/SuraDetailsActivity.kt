package com.route.islami_app.ui.suraDetails

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.route.islami_app.R
import com.route.islami_app.ui.Constants

class SuraDetailsActivity : AppCompatActivity() {

    lateinit var titleTextView: TextView
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: VersesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sura_details)
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        titleTextView = findViewById(R.id.title_text_view)
        initRecyclerView();

        val suraName = intent.getStringExtra(Constants.EXTRA_SURA_NAME) as String
        val suraPos = intent.getIntExtra(Constants.EXTRA_SURA_POS, -1)
        titleTextView.setText(" سورة $suraName")

        readSuraFile(suraPos)

    }

    private fun initRecyclerView() {
        recyclerView = findViewById(R.id.recycler_view_verses)
        adapter = VersesAdapter()
        recyclerView.adapter = adapter

    }

    fun readSuraFile(pos: Int) {
        //pos+1.txt
        val fileName = "${pos + 1}.txt"
        val fileContent = assets.open(fileName).bufferedReader().use { it.readText() }
        val verses: List<String> = fileContent.split("\n");
        adapter.changeData(verses);
    }

}