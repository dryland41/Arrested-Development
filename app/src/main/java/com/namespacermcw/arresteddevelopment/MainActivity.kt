package com.namespacermcw.arresteddevelopment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val request = ServiceBuilder.buildService(ArrestInterface::class.java)
        val call = request.getRecords("az-mcso", "smith")
        val recordsAdapter = RecordsAdapter()

        progress_bar.visibility = View.GONE
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            //adapter = MoviesAdapter(response.body()!!.results)
            adapter = recordsAdapter
        }

        call.enqueue(object : Callback<JailBaseResp>{
            //override fun onResponse(call: Call<PopularMovies>, response: Response<PopularMovies>) {
            override fun onResponse(call: Call<JailBaseResp>, response: Response<JailBaseResp>) {
                if (response.isSuccessful){
                    Log.d("_WORK", "${response.body()!!.records?.size}")

                    recordsAdapter.records = response.body()!!.records?: emptyList()
                    recordsAdapter.notifyDataSetChanged()
                }
                Log.d("_WORK", "Did stuff")
            }
            override fun onFailure(call: Call<JailBaseResp>, t: Throwable) {
                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
                Log.d("_WORK", "EPIC FAIL!!")
            }
        })
    }
}

//class MainActivity : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val request = ServiceBuilder.buildService(TmdbInterface::class.java)
//        val call = request.getMovies(getString(R.string.api_key))
//
//        call.enqueue(object : Callback<PopularMovies>{
//            override fun onResponse(call: Call<PopularMovies>, response: Response<PopularMovies>) {
//                if (response.isSuccessful){
//                    progress_bar.visibility = View.GONE
//                    recyclerView.apply {
//                        setHasFixedSize(true)
//                        layoutManager = LinearLayoutManager(this@MainActivity)
//                        adapter = MoviesAdapter(response.body()!!.results)
//                    }
//                }
//            }
//            override fun onFailure(call: Call<PopularMovies>, t: Throwable) {
//                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
//            }
//        })
//    }
//}