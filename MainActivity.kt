package ch.giime.fensterquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager


class MainActivity : AppCompatActivity() {
    val mManager =supportFragmentManager
    val mTransaction = mManager.beginTransaction()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)

        mTransaction.replace(R.id.fragmentPlace, StartPageFragment())
        mTransaction.addToBackStack(null)
        mTransaction.commit()
    }
}
