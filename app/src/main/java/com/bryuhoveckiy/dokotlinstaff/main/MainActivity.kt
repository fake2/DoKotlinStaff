package com.bryuhoveckiy.dokotlinstaff.main

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.recyclerview.widget.LinearLayoutManager
import com.bryuhoveckiy.dokotlinstaff.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity(),
    BookAdapter.OnBookListener {

    private val mainViewModel: MainViewModel by viewModels {
        SavedStateViewModelFactory(application, this)
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
//        val view = binding.root
//        setContentView(view)
        setContentView(binding.root)


//        val data = Book.data
//        data.forEach { Timber.i(it.packageName) }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = BookAdapter(Book.data, this)
        binding.recyclerView.adapter = adapter

        binding.btnOne.setOnClickListener { _ ->
            adapter.dispatch(Book.data.sortedBy { it.title })
        }


        mainViewModel.saveName("my name")
        Timber.d("my name from view model: %s", mainViewModel.getName())
    }

    override fun onBookClick(book: Book) {
//        Timber.d("book: %s", book.title)
//        Toast.makeText(this, book.title, Toast.LENGTH_SHORT).show()
        val name = book.packageName
        var cls: Class<*>? = null
        try {
            cls = Class.forName(name)
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        }
        if (cls != null) {
            val intent = Intent(this@MainActivity, cls)
            this@MainActivity.startActivity(intent)
        } else {
            Toast.makeText(this@MainActivity, "$name not found!", Toast.LENGTH_LONG).show()
        }
    }
}