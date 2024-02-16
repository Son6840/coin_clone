package com.son.clonecoin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<T: ViewDataBinding>(@LayoutRes val layoutResId: Int): Fragment() {

    private var _viewDataBinding: T? = null
    protected val viewDataBinding get() = _viewDataBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _viewDataBinding = DataBindingUtil.inflate(inflater, layoutResId, container, false)

        return viewDataBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding?.lifecycleOwner = viewLifecycleOwner
        init()
    }

    protected abstract fun init()

    override fun onDestroyView() {
        super.onDestroyView()
        _viewDataBinding = null
    }


}