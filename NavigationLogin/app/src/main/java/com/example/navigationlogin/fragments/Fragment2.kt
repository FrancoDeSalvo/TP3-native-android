package com.example.navigationlogin.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.navigationlogin.R
import com.example.navigationlogin.viewmodels.Fragment2ViewModel

class Fragment2 : Fragment() {

    lateinit var v: View
    lateinit var txtWelcome: TextView
    lateinit var userName: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_fragment2, container, false)

        txtWelcome = v.findViewById(R.id.txtWelcome)
        userName = Fragment2Args.fromBundle(requireArguments()).userName

        txtWelcome.text = "¡Bienvenido $userName!"

        return v
    }

    override fun onStart() {
        super.onStart()

    }

}