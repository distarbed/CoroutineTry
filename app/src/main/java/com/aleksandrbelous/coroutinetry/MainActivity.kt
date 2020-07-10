package com.aleksandrbelous.coroutinetry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aleksandrbelous.coroutinetry.home.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(
            R.id.fragmentContainer, HomeFragment(), "Home"
        )
        transaction.addToBackStack(null)
        transaction.commit()
    }
}