package ch.giime.fensterquiz


import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageButton

class StartPageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mView = inflater.inflate(R.layout.fragment_start_page, container, false)
        val animZoom = AnimationUtils.loadAnimation(context, R.anim.zoom)

        val StartButtonQuiz = mView.findViewById<ImageButton>(R.id.StartButtonQuiz)
        StartButtonQuiz.startAnimation(animZoom)
        StartButtonQuiz.setOnClickListener {
            val FirstQuestionFragment = FirstQuestionFragment()
            this.fragmentManager?.beginTransaction()
                ?.replace(R.id.fragmentPlace, FirstQuestionFragment)
                ?.addToBackStack(null)
                ?.commit()
        }

        val StartTicTacToe = mView.findViewById<ImageButton>(R.id.StartTicTacToe)
        StartTicTacToe.startAnimation(animZoom)
        StartTicTacToe.setOnClickListener{
            val StartPageTTT = StartPageTTT()
            this.fragmentManager?.beginTransaction()
                ?.replace(R.id.fragmentPlace, StartPageTTT)
                ?.addToBackStack(null)
                ?.commit()
        }

        val StartMemory = mView.findViewById<ImageButton>(R.id.StartMemory)
        StartMemory.startAnimation(animZoom)
        StartMemory.setOnClickListener{
            val MemoryFragment = MemoryFragment()
            this.fragmentManager?.beginTransaction()
                ?.replace(R.id.fragmentPlace, MemoryFragment)
                ?.addToBackStack(null)
                ?.commit()
        }
        return mView
    }
}
