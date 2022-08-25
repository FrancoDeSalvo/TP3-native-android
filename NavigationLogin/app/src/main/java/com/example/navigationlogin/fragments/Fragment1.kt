package com.example.navigationlogin.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController
import com.example.navigationlogin.R
import com.example.navigationlogin.entities.User
import com.example.navigationlogin.viewmodels.Fragment1ViewModel
import com.google.android.material.snackbar.Snackbar

class Fragment1 : Fragment() {

    lateinit var v: View
    lateinit var inputUserName: EditText
    lateinit var inputPassword: EditText
    lateinit var btnLogin: Button
    lateinit var userName: String
    var userList: MutableList<User> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_fragment1, container, false)

        userList.add(User(name = "Fran", email = "fran@gmail.com", password = "1234"))
        userList.add(User(name = "Ale", email = "ale@gmail.com", password = "admin"))

        inputUserName = v.findViewById(R.id.inputUserName)
        inputPassword = v.findViewById(R.id.inputPassword)
        btnLogin = v.findViewById(R.id.btnLogin)

        return v
    }

    override fun onStart() {
        super.onStart()

        btnLogin.setOnClickListener {

            if (inputUserName.text.isNotBlank() && inputPassword.text.isNotBlank()) {
                userName = inputUserName.text.toString()
                var serchedUser: User?
                serchedUser = userList.find { u -> u.name == userName }

                if (serchedUser != null && serchedUser.password == inputPassword.text.toString()) {
                    val actionLogin =
                        Fragment1Directions.actionFragment1ToFragment2(userName = inputUserName.text.toString())
                    v.findNavController().navigate(actionLogin)
                } else {
                    Snackbar.make(it, "Usuario o contraseña incorrectos", Snackbar.LENGTH_SHORT)
                        .show()
                }

            } else {
                Snackbar.make(it, "Complete los campos", Snackbar.LENGTH_SHORT).show()
            }

        }

    }


}