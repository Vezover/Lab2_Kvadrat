package com.example.kvadrat

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    private fun discriminant(a: Double, b: Double, c: Double) = (Math.sqrt(b) - 4 * a * c).toInt()

    private fun round(a:Double) : Double{
        val roundoff = (a * 100.0).roundToInt() / 100.0
        return roundoff
    }

    private fun Equation(a: Double, b: Double, c: Double): String {
        val discriminant = discriminant(a, b, c)
        if (a!==0.0){
            if (discriminant > 0) {
                val root1 = round((-b + Math.sqrt(discriminant.toDouble())) / (2 * a))
                val root2 = round((-b - Math.sqrt(discriminant.toDouble())) / (2 * a))
                return "Дискриминант D > 0, следовательно уравнение имеет два действительных корня: \nx1= $root1 \nx2= $root2"
            }
            else if (discriminant== 0) {
                val root2 = round(-b / (2 * a))
                return "Дискриминант D = 0, следовательно уравнение имеет один действительный корень: \nx1=x2=$root2"
            }
            else{
                return "Дискриминант D < 0, следовательно уравнение не имеет действительных корней"
            }
        }
        else if(c!=0.0 && b!=0.0)
        {
            val root= round(-c / b)
            return "Данное уравнение является линейным \nСледовательно оно имеет один корень x=$root"
        }
        else if(a==0.0 && c==0.0 && b==0.0)
        {
            return "При любых X будет верное равенство"
        }
        else return "Корней нет"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun OnResultButtonClick(view: View){
        val aKoeff=findViewById<EditText>(R.id.a).text.toString()
        val bKoeff=findViewById<EditText>(R.id.b).text.toString()
        val cKoeff=findViewById<EditText>(R.id.c).text.toString()
        val resTextView=findViewById<TextView>(R.id.answerText)
        val a=aKoeff.toDouble()
        val b=bKoeff.toDouble()
        val c=cKoeff.toDouble()
        val answer=Equation(a,b,c)
        resTextView.setText(answer)
        1    }
}