package com.myandayush.quizeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.myandayush.quizeapp.databinding.ActivityScoreBinding
import com.myandayush.quizeapp.topics.QuizActivity

class ScoreActivity : AppCompatActivity() {
    private lateinit var binding: ActivityScoreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScoreBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var score = intent.getIntExtra("SCORE", 0)
        var totalscore = intent.getIntExtra("QUESTIONS", 0)

        binding.textView4.setText("${score}")
        binding.textView5.setText(" / ${totalscore}")

        binding.homeBtn.setOnClickListener {
            var intent = Intent(this,HomeActivity::class.java)
            var delayMillis = 3000L
            binding.progressBar.visibility = View.VISIBLE
            android.os.Handler().postDelayed({
                startActivity(intent)
                finish()
            }, delayMillis)
        }
        binding.shareBtn.setOnClickListener {
            var intent = Intent(Intent.ACTION_SEND)
            intent.setType("text/plain")
            intent.putExtra(Intent.EXTRA_TEXT, "Hey there! I just finished playing Z-Quiz" +
                    " and I'm thrilled to share my score with you. I scored ${score} " +
                    "points out of ${totalscore}! It was such a fun and challenging quiz." +
                    " Can you beat my score? Give it a try and let's see who's the true quiz champ! " +
                    "\uD83C\uDFC6 #QuizChallenge #FunTimes")
            startActivity(intent)
        }
    }
}