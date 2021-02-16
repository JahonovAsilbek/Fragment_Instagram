package uz.revolution.fragmentsinstagramapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.revolution.fragmentsinstagramapp.fragments.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainFragment = MainFragment()
        supportFragmentManager.beginTransaction().add(R.id.container,mainFragment,"main").commit()

    }
}