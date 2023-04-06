package com.example.example1
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.example1.databinding.ActivityMainBinding
import java.util.*

class MainActivity: AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //for clicking check button
        binding.checkBtn.setOnClickListener{
            var word1 = binding.etText1.text.toString()
            var word2 = binding.etText2.text.toString()

            val check: Boolean = isAnagram(word1, word2)
            if(check){
                Toast.makeText(this,"The words are Anagram",Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this,"The words are NOT Anagram",Toast.LENGTH_SHORT).show()
            }
        }
    }
    //isAnagram function
    private fun isAnagram(word1:String, word2:String):Boolean{
        if(word1.length!=word2.length)
            return false
        val str1 = word1.toCharArray()
        val str2 = word2.toCharArray()
        Arrays.sort(str1)
        Arrays.sort(str2)
        val sorted1 = String(str1)
        val sorted2 = String(str2)
        return sorted1==sorted2
    }
}

