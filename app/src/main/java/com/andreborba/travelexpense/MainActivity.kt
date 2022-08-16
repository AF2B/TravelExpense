package com.andreborba.travelexpense

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.andreborba.travelexpense.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
	private lateinit var binding: ActivityMainBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)

		binding.buttonCalculate.setOnClickListener(this)
//        binding.buttonCalculate.setOnClickListener(object : View.OnClickListener {
//            override fun onClick(v: View?) {
//                TODO("Not yet implemented")
//            }
//        })
		}

	override fun onClick(view: View) {
		if (view.id == R.id.button_calculate) {
			calculate()
		}
	}

	private fun calculate() {
		if (isValid()) {
			val distance = binding.editDistance.text.toString().toFloat()
			val price = binding.editPrice.text.toString().toFloat()
			val autonomy = binding.editAutonomy.text.toString().toFloat()

			val result = (distance / autonomy) * price
			val resultFormatted = "%.2f".format(result)

			binding.textTotalPrice.text = resultFormatted
						//Toast.makeText(this, resultFormatted, Toast.LENGTH_SHORT).show()
		}
	}

	private fun isValid(): Boolean {
		if (binding.editDistance.text.toString()
				.isEmpty() || binding.editPrice.text.toString()
				.isEmpty() || binding.editAutonomy.text.toString()
				.isEmpty() && binding.editAutonomy.text.toString().toFloat() != 0.0f
				) {
						Toast.makeText(this, R.string.validate_fill_fields, Toast.LENGTH_LONG).show()
				}
			return true
		}
}