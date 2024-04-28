package com.example.kronometreuygulamas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.LayoutInflater
import android.view.View
import com.example.kronometreuygulamas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var zamanDurma:Long=0
        binding.buttonStart.setOnClickListener {
        binding.kronometre.base=SystemClock.elapsedRealtime()+zamanDurma //kronometrenin durduğu yerden devam etmesi için zamanDurma yı ekliyoruz.
            binding.kronometre.start() //Kronometreyi başlatma
            binding.buttonStart.visibility=View.GONE // start buttonunu göstermeyi bıraktık
            binding.buttonStop.visibility=View.VISIBLE //Stop buttonunu gösteriyoruz
            binding.imageViewStart.setImageDrawable(getDrawable(R.drawable.pause))

        }

        binding.buttonStop.setOnClickListener {
            zamanDurma=binding.kronometre.base-SystemClock.elapsedRealtime() //kronometrenin durduğu yerden devam etmesi için zamanDurma yı ekliyoruz.
            binding.kronometre.stop() //Kronometreyi durdurma
            binding.buttonStop.visibility=View.GONE
            binding.buttonStart.visibility=View.VISIBLE
            binding.imageViewStart.setImageDrawable(getDrawable(R.drawable.start))

        }

        binding.buttonReset.setOnClickListener {
            binding.kronometre.base=SystemClock.elapsedRealtime()
            binding.kronometre.stop() //Kronometreyi durdurma
            zamanDurma=0 //zamanı 0lama
            binding.buttonStop.visibility=View.GONE
            binding.buttonStart.visibility=View.VISIBLE

            binding.imageViewStart.setImageDrawable(getDrawable(R.drawable.start))
        }
    }
}