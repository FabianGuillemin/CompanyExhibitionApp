package ch.giime.fensterquiz

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import java.util.*
import kotlin.collections.ArrayList

class SinglePlayerTTT : Fragment() {
    var button0 : Button? = null
    var button1 : Button? = null
    var button2 : Button? = null
    var button3 : Button? = null
    var button4 : Button? = null
    var button5 : Button? = null
    var button6 : Button? = null
    var button7 : Button? = null
    var button8 : Button? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mView = inflater.inflate(R.layout.fragment_single_player_ttt, container, false)

        var board = arrayListOf<String>("", "", "", "", "", "", "", "", "")
        val animZoom = AnimationUtils.loadAnimation(context, R.anim.zoom)
        val textViewTTT = mView.findViewById<TextView>(R.id.textViewTTT)
        textViewTTT.startAnimation(animZoom)

        button0 = mView.findViewById<Button>(R.id.button3)
        button1 = mView.findViewById<Button>(R.id.button4)
        button2 = mView.findViewById<Button>(R.id.button5)
        button3 = mView.findViewById<Button>(R.id.button7)
        button4 = mView.findViewById<Button>(R.id.button8)
        button5 = mView.findViewById<Button>(R.id.button1)
        button6 = mView.findViewById<Button>(R.id.button2)
        button7 = mView.findViewById<Button>(R.id.button6)
        button8 = mView.findViewById<Button>(R.id.button0)

        button0!!.setOnClickListener {
            if (board[0] == "") {
                button0!!.text = "X"
                board[0] = "X"
                Handler().postDelayed({
                    if (!isBoardFull(board) && !result(board, "X")) {
                        val position: Int = getComputerMove(board)
                        board[position] = "O"
                        displayComputerButton(position)
                        Handler().postDelayed({
                            resultOut(board)
                        },500)
                    }
                },500)
            }
            resultOut(board)
        }

        button1!!.setOnClickListener {
            if (board[1] == "") {
                button1!!.text = "X"
                board[1] = "X"
                Handler().postDelayed({
                    if (!isBoardFull(board) && !result(board, "X")) {
                        val position: Int = getComputerMove(board)
                        board[position] = "O"
                        displayComputerButton(position)
                        Handler().postDelayed({
                            resultOut(board)
                        },500)
                    }
                },500)
            }
            resultOut(board)
        }

        button2!!.setOnClickListener {
            if (board[2] == "") {
                button2!!.text = "X"
                board[2] = "X"
                Handler().postDelayed({
                    if (!isBoardFull(board) && !result(board, "X")) {
                        val position: Int = getComputerMove(board)
                        board[position] = "O"
                        displayComputerButton(position)
                        Handler().postDelayed({
                            resultOut(board)
                        },500)
                    }
                }, 500)
            }
            resultOut(board)
        }

        button3!!.setOnClickListener {
            if (board[3] == "") {
                button3!!.text = "X"
                board[3] = "X"
                Handler().postDelayed({
                    if (!isBoardFull(board) && !result(board, "X")) {
                        val position: Int = getComputerMove(board)
                        board[position] = "O"
                        displayComputerButton(position)
                        Handler().postDelayed({
                            resultOut(board)
                        },500)
                    }
                }, 500)
            }
            resultOut(board)
        }

        button4!!.setOnClickListener {
            if (board[4] == "") {
                button4!!.text = "X"
                board[4] = "X"
                Handler().postDelayed({
                    if (!isBoardFull(board) && !result(board, "X")) {
                        val position: Int = getComputerMove(board)
                        board[position] = "O"
                        displayComputerButton(position)
                        Handler().postDelayed({
                            resultOut(board)
                        },500)
                    }
                }, 500)
            }
            resultOut(board)
        }

        button5!!.setOnClickListener {
            if (board[5] == "") {
                button5!!.text = "X"
                board[5] = "X"
                Handler().postDelayed({
                    if (!isBoardFull(board) && !result(board, "X")) {
                        val position: Int = getComputerMove(board)
                        board[position] = "O"
                        displayComputerButton(position)
                        Handler().postDelayed({
                            resultOut(board)
                        },500)
                    }
                }, 500)
            }
            resultOut(board)
        }

        button6!!.setOnClickListener {
            if (board[6] == "") {
                button6!!.text = "X"
                board[6] = "X"
                Handler().postDelayed({
                    if (!isBoardFull(board) && !result(board, "X")) {
                        val position: Int = getComputerMove(board)
                        board[position] = "O"
                        displayComputerButton(position)
                        Handler().postDelayed({
                            resultOut(board)
                        },500)
                    }
                }, 500)
            }
            resultOut(board)
        }

