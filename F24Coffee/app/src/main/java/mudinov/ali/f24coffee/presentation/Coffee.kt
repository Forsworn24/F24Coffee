package mudinov.ali.f24coffee.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageButton
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import mudinov.ali.f24coffee.R
import mudinov.ali.f24coffee.data.models.CoffeeModel
import mudinov.ali.f24coffee.databinding.CoffeeBinding
import mudinov.ali.f24coffee.presentation.viewModel.CoffeeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class Coffee : Fragment() {

    private var binding: CoffeeBinding? = null
    private var coffeeAdapter: CoffeeAdapter? = null
    private val coffeeViewModel: CoffeeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.coffee, container, false)

        initRecyclerCoffee()
        loadCoffee()

        return binding?.root
    }

    private fun initRecyclerCoffee() {
        binding?.catalogCoffee?.layoutManager = LinearLayoutManager(context)
        coffeeAdapter = CoffeeAdapter()
        binding?.catalogCoffee?.adapter = coffeeAdapter
    }

    private fun loadCoffee() {
        coffeeViewModel.loadCoffee.observe(viewLifecycleOwner, Observer {
            coffeeAdapter?.setList(it)
            coffeeAdapter?.notifyDataSetChanged()
        })
    }

}