package com.example.appparcial.ui.game.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appparcial.R
import com.example.appparcial.data.model.GameModel
import com.example.appparcial.databinding.FragmentHomeBinding
import com.example.appparcial.ui.game.home.recyclerview.GameRecyclerViewAdapter
import com.example.appparcial.ui.game.viewmodel.GameViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeFragment : Fragment() {

    private val gameViewModel: GameViewModel by activityViewModels {
        GameViewModel.Factory
    }

    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: GameRecyclerViewAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(view)

        binding.buttonAdd.setOnClickListener {
            gameViewModel.clearData()
            it.findNavController().navigate(R.id.action_homeFragment_to_newGameFragment)
        }

    }

    // Funciones para implementar el RecyclerView

    private fun showSelectedItem(game: GameModel) {
        gameViewModel.setSelectedGame(game)
        findNavController().navigate(R.id.action_homeFragment_to_gameFragment)
    }

    private fun displayGames() {
        adapter.setData(gameViewModel.getGames())
        adapter.notifyDataSetChanged()
    }

    private fun setRecyclerView(view: View) {
        binding.RecyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = GameRecyclerViewAdapter { selectedGame ->
            showSelectedItem(selectedGame)
        }

        binding.RecyclerView.adapter = adapter
        displayGames()
    }


}