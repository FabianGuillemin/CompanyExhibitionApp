package ch.giime.fensterquiz

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView

class TwoPlayerTTT : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
    val mView = inflater.inflate(R.layout.fragment_two_player_ttt, container, false)

        var chance = "X"
        var board = arrayListOf<String>("", "", "", "", "", "", "", "", "")
        val animZoom = AnimationUtils.loadAnimation(context, R.anim.zoom)
        val textViewTTT = mView.findViewById<TextView>(R.id.textViewTTT)
        textViewTTT.startAnimation(animZoom)

        val button0 = mView.findViewById<Button>(R.id.button0)
            button0.setOnClickListener {
            if (board[0] != "")
            else if (chance == "X") {
                button0.text = "X"
                board[0] = "X"
                chance = "0"
                resultOut(board)
            } else {
                button0.text = "0"
                board[0] = "0"
                chance = "X"
                resultOut(board)
            }
        }

        val button1 = mView.findViewById<Button>(R.id.button1)
        button1.setOnClickListener {
            if (board[1] != "")
            else if (chance == "X") {
                button1.text = "X"
                board[1] = "X"
                chance = "0"
                resultOut(board)
            } else {
                button1.text = "0"
                board[1] = "0"
                chance = "X"
                resultOut(board)
            }
        }

        val button2 = mView.findViewById<Button>(R.id.button2)
        button2.setOnClickListener {
            if (board[2] != "")
            else if (chance == "X") {
                button2.text = "X"
                board[2] = "X"
                chance = "0"
                resultOut(board)
            } else {
                button2.text = "0"
                board[2] = "0"
                chance = "X"
                resultOut(board)
            }
        }

        val button3 = mView.findViewById<Button>(R.id.button3)
        button3.setOnClickListener {
            if (board[3] != "")
            else if (chance == "X") {
                button3.text = "X"
                board[3] = "X"
                chance = "0"
                resultOut(board)
            } else {
                button3.text = "0"
                board[3] = "0"
                chance = "X"
                resultOut(board)
            }
        }

        val button4 = mView.findViewById<Button>(R.id.button4)
        button4.setOnClickListener {
            if (board[4] != "")
            else if (chance == "X") {
                button4.text = "X"
                board[4] = "X"
                chance = "0"
                resultOut(board)
            } else {
                button4.text = "0"
                board[4] = "0"
                chance = "X"
                resultOut(board)
            }
        }

        val button5 = mView.findViewById<Button>(R.id.button5)
        button5.setOnClickListener {
            if (board[5] != "")
            else if (chance == "X") {
                button5.text = "X"
                board[5] = "X"
                chance = "0"
                resultOut(board)
            } else {
                button5.text = "0"
                board[5] = "0"
                chance = "X"
                resultOut(board)
            }
        }

        val button6 = mView.findViewById<Button>(R.id.button6)
        button6.setOnClickListener {
            if (board[6] != "")
            else if (chance == "X") {
                button6.text = "X"
                board[6] = "X"
                chance = "0"
                resultOut(board)
            } else {
                button6.text = "0"
                board[6] = "0"
                chance = "X"
                resultOut(board)
            }
        }

        val button7 = mView.findViewById<Button>(R.id.button7)
        button7.setOnClickListener {
            if (board[7] != "")
            else if (chance == "X") {
                button7.text = "X"
                board[7] = "X"
                chance = "0"
                resultOut(board)
            } else {
                button7.text = "0"
                board[7] = "0"
                chance = "X"
                resultOut(board)
            }
        }

        val button8 = mView.findViewById<Button>(R.id.button8)
        button8.setOnClickListener {
            if (board[8] != "")
            else if (chance == "X") {
                button8.text = "X"
                board[8] = "X"
                chance = "0"
                resultOut(board)
            } else {
                button8.text = "0"
                board[8] = "0"
                chance = "X"
                resultOut(board)
            }
        }

        val HomeButton = mView.findViewById<Button>(R.id.homeButtonTTT)
        HomeButton.setOnClickListener {
            this.fragmentManager!!.beginTransaction()
                .replace(R.id.fragmentPlace, StartPageTTT())
                .commit()
        }

        val resetButton = mView.findViewById<Button>(R.id.buttonReset)
        resetButton.setOnClickListener {
            this.fragmentManager!!.beginTransaction()
                .replace(R.id.fragmentPlace, TwoPlayerTTT())
                .commit()
        }

        return mView
    }

    private fun isBoardFull(board: ArrayList<String>): Boolean {
        for (i in board)
            if (i != "X" && i != "0") return false
        return true
    }

    private fun result(bd: ArrayList<String>, s: String): Boolean =
        if(bd[0] == s && bd[1] == s && bd[2] == s) true
        else if(bd[3] == s && bd[4] == s && bd[5] == s) true
        else if(bd[6] == s && bd[7] == s && bd[8] == s) true
        else if(bd[0] == s && bd[3] == s && bd[6] == s) true
        else if(bd[1] == s && bd[4] == s && bd[7] == s) true
        else if(bd[2] == s && bd[5] == s && bd[8] == s) true
        else if(bd[0] == s && bd[4] == s && bd[8] == s) true
        else if(bd[2] == s && bd[4] == s && bd[6] == s) true
        else false

    private fun resultOut(board: ArrayList<String>){
        if (result(board, "X")){
            val daten : Bundle = Bundle()
            daten.putString("winner", "X gewinnt! \nHerzlichen Glückwunsch")
            daten.putString("Fragment", "TwoPlayer")
            val WonFragment = WonFragmentTTT()
            WonFragment.arguments = daten
            this.fragmentManager!!.beginTransaction()
                .replace(R.id.fragmentPlace, WonFragment)
                .addToBackStack(null)
                .commit()

        } else if(result(board, "0")){
            val daten : Bundle = Bundle()
            val WonFragment = WonFragmentTTT()
            daten.putString("winner", "0 gewinnt! \nHerzlichen Glückwunsch")
            daten.putString("Fragment", "TwoPlayer")
            WonFragment.arguments = daten
            this.fragmentManager!!.beginTransaction()
                .replace(R.id.fragmentPlace, WonFragment)
                .addToBackStack(null)
                .commit()

        } else if(isBoardFull(board)){
            val daten : Bundle = Bundle()
            val WonFragment = WonFragmentTTT()
            daten.putString("winner", "Unentschieden. \nGleich nochmal!")
            daten.putString("Fragment", "TwoPlayer")
            WonFragment.arguments = daten
            this.fragmentManager!!.beginTransaction()
                .replace(R.id.fragmentPlace, WonFragment)
                .addToBackStack(null)
                .commit()
        }
    }
}