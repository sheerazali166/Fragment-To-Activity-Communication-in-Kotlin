package com.example.activitytofragmentcommunication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity(), KinzaFragment.KinzaAmjadInterface {

    lateinit var fragmentManager:FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(finishActivity(R.id.kinzaContainer) != null){

            if(savedInstanceState != null){

                return
            }

            fragmentManager = supportFragmentManager

            var kinzaFragment:KinzaFragment = KinzaFragment()

            var fragmentTransaction:FragmentTransaction = fragmentManager.beginTransaction()
                .add(R.id.kinzaContainer, kinzaFragment, null)

            fragmentTransaction.commit()
        }
    }

    override fun onMessage(message: String) {

        var textViewKinza = findViewById<TextView>(R.id.textViewKinza)

        textViewKinza.text = message
    }
}