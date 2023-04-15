package io.github.reskimulud.testtrinity.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.github.reskimulud.testtrinity.Contact
import io.github.reskimulud.testtrinity.databinding.ActivityMainBinding
import io.github.reskimulud.testtrinity.ui.adapter.GridContactAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var rvContacts: RecyclerView
    private lateinit var adapter: GridContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvContacts = binding.rvContacts
        adapter = GridContactAdapter {
            val moveToDetailActivityIntent = Intent(
                this@MainActivity, DetailActivity::class.java,
            )
            startActivity(moveToDetailActivityIntent)
        }

        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvContacts.layoutManager = GridLayoutManager(this, 2)
        rvContacts.adapter = adapter

        adapter.setData(dummyData())
    }

    private fun dummyData(): ArrayList<Contact> = arrayListOf(
        Contact(
            "user-1",
            "Reski Mulud",
            "Muchamad"
        ),
        Contact(
            "user-2",
            "Reski Mulud",
            "Muchamad"
        ),
        Contact(
            "user-3",
            "Reski Mulud",
            "Muchamad"
        )
    )
}