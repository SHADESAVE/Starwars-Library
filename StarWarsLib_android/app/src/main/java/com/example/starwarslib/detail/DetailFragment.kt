package com.example.starwarslib.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import com.example.starwarslib.databinding.FragmentDetailBinding
import kotlinx.android.synthetic.main.activity_main.*

class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        @Suppress("UNUSED_VARIABLE")
        val application = requireNotNull(activity).application

        val binding = FragmentDetailBinding.inflate(inflater)

        binding.lifecycleOwner = this

        val entityProperty = DetailFragmentArgs.fromBundle(arguments!!).selectedProperty

        val viewModelFactory = DetailViewModelFactory(entityProperty, application)

        binding.viewModel = ViewModelProviders.of(this, viewModelFactory).get(DetailViewModel::class.java)

        return binding.root
    }
}