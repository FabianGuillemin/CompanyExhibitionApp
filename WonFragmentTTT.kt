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

class WonFragmentTTT : Fragment() {
    private var mWinner : String? = null
    private var mFragment : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            mWinner = it.getString("winner")
            mFragment = it.getString("Fragment")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mView = inflater.inflate(R.layout.fragment_won_ttt, container,false)

        val animZoom = AnimationUtils.loadAnimation(context, R.anim.zoom)
        val animSlide = AnimationUtils.loadAnimation(context, R.anim.slide)

        val textViewTTT = mView.findViewById<TextView>(R.id.textViewTTT)
        textViewTTT.startAnimation(animZoom)

        val textViewWinner = mView.findViewById<TextView>(R.id.textViewWinner)
        textViewWinner.text = mWinner.toString()
        textViewWinner.startAnimation(animSlide)

        val HomeButton = mView.findViewById<Button>(R.id.HomeButton)
        HomeButton.setOnClickListener {
            this.fragmentManager!!.beginTransaction()
                .replace(R.id.fragmentPlace, StartPageTTT())
                .commit()
        }

        val AgainButton = mView.findViewById<Button>(R.id.AgainButton)
        AgainButton.setOnClickListener {
            if (mFragment == "SinglePlayer") {
                this.fragmentManager!!.beginTransaction()
                    .replace(R.id.fragmentPlace, SinglePlayerTTT())
                    .commit()
            } else if (mFragment == "TwoPlayer"){
                this.fragmentManager!!.beginTransaction()
                    .replace(R.id.fragmentPlace, TwoPlayerTTT())
                    .commit()
            }
        }

        return mView
    }
}