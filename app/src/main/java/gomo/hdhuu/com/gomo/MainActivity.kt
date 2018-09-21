package gomo.hdhuu.com.gomo

import android.arch.lifecycle.ViewModel
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import gomo.hdhuu.com.gomo.databinding.ActivityMainBinding
import gomo.hdhuu.com.gomo.models.DemoViewModel
import java.util.*
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.vm = DemoViewModel()
        val viewModel = binding.vm

        Timer().schedule(3000) {
            Log.e("start", "statr")
            viewModel!!.text.set("huuhoang deprai vui tinh")
            viewModel.age.set(111)
            viewModel.buttonVisible.set(false)
        }

    }
}
