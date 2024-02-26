package com.son.clonecoin

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.son.clonecoin.Base.BaseActivity
import com.son.clonecoin.View.CoinFavoriteFragment
import com.son.clonecoin.View.CoinInvestmentFragment
import com.son.clonecoin.View.CoinMainFragment
import com.son.clonecoin.View.CoinMoneyFragment
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
                R.id.fragment_home -> {changeScreen(CoinMainFragment(), getString(R.string.title_main)); true}
                R.id.fragment_favorite -> {changeScreen(CoinFavoriteFragment(), getString(R.string.title_favorite)); true}
                R.id.fragment_investment ->{changeScreen(CoinInvestmentFragment(), getString(R.string.title_investment)); true}
                R.id.fragment_money->{changeScreen(CoinMoneyFragment(), getString(R.string.title_money)); true}
                else -> false

            }
        }
    }

    private fun changeScreen(fragment: Fragment, title: String) {
        supportFragmentManager.beginTransaction().replace(R.id.main_container, fragment).commit()
        binding.topBarTitle.text = title
    }
}