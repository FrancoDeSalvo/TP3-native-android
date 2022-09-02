package com.example.navigationlogin.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationlogin.R
import com.example.navigationlogin.entities.Car


    class CarAdapter (var carList : MutableList<Car>,
                      var onClick : (Int) -> Unit ):
        RecyclerView.Adapter<CarAdapter.CarHolder>(){

        class CarHolder (v: View) : RecyclerView.ViewHolder(v) {
            private var view: View
            init {
                this.view = v
            }

            fun setCarBrand (brand : String) {
                val txtCarBrand : TextView = view.findViewById(R.id.txtBrand)
                txtCarBrand.text = brand
            }

            fun setCarModel (model : String) {
                val txtModel : TextView = view.findViewById(R.id.txtModel)
                txtModel.text = model
            }

            fun getCardView () : CardView {
                return view.findViewById(R.id.card)
            }

        }



        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarHolder {
            val view =  LayoutInflater.from(parent.context).inflate(R.layout.item_car,parent,false)
            return (CarHolder(view))    }

        override fun onBindViewHolder(holder: CarHolder, position: Int) {
            holder.setCarBrand(carList[position].brand)
            holder.setCarModel(carList[position].model)
            holder.getCardView().setOnClickListener {
                onClick(position)
            }
        }

        override fun getItemCount(): Int {
            return carList.size
        }
    }


