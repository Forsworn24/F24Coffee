package mudinov.ali.f24coffee.presentation.Tabs.Account

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import mudinov.ali.f24coffee.R
import mudinov.ali.f24coffee.data.models.OrderLocalModel
import mudinov.ali.f24coffee.databinding.OrderItemBinding

class OrderAdapter :
    RecyclerView.Adapter<OrderAdapter.CheckoutHolder>() {

    private val orders = ArrayList<OrderLocalModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CheckoutHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: OrderItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.order_item, parent, false)
        return CheckoutHolder(binding)
    }

    override fun getItemCount(): Int {
        return orders.size
    }



    override fun onBindViewHolder(holder: CheckoutHolder, position: Int) {
        holder.bind(orders[position])

    }

    fun setList(orderList: List<OrderLocalModel>) {
        orders.clear()
        orders.addAll(orderList)

    }



    class CheckoutHolder(val binding: OrderItemBinding) : RecyclerView.ViewHolder(binding.root) {


        fun bind(
            orderModel: OrderLocalModel
        ) {

            binding.nameUserCheckout.text = orderModel.nameUser
            binding.phoneUserCheckout.text = orderModel.phoneUser
            binding.descriptionCheckout.text = orderModel.description
            binding.totalPriceCheckout.text = orderModel.totalPrice

        }






    }

}