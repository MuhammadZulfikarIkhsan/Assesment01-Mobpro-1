package org.d3if2049.hitungenergipotensial

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import org.d3if2049.hitungenergipotensial.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonEnergi.setOnClickListener { hitungEnergi() }
        binding.resetButton.setOnClickListener { resetButton() }
    }

    @SuppressLint("StringFormatMatches")
    private fun hitungEnergi() {
        val massa = binding.massaBendaInp.text.toString()
        if (TextUtils.isEmpty(massa)) {
            Toast.makeText(this, R.string.massa_invalid, Toast.LENGTH_LONG).show()
            return
        }
        val gravitasi = binding.percepatanGravitasiInp.text.toString()
        if (TextUtils.isEmpty(gravitasi)) {
            Toast.makeText(this, R.string.gravitasi_invalid, Toast.LENGTH_LONG).show()
            return
        }
        val meter = binding.tinggiBendaInp.text.toString()
        if (TextUtils.isEmpty(meter)) {
            Toast.makeText(this, R.string.meter_invalid, Toast.LENGTH_LONG).show()
            return
        }
        val tinggiMeter = meter.toFloat()
        val percepatanGravitasi = gravitasi.toFloat()
        val energi = massa.toFloat() * percepatanGravitasi * tinggiMeter
        binding.energiPotensialTextView.text = getString(R.string.ep_x, energi)
    }

    // Reset Button
    private fun resetButton() {
        val massa = binding.massaBendaInp.text.toString()
        val gravitasi = binding.percepatanGravitasiInp.text.toString()
        val meter = binding.tinggiBendaInp.text.toString()

        if (massa.isEmpty() && gravitasi.isEmpty() && meter.isEmpty()) {
            Toast.makeText(this, "Sudah Kosong!", Toast.LENGTH_LONG).show()
        } else {
            binding.massaBendaInp.setText("")
            binding.percepatanGravitasiInp.setText("")
            binding.tinggiBendaInp.setText("")
            binding.energiPotensialTextView.text = ""
            binding.massaBendaInp.requestFocus()
            return
        }
    }
}