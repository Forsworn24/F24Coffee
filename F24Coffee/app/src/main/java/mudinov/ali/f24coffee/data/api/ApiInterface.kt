package mudinov.ali.f24coffee.data.api

import mudinov.ali.f24coffee.data.models.CoffeeApiModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("loadCoffee.php")
    fun loadCoffeeApi(): Call<ArrayList<CoffeeApiModel>>
}