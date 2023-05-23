package com.example.appparcial

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeFragment : Fragment() {

    private lateinit var card: CardView
    private lateinit var buttonAdd: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind(view)
        addListener()
    }

    private fun bind(view: View) {
        card = view.findViewById(R.id.card)
        buttonAdd = view.findViewById(R.id.buttonAdd)
    }

    private fun addListener() {
        card.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_gameFragment)
        }

        buttonAdd.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_newGameFragment)
        }
    }

}