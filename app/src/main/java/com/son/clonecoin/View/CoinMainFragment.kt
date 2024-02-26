package com.son.clonecoin.View

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.son.clonecoin.Base.BaseFragment
import com.son.clonecoin.R
import com.son.clonecoin.ViewModel.CoinMainFragmentViewModel

class CoinMainFragment : BaseFragment<ViewDataBinding>(R.layout.fragment_coin_main) {

    private val coinMainFragmentViewModel by lazy { ViewModelProvider(this)[CoinMainFragmentViewModel::class.java] }
    override fun init() {

    }
}