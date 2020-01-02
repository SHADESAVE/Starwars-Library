package com.example.starwarslib.list

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.starwarslib.MainActivity
import com.example.starwarslib.R
import com.example.starwarslib.databinding.FragmentListBinding
import com.example.starwarslib.network.StarWarsApiFilter
import com.example.starwarslib.network.StarWarsEntity

class ListFragment : Fragment() {

    /**
     * Lazily initialize our [ListViewModel].
     */

    private val viewModel: ListViewModel by lazy {
        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onActivityCreated()"
        }
        ViewModelProviders.of(this, ListViewModel.Factory(activity.application))
            .get(ListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        activity?.actionBar?.show()

        val binding = FragmentListBinding.inflate(inflater)

        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.lifecycleOwner = this

        // Giving the binding access to the OverviewViewModel
        binding.viewModel = viewModel

        val adapter = ListGridAdapter(ListGridAdapter.OnClickListener {
            viewModel.displayEntityDetails(it)
        })

        binding.entitiesGrid.adapter = adapter

        viewModel.navigateToSelectedStarWarsEntity.observe(this, Observer {
            if (null != it) {
                this.findNavController().navigate(ListFragmentDirections.actionShowDetail(it))
                viewModel.displayEntityComplete()
            }
        })

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.overflow_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        viewModel.updateFilter(
            when (item.itemId) {
                R.id.show_starships -> {
                    StarWarsApiFilter.SHOW_STARSHIPS
                }
                R.id.show_planets -> {
                    StarWarsApiFilter.SHOW_PLANETS
                }
                R.id.show_vehicles -> {
                    StarWarsApiFilter.SHOW_VEHICLES
                }
                R.id.show_species -> {
                    StarWarsApiFilter.SHOW_SPECIES
                }
                R.id.show_films -> {
                    StarWarsApiFilter.SHOW_FILMS
                }
                else-> {
                    StarWarsApiFilter.SHOW_PEOPLES
                }
            }
        )
        return true
    }
}