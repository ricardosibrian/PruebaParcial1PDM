package com.example.appparcial.ui.game

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.appparcial.R
import com.example.appparcial.data.model.GameModel
import com.google.android.material.textfield.TextInputEditText

class NewGameFragment : Fragment() {

    private val gameViewModel: GameViewModel by activityViewModels{
        GameViewModel.Factory
    }

    lateinit var name: TextInputEditText
    lateinit var genre: TextInputEditText
    lateinit var description: TextInputEditText
    lateinit var calification: TextInputEditText
    lateinit var actionSubmit: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bind(view)

        actionSubmit.setOnClickListener {
            createPlayer()
        }

    }

    private fun bind(view: View){
        name = view.findViewById(R.id.TextField1)
        genre = view.findViewById(R.id.TextField2)
        description = view.findViewById(R.id.TextField3)
        calification = view.findViewById(R.id.TextField4)
        actionSubmit = view.findViewById(R.id.addTracker)
    }

    private fun createPlayer(){
        val newPlayer = GameModel(
            name.text.toString(),
            genre.text.toString(),
            description.text.toString(),
            calification.text.toString()
        )
        gameViewModel.addGame(newPlayer)

        Log.d("APP TAG", gameViewModel.getGames().toString())

        findNavController().popBackStack()
    }
}