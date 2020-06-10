package myxt.android.juegodecartas

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var count = 1
    var pressed = false
    var pressed2 = false
    var pressed3 = false
    var pressed4 = false
    var pressed5 = false
    var total = 0
    var partidasGanadas = 0

    var nextValues = MutableList(5) { Random.nextInt(1, 13) }

    var nombreCarta = "carta" + nextValues.get(0)
    var nombreCarta2 = "carta" + nextValues.get(1)
    var nombreCarta3 = "carta" + nextValues.get(2)
    var nombreCarta4 = "carta" + nextValues.get(3)
    var nombreCarta5 = "carta" + nextValues.get(4)

    var drawableResourceId = 0
    var drawableResourceId2 = 0
    var drawableResourceId3 = 0
    var drawableResourceId4 = 0
    var drawableResourceId5 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        chronometer1.start()
        drawableResourceId =
            this.resources.getIdentifier(nombreCarta, "drawable", this.packageName)
        drawableResourceId2 =
            this.resources.getIdentifier(nombreCarta2, "drawable", this.packageName)
        drawableResourceId3 =
            this.resources.getIdentifier(nombreCarta3, "drawable", this.packageName)
        drawableResourceId4 =
            this.resources.getIdentifier(nombreCarta4, "drawable", this.packageName)
        drawableResourceId5 =
            this.resources.getIdentifier(nombreCarta5, "drawable", this.packageName)

        imageView.setOnClickListener {
            if (count <= 3 && !pressed) {
                imageView.setImageResource(drawableResourceId)
                total += nextValues.get(0)
                editText5.setText(total.toString())
                count++
                pressed = true
            } else if (count <= 3 && pressed) {
                Log.d("onClickListener",
                    "Valores: count = $count y pressed = $pressed. No se realiza acción alguna"
                )
            } else if (count > 3 && !pressed) {
                checkAndShowFinalResult()
                restart()
            } else {
                checkAndShowFinalResult()
                restart()
            }
        }
        imageView2.setOnClickListener {

            if (count <= 3 && !pressed2) {
                imageView2.setImageResource(drawableResourceId2)
                total += nextValues.get(1)
                editText5.setText(total.toString())
                count++
                pressed2 = true
            } else if (count <= 3 && pressed2) {
                Log.d("onClickListener2",
                    "Valores: count = $count y pressed = $pressed. No se realiza acción alguna"
                )
            } else if (count > 3 && !pressed2) {
                checkAndShowFinalResult()
                restart()
            } else {
                checkAndShowFinalResult()
                restart()
            }
        }
        imageView3.setOnClickListener {
            if (count <= 3 && !pressed3) {
                imageView3.setImageResource(drawableResourceId3)
                total += nextValues.get(2)
                editText5.setText(total.toString())
                count++
                pressed3 = true
            } else if (count <= 3 && pressed3) {
                Log.d("onClickListener3",
                    "Valores: count = $count y pressed = $pressed. No se realiza acción alguna"
                )
            } else if (count > 3 && !pressed3) {
                checkAndShowFinalResult()
                restart()
            } else {
                checkAndShowFinalResult()
                restart()
            }
        }
        imageView4.setOnClickListener {
            if (count <= 3 && !pressed4) {
                imageView4.setImageResource(drawableResourceId4)
                total += nextValues.get(3)
                editText5.setText(total.toString())
                count++
                pressed4 = true
            } else if (count <= 3 && pressed4) {
                Log.d("onClickListener4",
                    "Valores: count = $count y pressed = $pressed. No se realiza acción alguna"
                )
            } else if (count > 3 && !pressed4) {
                checkAndShowFinalResult()
                restart()
            } else {
                checkAndShowFinalResult()
                restart()
            }
        }
        imageView5.setOnClickListener {
            if (count <= 3 && !pressed5) {
                imageView5.setImageResource(drawableResourceId5)
                total += nextValues.get(4)
                editText5.setText(total.toString())
                count++
                pressed5 = true
            } else if (count <= 3 && pressed5) {
                Log.d("onClickListener5",
                    "Valores: count = $count y pressed = $pressed. No se realiza acción alguna"
                )
            } else if (count > 3 && !pressed5) {
                checkAndShowFinalResult()
                restart()
            } else {
                checkAndShowFinalResult()
                restart()
            }
        }
    }

    private fun restart() {
        //val intent = Intent(this, MainActivity::class.java)
        //this.startActivity(intent)
        count = 1
        pressed = false
        pressed2 = false
        pressed3 = false
        pressed4 = false
        pressed5 = false
        total = 0

        nextValues = MutableList(5) { Random.nextInt(1, 13) }

        nombreCarta = "carta" + nextValues.get(0)
        nombreCarta2 = "carta" + nextValues.get(1)
        nombreCarta3 = "carta" + nextValues.get(2)
        nombreCarta4 = "carta" + nextValues.get(3)
        nombreCarta5 = "carta" + nextValues.get(4)

        drawableResourceId =
            this.resources.getIdentifier(nombreCarta, "drawable", this.packageName)
        drawableResourceId2 =
            this.resources.getIdentifier(nombreCarta2, "drawable", this.packageName)
        drawableResourceId3 =
            this.resources.getIdentifier(nombreCarta3, "drawable", this.packageName)
        drawableResourceId4 =
            this.resources.getIdentifier(nombreCarta4, "drawable", this.packageName)
        drawableResourceId5 =
            this.resources.getIdentifier(nombreCarta5, "drawable", this.packageName)

        imageView.setImageResource(R.drawable.cruz)
        imageView2.setImageResource(R.drawable.cruz)
        imageView3.setImageResource(R.drawable.cruz)
        imageView4.setImageResource(R.drawable.cruz)
        imageView5.setImageResource(R.drawable.cruz)

        editText5.setText("0")
        if(partidasGanadas==3)
            chronometer1.stop()
    }

    private fun checkAndShowFinalResult() {
        if (total < 20) {
            imageView6.setImageResource(R.drawable.ganador)
        }
        else if (total==20) {
            imageView6.setImageResource(R.drawable.loading)
            partidasGanadas++
            editText.setText(partidasGanadas.toString())
        }
        else
            imageView6.setImageResource(R.drawable.perdedor)
    }
}