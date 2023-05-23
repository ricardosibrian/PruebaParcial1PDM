package com.example.appparcial.ui.game.newgame

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.appparcial.databinding.FragmentNewGameBinding
import com.example.appparcial.ui.game.viewmodel.GameViewModel

class NewGameFragment : Fragment() {

    private lateinit var binding: FragmentNewGameBinding

    private val gameViewModel: GameViewModel by activityViewModels{
        GameViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
        observeStatus()

    }

    private fun setViewModel() {
        binding.viewmodel = gameViewModel
    }

    private fun observeStatus() {
        gameViewModel.status.observe(viewLifecycleOwner) { status ->
            when {
                status.equals(GameViewModel.WRONG_DATA) -> {
                    Log.d("APP TAG", status)
                    gameViewModel.clearStatus()
                }
                status.equals(GameViewModel.GAME_CREATED) -> {
                    Log.d("APP TAG", status)
                    Log.d("APP TAG", gameViewModel.getGames().toString())

                    gameViewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }


}