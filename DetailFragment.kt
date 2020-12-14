package ch.giime.fensterquiz


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class DetailFragment : Fragment() {
    private var mPoints : Int = 0
    private var mRandom : Int = 0
    private var mAskCounter : Int = 0
    private var mIsAnswerRight : Boolean = false

    val QuestionList : QuestlionList = QuestlionList()
    var Points : Int = 0
    var AskCount : Int = 0
    var random : Int = 0
    var isAnswerRight : Boolean = false
    val handOverData = Bundle()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            mPoints = it.getInt("points")
            mRandom = it.getInt("random")
            mAskCounter = it.getInt("AskCounter")
            mIsAnswerRight = it.getBoolean("isRight")
        }
        Log.i("Test", "DetailPoints $mPoints, DetailRandom $mRandom, DetailAskCount $mAskCounter, DetailisRight $mIsAnswerRight")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mView = inflater.inflate(R.layout.fragment_detail, container,false)

        Points = mPoints
        AskCount = mAskCounter
        isAnswerRight = mIsAnswerRight
        random = mRandom
        Log.i("Test", "DetailPoints2 $Points, DetailRandom2 $random, DetailAskCount2 $AskCount, DetailisRight2 $isAnswerRight")

        val detailTextView = mView.findViewById<TextView>(R.id.detailTextView)
        when (isAnswerRight){
            true -> detailTextView.text = "Richtig! \n${QuestionList.ListGenerator().get(random).explanation}"
            false -> detailTextView.text = "Leider falsch. \nDie richtige Antwort wäre: \n${QuestionList.ListGenerator().get(random).explanation}"
        }

        // Punktestand anzeigen
        val PointsView = mView.findViewById<TextView>(R.id.pointsView)
        PointsView.text = "Punktestand: ${Points.toString()}"

        // AskCounter anzeigen
        val AskCounter = mView.findViewById<TextView>(R.id.askCounter)
        AskCounter.text = "Frage ${AskCount.toString()}/5"


        val homeButton = mView.findViewById<Button>(R.id.homeButton)
        homeButton.setOnClickListener {
            this.fragmentManager?.beginTransaction()
                ?.replace(R.id.fragmentPlace, StartPageFragment())
                ?.addToBackStack(null)
                ?.commit()
        }

        val furtherButton = mView.findViewById<Button>(R.id.furtherButton)
        furtherButton.setOnClickListener {
            if (AskCount != 5) {
                val SecondQuestionFragment = SecondQuestionFragment()
                handOverData()
                SecondQuestionFragment.arguments = handOverData
                Log.i(
                    "Test", "DetailSendPoints $Points, DetailSendRandom $random, DetailSendAskCount $AskCount, DetailisSendRight $isAnswerRight")
                this.fragmentManager?.beginTransaction()
                    ?.replace(R.id.fragmentPlace, SecondQuestionFragment)
                    //?.addToBackStack(null)
                    ?.commit()
            } else {
                val finalFragment = FinalFragment()
                handOverData()
                finalFragment.arguments = handOverData
                this.fragmentManager?.beginTransaction()
                    ?.replace(R.id.fragmentPlace, finalFragment)
                    //?.addToBackStack(null)
                    ?.commit()
            }
        }
        return mView
    }

    fun handOverData() {
        handOverData.putInt("points", Points)
        handOverData.putInt("random", random)
        handOverData.putInt("AskCounter", AskCount)
    }

}
