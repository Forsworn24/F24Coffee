package mudinov.ali.f24coffee.presentation.Tabs.Account

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import mudinov.ali.f24coffee.R
import mudinov.ali.f24coffee.databinding.AccountBinding
import mudinov.ali.f24coffee.presentation.viewModels.OrderLocalViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class Account : Fragment() {

    private var binding: AccountBinding? = null
    private var orderAdapter: OrderAdapter? = null
    private val orderLocalViewModel: OrderLocalViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.account, container, false)

        initRecyclerOrder()

        loadOrders()

        binding?.clearOrders?.setOnClickListener(View.OnClickListener {
            orderLocalViewModel.clearOrders()
        })

        return binding?.root
    }


    private fun initRecyclerOrder() {

        binding?.listOrders?.layoutManager =
            LinearLayoutManager(context)
        orderAdapter = OrderAdapter()
        binding?.listOrders?.adapter = orderAdapter

    }

    private fun loadOrders() {

        orderLocalViewModel.loadOrder.observe(viewLifecycleOwner, Observer {
            orderAdapter?.setList(it)
            orderAdapter?.notifyDataSetChanged()

        })


    }


}