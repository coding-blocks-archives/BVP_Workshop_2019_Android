package com.codingblocks.bvpworkshopapp

import android.content.Context
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_discolights.*
import kotlin.math.roundToInt

class DIscolightsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_discolights)


        val sensorManager: SensorManager =
            getSystemService(Context.SENSOR_SERVICE) as SensorManager

        val accelSensor =
            sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        val sensorListener = object: SensorEventListener {
            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

            }

            override fun onSensorChanged(event: SensorEvent?) {
//                Log.d("ACCEL",
//                    "ax" + event!!.values[0])
//
//                Log.d("ACCEL",
//                    "ay" + event!!.values[1])
//
//                Log.d("ACCEL",
//                    "az" + event!!.values[2])

                event?.apply {
                    val r = (((values[0] + 12) / 24) * 255).roundToInt()
                    val g = (((values[1] + 12) / 24) * 255).roundToInt()
                    val b = (((values[2] + 12) / 24) * 255).roundToInt()

                    background.setBackgroundColor(
                        Color.rgb(r, g, b)
                    )
                }
            }

        }


        sensorManager.registerListener(
            sensorListener,
            accelSensor,
            1000 * 1000
        )
    }
}
