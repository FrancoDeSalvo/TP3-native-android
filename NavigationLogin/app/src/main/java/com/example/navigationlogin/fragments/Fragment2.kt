package com.example.navigationlogin.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationlogin.R
import com.example.navigationlogin.adapters.CarAdapter
import com.example.navigationlogin.entities.Car
import com.example.navigationlogin.entities.User
import com.example.navigationlogin.viewmodels.Fragment2ViewModel
import com.google.android.material.snackbar.Snackbar

class Fragment2 : Fragment() {


    /*lateinit var txtWelcome: TextView
    lateinit var userName: String*/

    lateinit var v: View
    lateinit var recyclerView : RecyclerView
    lateinit var adapter : CarAdapter
    var carList: MutableList<Car> = mutableListOf()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_fragment2, container, false)

        /*   txtWelcome = v.findViewById(R.id.txtWelcome)
       userName = Fragment2Args.fromBundle(requireArguments()).userName

       txtWelcome.text = "¡Bienvenido $userName!"*/

        recyclerView = v.findViewById(R.id.recCar)

        carList.add(Car( brand = "Peugeot", model = "208", segment = "B", urlImage = "asd", description = "hatchback"))
        carList.add(Car( brand = "Peugeot", model = "308", segment = "C", urlImage = "asd", description = "hatchback"))
        carList.add(Car( brand = "Peugeot", model = "2008", segment = "B", urlImage = "asd", description = "SUV"))
        carList.add(Car( brand = "Peugeot", model = "3008", segment = "C", urlImage = "asd", description = "SUV"))
        carList.add(Car( brand = "Peugeot", model = "508", segment = "D", urlImage = "asd", description = "sedan"))
        carList.add(Car( brand = "Peugeot", model = "208", segment = "B", urlImage = "asd", description = "hatchback"))
        carList.add(Car( brand = "Peugeot", model = "308", segment = "C", urlImage = "asd", description = "hatchback"))
        carList.add(Car( brand = "Peugeot", model = "2008", segment = "B", urlImage = "asd", description = "SUV"))
        carList.add(Car( brand = "Peugeot", model = "3008", segment = "C", urlImage = "asd", description = "SUV"))
        carList.add(Car( brand = "Peugeot", model = "508", segment = "D", urlImage = "asd", description = "sedan"))
        carList.add(Car( brand = "Peugeot", model = "208", segment = "B", urlImage = "asd", description = "hatchback"))
        carList.add(Car( brand = "Peugeot", model = "308", segment = "C", urlImage = "asd", description = "hatchback"))
        carList.add(Car( brand = "Peugeot", model = "2008", segment = "B", urlImage = "asd", description = "SUV"))
        carList.add(Car( brand = "Peugeot", model = "3008", segment = "C", urlImage = "asd", description = "SUV"))
        carList.add(Car( brand = "Peugeot", model = "508", segment = "D", urlImage = "asd", description = "sedan"))



        return v
    }

    override fun onStart() {
        super.onStart()

        recyclerView.setHasFixedSize(true)

        recyclerView.layoutManager  = LinearLayoutManager(requireContext())

        adapter = CarAdapter(carList){pos ->
            Snackbar.make(v, carList[pos].brand,
                Snackbar.LENGTH_SHORT
            ).show()
        }
        recyclerView.adapter = adapter

    }

}