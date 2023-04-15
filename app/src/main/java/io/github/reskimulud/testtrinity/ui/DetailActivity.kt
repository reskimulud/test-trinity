package io.github.reskimulud.testtrinity.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.github.reskimulud.testtrinity.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}