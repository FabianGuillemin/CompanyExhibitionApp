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


class SecondQuestionFragment : Fragment() {
    private var mRandom: Int = 0
    private var mPoints: Int = 0
    private var mAskCounter: Int = 0

    val QuestionList : QuestlionList = QuestlionList()
    var Points : Int = 0
    var AskCount : Int = 0
    var random : Int = 0
    var isAnswerRight : Boolean = false
    val handOverData = Bundle()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            mRandom = it.getInt("random")
            mPoints = it.getInt("points")
            mAskCounter = it.getInt("AskCounter")
        }
        Log.i("Test", "SecondPoints $mPoints, SecondRandom $mRandom, SecondAskCount $mAskCounter")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mView = inflater.inflate(R.layout.fragment_second_question, container,false)

        //val QuestionLayout = mView.findViewById<LinearLayout>(R.id.QuestionLinearLayout) as LinearLayout
        val AnswerLayout = mView.findViewById<LinearLayout>(R.id.AnswerLinearLayout) as LinearLayout

        var ArrayListSize = QuestionList.ListGenerator().size
        val furtherRandom = Random
        val furtherNumber = furtherRandom.nextInt(3 - 1) + 1
        random = if (mRandom > ArrayListSize - 3) {
            0
        } else {
            Log.i("Test", "furherNumber: $furtherNumber")
             mRandom + furtherNumber
        }

        AskCount = mAskCounter + 1
        Points = mPoints
        Log.i("Test", "SecondPoints $Points, SecondRandom $random, SecondAskCount $AskCount")

        //AskCounter anzeigen
        val AskCounterView = mView.findViewById<TextView>(R.id.askCounter)
        AskCounterView.text = "Frage ${AskCount.toString()}/5"

        // Punktestand anzeigen
        val PointsView = mView.findViewById<TextView>(R.id.PointsView)
        PointsView.text = "Punktestand: ${Points.toString()}"

        // Frage dem Layout hinzufügen
        var Question = mView.findViewById<TextView>(R.id.questionTextView)
        Question.text = "${QuestionList.ListGenerator().get(random).question}"

        // Antworten dem Layout hinzufügen
        var radiogroup = RadioGroup(mView.context)

        var Answer1 = RadioButton(mView.context)
        Answer1.text = "${QuestionList.ListGenerator().get(random).answer1}"
        Answer1.textSize = 26F
        Answer1.id = View.generateViewId()
        Answer1.tag = "1"
        Answer1.typeface = Typeface.createFromAsset(context?.assets, "acmeaddprj.ttf")
        radiogroup.addView(Answer1)

        var Answer2 = RadioButton(mView.context)
        Answer2.text = "${QuestionList.ListGenerator().get(random).answer2}"
        Answer2.textSize = 26F
        Answer2.id = View.generateViewId()
        Answer2.tag = "2"
        Answer2.typeface = Typeface.createFromAsset(context?.assets, "acmeaddprj.ttf")
        radiogroup.addView(Answer2)

        var Answer3 = RadioButton(mView.context)
        Answer3.text = "${QuestionList.ListGenerator().get(random).answer3}"
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

            if (AnswerReturn == QuestionList.ListGenerator().get(random).rightAnswer.toString()) {
                Points = Points + 1
                isAnswerRight = true
                val DetailFragment = DetailFragment()
                handOverData()
                DetailFragment.arguments = handOverData
                Log.i("Test", "RICHTIG! SecondPunktestand $Points, SecondisRight? $isAnswerRight SecondAskCount $AskCount SecondRandom $random")
                this.fragmentManager!!.beginTransaction()
                    .replace(R.id.fragmentPlace, DetailFragment)
                    //.addToBackStack(null)
                    .commit()
            } else {
                isAnswerRight = false
                val DetailFragment = DetailFragment()
                handOverData()
                DetailFragment.arguments = handOverData
                Log.i("Test", "RICHTIG! SecondPunktestand $Points, SecondisRight? $isAnswerRight SecondAskCount $AskCount SecondRandom $random")
                this.fragmentManager!!.beginTransaction()
                    .replace(R.id.fragmentPlace,DetailFragment)
                    //.addToBackStack(null)
                    .commit()
            }
        }

        val HomeButton = mView.findViewById<Button>(R.id.HomeButton)
        HomeButton.setOnClickListener {
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
        handOverData.putInt("random", random)
        handOverData.putInt("AskCounter", AskCount)
        handOverData.putBoolean("isRight", isAnswerRight)
    }
}
