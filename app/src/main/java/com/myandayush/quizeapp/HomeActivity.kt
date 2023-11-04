package com.myandayush.quizeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.myandayush.quizeapp.databinding.ActivityHomeBinding
import com.myandayush.quizeapp.topics.GeneralKnowledgeQuiz
import com.myandayush.quizeapp.topics.HistoryActivity
import com.myandayush.quizeapp.topics.MathematicQuiz
import com.myandayush.quizeapp.topics.QuizActivity
import com.myandayush.quizeapp.topics.ScienceQuizActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.programingQuz.setOnClickListener {
            val intent = Intent(this, QuizActivity::class.java)
            startActivity(intent)
        }
        binding.generalknowledge.setOnClickListener {
            val intent = Intent(this, GeneralKnowledgeQuiz::class.java)
            startActivity(intent)
        }
        binding.scienceQuz.setOnClickListener {
            val intent = Intent(this,ScienceQuizActivity::class.java)
            startActivity(intent)
        }
        binding.mathematicsQz.setOnClickListener {
            val intent = Intent(this,MathematicQuiz::class.java)
            startActivity(intent)
        }
        binding.historyQz.setOnClickListener {
            val intent = Intent(this,HistoryActivity::class.java)
            startActivity(intent)
        }
    }
}