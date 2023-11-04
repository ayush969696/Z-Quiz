package com.myandayush.quizeapp.topics

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import com.myandayush.quizeapp.QuestionModel
import com.myandayush.quizeapp.R
import com.myandayush.quizeapp.ScoreActivity
import com.myandayush.quizeapp.databinding.ActivityScienceQuizBinding

class ScienceQuizActivity : AppCompatActivity() {
    private lateinit var binding: ActivityScienceQuizBinding

    private lateinit var list: ArrayList<QuestionModel>
    private var count: Int = 0;
    private var score: Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScienceQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list = ArrayList<QuestionModel>()
        val db = FirebaseFirestore.getInstance()
        db.collection("ScienceQz")
            .get().addOnSuccessListener { doc ->
                list.clear()
                for (i in doc.documents) {
                    var questionModel = i.toObject(QuestionModel::class.java)
                    list.add(questionModel!!)
                }
                binding.question.setText(list.get(0).question)
                binding.option1.setText(list.get(0).option1)
                binding.option2.setText(list.get(0).option2)
                binding.option3.setText(list.get(0).option3)
                binding.option4.setText(list.get(0).option4)
            }
            .addOnFailureListener { exception ->
                Toast.makeText(this, " " + exception, Toast.LENGTH_LONG).show();
            }

        binding.option1.setOnClickListener {
            NextData(binding.option1.text.toString())
        }
        binding.option2.setOnClickListener {
            NextData(binding.option2.text.toString())
        }
        binding.option3.setOnClickListener {
            NextData(binding.option3.text.toString())
        }
        binding.option4.setOnClickListener {
            NextData(binding.option4.text.toString())
        }
    }
    private fun NextData(i: String) {  // clicked option is 'i'
        if (count < list.size) {
            if (list.get(count).ans.equals(i)) {
                score++
            }
            count++
            if (count >= list.size) {
                val delayMillis = 3000L
                var intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("SCORE", score)
                intent.putExtra("QUESTIONS", list.size)
                binding.progressBar.visibility = View.VISIBLE

                android.os.Handler().postDelayed({
                    startActivity(intent)
                    finish()
                }, delayMillis)
            } else {
                binding.question.setText(list.get(count).question)
                binding.option1.setText(list.get(count).option1)
                binding.option2.setText(list.get(count).option2)
                binding.option3.setText(list.get(count).option3)
                binding.option4.setText(list.get(count).option4)
            }
        }
    }
}