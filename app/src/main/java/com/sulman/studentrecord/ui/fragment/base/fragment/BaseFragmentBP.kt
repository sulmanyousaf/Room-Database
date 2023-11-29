package com.sulman.studentrecord.ui.fragment.base.fragment

import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import androidx.viewbinding.ViewBinding
import com.sulman.studentrecord.utils.extensions.registerBackPress

/*
* Fragment should be extended by all fragment
* that requires back press but having no viewModel
* */
abstract class BaseFragmentBP<VB : ViewBinding>(
    inflate: Inflate<VB>,
) : BaseFragmentVB<VB>(inflate), IBackPress {

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        registerBackPress(::onBackPressed)
    }

}