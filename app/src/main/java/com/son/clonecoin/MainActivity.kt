package com.son.clonecoin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.son.clonecoin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 앱 초기 실행 시 홈화면으로 설정
        if (savedInstanceState == null) {
            binding.bottomNavigationView.selectedItemId = R.id.fragment_home
        }

        setBottomNavigationView()
    }

    private fun setBottomNavigationView() {


        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.fragment_home -> {changeScreen(coinMainFragment()); true}
                R.id.fragment_favorite -> {changeScreen(coinFavoriteFragment()); true}
                R.id.fragment_investment ->{changeScreen(coinInvestmentFragment()); true}
                R.id.fragment_money->{changeScreen(coinMoneyFragment()); true}
                else -> false

            }
        }
    }

    private fun changeScreen(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.main_container, fragment).commit()
    }
}