package ch.giime.fensterquiz

import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import ch.giime.fensterquiz.R.drawable.*

class MemoryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mView = inflater.inflate(R.layout.fragment_memory,container,false)
        val button1 = mView.findViewById<Button>(R.id.button1)
        val button2 = mView.findViewById<Button>(R.id.button2)
        val button3 = mView.findViewById<Button>(R.id.button3)
        val button4 = mView.findViewById<Button>(R.id.button4)
        val button5 = mView.findViewById<Button>(R.id.button5)
        val button6 = mView.findViewById<Button>(R.id.button6)
        val button7 = mView.findViewById<Button>(R.id.button7)
        val button8 = mView.findViewById<Button>(R.id.button8)
        val button9 = mView.findViewById<Button>(R.id.button9)
        val button10 = mView.findViewById<Button>(R.id.button10)
        val button11 = mView.findViewById<Button>(R.id.button11)
        val button12 = mView.findViewById<Button>(R.id.button12)
        val button13 = mView.findViewById<Button>(R.id.button13)
        val button14 = mView.findViewById<Button>(R.id.button14)
        val button15 = mView.findViewById<Button>(R.id.button15)
        val button16 = mView.findViewById<Button>(R.id.button16)
        val button17 = mView.findViewById<Button>(R.id.button17)
        val button18 = mView.findViewById<Button>(R.id.button18)
        val button19 = mView.findViewById<Button>(R.id.button19)
        val button20 = mView.findViewById<Button>(R.id.button20)
        val button21 = mView.findViewById<Button>(R.id.button21)
        val button22 = mView.findViewById<Button>(R.id.button22)
        val button23 = mView.findViewById<Button>(R.id.button23)
        val button24 = mView.findViewById<Button>(R.id.button24)

        val images : MutableList<Int> = mutableListOf(
            alpstegquizlogo,
            ausstellungeins,
            ausstellungzwei,
            ausstellungdrei,
            ausstellungvier,
            ausstellungfuenf,
            einbrecher,
            einbruchschutz,
            logoohnename,
            memorylogo,
            tictactoelogo,
            steg,
            alpstegquizlogo,
            ausstellungeins,
            ausstellungzwei,
            ausstellungdrei,
            ausstellungvier,
            ausstellungfuenf,
            einbrecher,
            einbruchschutz,
            logoohnename,
            memorylogo,
            tictactoelogo,
            steg
        )

        val buttons :Array<Button> = arrayOf(button1,button2,button3,button4,button5,button6,button7,button8,button9,button10,button11,button12,button13,button14,button15,button16,button17,button18,button19,button20,button21,button22,button23,button24)
        val cardBack : Int = holz
        var clicked = 0
        var turnOver = false
        var lastClicked = -1

        images.shuffle()
        for (i : Int in 0..23){
            buttons[i].setBackgroundResource(cardBack)
            buttons[i].text = "cardBack"
            buttons[i].textSize = 0.0F
            buttons[i].setOnClickListener {
                if (buttons[i].text == "cardBack" && !turnOver) {
                    buttons[i].setBackgroundResource(images[i])
                    buttons[i].setText(images[i])
                    if (clicked == 0) {
                        lastClicked = i
                    }
                    clicked++
                } else if (buttons[i].text !in "cardBack" && !turnOver) {
                    Toast.makeText(context, "Zuerst zweite Karte aufdecken", Toast.LENGTH_SHORT).show()
                } else if (buttons[i].text !in "cardBack") {
                    buttons[i].setBackgroundResource(cardBack)
                    buttons[i].text = "cardBack"
                    clicked--
                } else if (clicked == 2 && buttons[i].text != buttons[lastClicked].text){
                    Toast.makeText(context, "Zuerst nicht passende Karten wieder verdecken", Toast.LENGTH_SHORT).show()
                }

                if (clicked == 2) {
                    turnOver = true
                    if (buttons[i].text == buttons[lastClicked].text) {
                        buttons[i].isClickable = false
                        buttons[lastClicked].isClickable = false
                        turnOver = false
                        clicked = 0
                    }
                } else if (clicked == 0) {
                    turnOver = false
                }
            }
        }

        val homeButton = mView.findViewById<Button>(R.id.homeButtonMemory)
        homeButton.setOnClickListener {
            this.fragmentManager!!.beginTransaction()
                .replace(R.id.fragmentPlace, StartPageFragment())
                .commit()
        }

        val resetButton = mView.findViewById<Button>(R.id.buttonReset)
        resetButton.setOnClickListener {
            this.fragmentManager!!.beginTransaction()
                .replace(R.id.fragmentPlace, MemoryFragment())
                .commit()
        }
        return mView
    }
}