package com.example.lab_week_03

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

class ListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val coffeeList = listOf(
            view.findViewById<View>(R.id.affogato),
            view.findViewById<View>(R.id.americano),
            view.findViewById<View>(R.id.latte),
            view.findViewById(R.id.espresso),
            view.findViewById(R.id.mocha)
        )

        coffeeList.forEach { coffee ->
            coffee.setOnClickListener {
                val fragmentBundle = Bundle()
                fragmentBundle.putInt(DetailFragment.COFFEE_ID, coffee.id)

                view.findNavController().navigate(
                    R.id.coffee_id_action,
                    fragmentBundle
                )
            }
        }
    }
}
