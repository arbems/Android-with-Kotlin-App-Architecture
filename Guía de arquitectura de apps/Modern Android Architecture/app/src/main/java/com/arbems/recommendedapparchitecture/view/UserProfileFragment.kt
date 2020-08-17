package com.arbems.recommendedapparchitecture.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.observe
import com.arbems.recommendedapparchitecture.R
import com.arbems.recommendedapparchitecture.viewmodel.UserProfileViewModel

class UserProfileFragment : Fragment() {

    companion object {
        fun newInstance() =
            UserProfileFragment()
    }

    private val viewModel: UserProfileViewModel by viewModels(
        factoryProducer = {
            SavedStateViewModelFactory(
                activity?.application!!,
                this
            )
        })

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.user_profile_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.user.observe(viewLifecycleOwner) {
            // update UI
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

}