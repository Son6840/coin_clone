package com.son.clonecoin

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.son.clonecoin.databinding.ActivityMainBinding

class MainActivity: BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            binding.bottomNavigationView.selectedItemId = R.id.fragment_home
        }

    }
    override fun init() {
        setBottomNavigationView()
    }

    private fun setBottomNavigationView() {

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.fragment_home -> {changeScreen(CoinMainFragment()); true}
                R.id.fragment_favorite -> {changeScreen(CoinFavoriteFragment()); true}
                R.id.fragment_investment ->{changeScreen(CoinInvestmentFragment()); true}
                R.id.fragment_money->{changeScreen(CoinMoneyFragment()); true}
                else -> false

            }
        }
    }

    private fun changeScreen(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.main_container, fragment).commit()
    }
}