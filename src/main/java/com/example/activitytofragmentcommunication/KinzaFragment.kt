package com.example.activitytofragmentcommunication

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.FragmentActivity
import java.lang.ClassCastException


class KinzaFragment : Fragment() {

    lateinit var kinzaAmjadInterface:KinzaAmjadInterface

    public interface KinzaAmjadInterface{

        fun onMessage(message:String)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view:View = inflater.inflate(R.layout.fragment_kinza, container, false)

        var editTextKinza:EditText = view.findViewById(R.id.editTextKinza)

        var buttonKinza:Button = view.findViewById(R.id.buttonKinza)

        buttonKinza.setOnClickListener {

            var kinza:String = editTextKinza.text.toString()

            kinzaAmjadInterface.onMessage(kinza)
        }

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

         var activityKinza:Activity? = activity





        try {
            kinzaAmjadInterface = activityKinza as KinzaAmjadInterface
        }

        catch (e:ClassCastException){

            throw ClassCastException("${activityKinza.toString()} must impliment onMessage")
        }
    }

}