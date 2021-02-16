package com.example.fragmentinteraction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragmentinteraction.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        loadFirstFragment()
        loadSecondFragment()
    }

    private fun loadFirstFragment() {
        supportFragmentManager.beginTransaction().add(
            binding.frag1.id,
            FirstFragment.newInstance(),
            "1st Fragment"
        ).commit()
    }

    override fun goToSecond(text :String) {
        supportFragmentManager.beginTransaction().add(
            binding.frag1.id,
            SecondFragment.newInstance(text),
            "2nd Fragment"
        ).commit()
    }


    private fun loadSecondFragment() {
        supportFragmentManager.beginTransaction().add(
            binding.frag1.id,
            FirstFragment.newInstance(),
            "1st Fragment"
        ).commit()
    }

    override fun goToThird(text :String) {
        supportFragmentManager.beginTransaction().add(
            binding.frag1.id,
            SecondFragment.newInstance(text),
            "2nd Fragment"
        ).commit()
    }





}