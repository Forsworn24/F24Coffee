package mudinov.ali.f24coffee.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageButton
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import mudinov.ali.f24coffee.R
import mudinov.ali.f24coffee.data.models.CoffeeModel
import mudinov.ali.f24coffee.databinding.CoffeeItemBinding

class CoffeeAdapter():
    RecyclerView.Adapter<CoffeeAdapter.CoffeeHolder>() {

    private val coffee = ArrayList<CoffeeModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoffeeHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: CoffeeItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.coffee_item, parent, false)
        return CoffeeHolder(binding)
    }

    override fun onBindViewHolder(holder: CoffeeHolder, position: Int) {
        holder.bind(coffee[position])
    }

    override fun getItemCount(): Int {
        return coffee.size
    }

    fun setList(coffeeList: List<CoffeeModel>) {
        coffee.clear()
        coffee.addAll(coffeeList)
    }

    class CoffeeHolder(val binding: CoffeeItemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(coffeeModel: CoffeeModel)
        {

            val getImage = coffeeModel.image
            Picasso.get().load(getImage).into(binding.imageCoffee)
            binding.nameCoffee.text = coffeeModel.name
            binding.descriptionCoffee.text = coffeeModel.description
            binding.priceCoffee.text = coffeeModel.price

        }




    }
}

