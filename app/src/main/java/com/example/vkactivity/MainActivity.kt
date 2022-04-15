package com.example.vkactivity

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vkactivity.databinding.ActivityMainBinding
import com.example.vkactivity.models.FotoItem
import com.example.vkactivity.models.StoriesItem
import com.example.vkactivity.recViewAdapters.FotoAdapter
import com.example.vkactivity.recViewAdapters.StoriesAdapter


class MainActivity : AppCompatActivity() {


    lateinit var binding: ActivityMainBinding

    private val storiesAdapter = StoriesAdapter()
    private val fotoAdapter = FotoAdapter()

    private val storiesList = arrayOf(
        StoriesItem(R.drawable.avatar1, "User"),
        StoriesItem(R.drawable.man, "Anton"),
        StoriesItem(R.drawable.man, "Николай"),
        StoriesItem(R.drawable.woman, "Анна"),
        StoriesItem(R.drawable.man, "Tom"),
        StoriesItem(R.drawable.woman, "Саша")
    )

    private val fotoList = arrayOf(
        FotoItem(R.drawable.foto1), FotoItem(R.drawable.foto2)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility =View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            window.statusBarColor = Color.WHITE
        }
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        initRecViews()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu);
        return true
    }

    fun initRecViews() {

        binding.apply {
            rvStories.layoutManager =
                LinearLayoutManager(this@MainActivity, RecyclerView.HORIZONTAL, false)
            rvStories.adapter = storiesAdapter
            for (element in storiesList) {
                val stories = element
                storiesAdapter.addStoriesItem(stories)
            }

            rvFoto.layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.HORIZONTAL, false)
            rvFoto.adapter = fotoAdapter
            for(element in fotoList){
                fotoAdapter.addFotoItem(element)
            }
        }
    }
}