package ch.giime.fensterquiz


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class FinalFragment : Fragment() {
    private var mPoints: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            mPoints = it.getInt("points")
        }
        Log.i("Test", "FinalPoints $mPoints")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mView = inflater.inflate(R.layout.fragment_final, container, false)

        val finalPointsView = mView.findViewById<TextView>(R.id.FinalPointsView)
        var points = mPoints
        when (points){
            0 -> finalPointsView.text = "Leider keinen Punkt. \n\nMachen Sie noch etwas weiter und werden Sie besser!"
            1 -> finalPointsView.text = "Eine Frage war richtig! \n\nAber da liegt noch mehr drin!"
            2 -> finalPointsView.text = "Mmmhhh... \n\nUnteres drittel aber doch zwei Fragen richtig beantwortet! Weiter so!"
            3 -> finalPointsView.text = "Doch doch! \n\nGanz gute Arbeit! Drei von fünf Fragen wurden richtig beantwortet!"
            4 -> finalPointsView.text = "Sehr gut! \n\nBis auf eine Frage alles richtig beantwortet!"
            5 -> finalPointsView.text = "Alles richtig beantwortet! \n\nWas soll man dazu sagen!? \nDas ist ein Fensterprofi!"
        }

        val pointsView = mView.findViewById<TextView>(R.id.pointsView)
        pointsView.text = "Punktestand $points von 5"

        val homeButton = mView.findViewById<Button>(R.id.HomeButton)
        homeButton.setOnClickListener {
            val startPageFragment = StartPageFragment()
            this.fragmentManager?.beginTransaction()
                ?.replace(R.id.fragmentPlace, startPageFragment)
                //?.addToBackStack(null)
                ?.commit()
        }
        return mView
    }

}