        button7!!.setOnClickListener {
            if (board[7] == "") {
                button7!!.text = "X"
                board[7] = "X"
                Handler().postDelayed({
                    if (!isBoardFull(board) && !result(board, "X")) {
                        val position: Int = getComputerMove(board)
                        board[position] = "O"
                        displayComputerButton(position)
                        Handler().postDelayed({
                            resultOut(board)
                        },500)
                    }
                }, 500)
            }
            resultOut(board)
        }

        button8!!.setOnClickListener {
            if (board[8] == "") {
                button8!!.text = "X"
                board[8] = "X"
                Handler().postDelayed({
                    if (!isBoardFull(board) && !result(board, "X")) {
                        val position: Int = getComputerMove(board)
                        board[position] = "O"
                        displayComputerButton(position)
                        Handler().postDelayed({
                            resultOut(board)
                        },500)
                    }
                }, 500)
            }
            resultOut(board)
        }

        val HomeButton = mView.findViewById<Button>(R.id.HomeButtonTTT)
        HomeButton.setOnClickListener {
            this.fragmentManager!!.beginTransaction()
                .replace(R.id.fragmentPlace, StartPageTTT())
                .commit()
        }

        val ResetButton = mView.findViewById<Button>(R.id.buttonReset)
        ResetButton.setOnClickListener {
            this.fragmentManager!!.beginTransaction()
                .replace(R.id.fragmentPlace, SinglePlayerTTT())
                .commit()
        }

    return mView
    }

    private fun getComputerMove(board: ArrayList<String>): Int {

        //check if computer can win in this move
        for (i in 0..board.count() - 1) {
            var copy: ArrayList<String> = getBoardCopy(board)
            if (copy[i] == "") copy[i] = "O"
            if (result(copy, "O")) return i
        }

        //check if player could win in the next move
        for (i in 0..board.count() - 1) {
            var copy2 = getBoardCopy(board)
            if (copy2[i] == "") copy2[i] = "X"
            if (result(copy2, "X")) return i
        }

        //try to take corners if its free
        var move = choseRandomMove(board, arrayListOf<Int>(0, 2, 6, 8))
        if (move != -1)
            return move

        //try to take center if its free
        if (board[4] == "") return 4

        //move on one of the sides
        return choseRandomMove(board, arrayListOf<Int>(1, 3, 5, 7))
    }

    private fun choseRandomMove(board: ArrayList<String>, list: ArrayList<Int>): Int {
        var possibleMoves = arrayListOf<Int>()
        for (i in list) {
            if (board[i] == "") possibleMoves.add(i)
        }
        if (possibleMoves.isEmpty()) return -1
        else {
            var index = Random().nextInt(possibleMoves.count())
            return possibleMoves[index]
        }
    }

    private fun getBoardCopy(board: ArrayList<String>): ArrayList<String> {
        var bd = arrayListOf<String>("", "", "", "", "", "", "", "", "")
        for (i in 0..board.count() - 1) {
            bd[i] = board[i]
        }
        return bd
    }

    private fun isBoardFull(board: ArrayList<String>): Boolean {
        for (i in board)
            if (i != "X" && i != "O") return false
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

    private fun displayComputerButton(position: Int){
        if(position == 0) button0?.text = "O"
        else if(position == 1) button1?.text = "O"
        else if(position == 2) button2?.text = "O"
        else if(position == 3) button3?.text = "O"
        else if(position == 4) button4?.text = "O"
        else if(position == 5) button5?.text = "O"
        else if(position == 6) button6?.text = "O"
        else if(position == 7) button7?.text = "O"
        else if(position == 8) button8?.text = "O"
    }

    private fun resultOut(board: ArrayList<String>){
        if (result(board, "X")){
            val daten : Bundle = Bundle()
            daten.putString("winner", "X gewinnt! \nHerzlichen Glückwunsch")
            daten.putString("Fragment", "SinglePlayer")
            val WonFragment = WonFragmentTTT()
            WonFragment.arguments = daten
            this.fragmentManager!!.beginTransaction()
                .replace(R.id.fragmentPlace, WonFragment)
                .addToBackStack(null)
                .commit()

        } else if(result(board, "O")){
            val daten : Bundle = Bundle()
            val WonFragment = WonFragmentTTT()
            daten.putString("winner", "Computer gewinnt! \nVersuchs nochmal.")
            daten.putString("Fragment", "SinglePlayer")
            WonFragment.arguments = daten
            this.fragmentManager!!.beginTransaction()
                .replace(R.id.fragmentPlace, WonFragment)
                .addToBackStack(null)
                .commit()

        } else if(isBoardFull(board)){
            val daten : Bundle = Bundle()
            val WonFragment = WonFragmentTTT()
            daten.putString("winner", "Unentschieden. \nGleich nochmal!")
            daten.putString("Fragment", "SinglePlayer")
            WonFragment.arguments = daten
            this.fragmentManager!!.beginTransaction()
                .replace(R.id.fragmentPlace, WonFragment)
                .addToBackStack(null)
                .commit()
        }
    }
}