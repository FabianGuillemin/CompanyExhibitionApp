package ch.giime.fensterquiz


import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlin.random.Random

class FirstQuestionFragment : Fragment() {
    val QuestionList : QuestlionList = QuestlionList()
    var AskCounter : Int = 1
    var Points : Int = 0
    var randomnumber : Int = 0
    var isAnswerRight : Boolean = false
    val handOverData = Bundle()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mView = inflater.inflate(R.layout.fragment_first_question, container, false)

        // Randomzahl generieren
        val random = Random
        var ArraySize = QuestionList.ListGenerator().size
        randomnumber = random.nextInt(ArraySize - 1) + 1
        Log.i("Test", "Firstrandom $randomnumber Listengrösse: $ArraySize")

        //val QuestionLayout = mView.findViewById<TextView>(R.id.QuestionLinearLayout) as LinearLayout
        val AnswerLayout = mView.findViewById<LinearLayout>(R.id.AnswerLinearLayout) as LinearLayout

        //AskCounter anzeigen
        val AskCounterView = mView.findViewById<TextView>(R.id.askCounter)
        AskCounterView.text = "Frage ${AskCounter.toString()}/5"

        // Punktestand anzeigen
        val PointsView = mView.findViewById<TextView>(R.id.PointsView)
        PointsView.text = "Punktestand: $Points"

        // Frage dem Layout hinzufügen
        var Question = mView.findViewById<TextView>(R.id.questionTextView)
        Question.text = "${QuestionList.ListGenerator().get(randomnumber).question}"

        // Antworten der View hinzufügen
        var radiogroup = RadioGroup(mView.context)

        var Answer1 = RadioButton(mView.context)
        Answer1.text = "${QuestionList.ListGenerator().get(randomnumber).answer1}"
        Answer1.textSize = 26F
        Answer1.id = View.generateViewId()
        Answer1.tag = "1"
        Answer1.typeface = Typeface.createFromAsset(context?.assets, "acmeaddprj.ttf")
        radiogroup.addView(Answer1)

        var Answer2 = RadioButton(mView.context)
        Answer2.text = "${QuestionList.ListGenerator().get(randomnumber).answer2}"
        Answer2.textSize = 26F
        Answer2.id = View.generateViewId()
        Answer2.tag = "2"
        Answer2.typeface = Typeface.createFromAsset(context?.assets, "acmeaddprj.ttf")
        radiogroup.addView(Answer2)

        var Answer3 = RadioButton(mView.context)
        Answer3.text = "${QuestionList.ListGenerator().get(randomnumber).answer3}"
        Answer3.textSize = 26F
        Answer3.id = View.generateViewId()
        Answer3.tag = "3"
        Answer3.typeface = Typeface.createFromAsset(context?.assets, "acmeaddprj.ttf")
        radiogroup.addView(Answer3)

        AnswerLayout.addView(radiogroup)

        val CheckButton = mView.findViewById<Button>(R.id.CheckButton)
        CheckButton.setOnClickListener {
            val klickid = radiogroup.checkedRadioButtonId
            val SelectButton = mView?.findViewById<RadioButton>(klickid)
            val AnswerReturn = SelectButton?.tag

            if (AnswerReturn == QuestionList.ListGenerator().get(randomnumber).rightAnswer.toString()) {
                Points = + 1
                isAnswerRight = true
                val DetailFragment = DetailFragment()
                handOverData()
                DetailFragment.arguments = handOverData
                Log.i("Test", "RICHTIG! Punktestand $Points, isRight? $isAnswerRight AskCount $AskCounter Random $randomnumber")
                this.fragmentManager!!.beginTransaction()
                    .replace(R.id.fragmentPlace, DetailFragment)
                    //.addToBackStack(null)
                    .commit()
            } else {
                isAnswerRight = false
                val DetailFragment = DetailFragment()
                handOverData()
                DetailFragment.arguments = handOverData
                Log.i("Test", "FALSCH! Punktestand $Points, isRight? $isAnswerRight AskCount $AskCounter Random $randomnumber")
                this.fragmentManager!!.beginTransaction()
                    .replace(R.id.fragmentPlace,DetailFragment)
                    //.addToBackStack(null)
                    .commit()
            }
        }

        val HomeButton = mView.findViewById<Button>(R.id.HomeButton)
        HomeButton.setOnClickListener {
            Log.i("Test", "Punktestand $Points is Answer right? $isAnswerRight")
            this.fragmentManager?.beginTransaction()
                ?.replace(R.id.fragmentPlace, StartPageFragment())
                ?.addToBackStack(null)
                ?.commit()
        }
        return mView
    }
    // Übergabewerte definieren
    fun handOverData() {
        handOverData.putInt("points", Points)
        handOverData.putInt("random", randomnumber)
        handOverData.putInt("AskCounter", AskCounter)
        handOverData.putBoolean("isRight", isAnswerRight)
    }
}


