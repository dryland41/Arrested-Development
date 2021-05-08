package com.namespacermcw.arresteddevelopment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RecordsAdapter(): RecyclerView.Adapter<RecordsViewHolder>() {

    var records: List<Record> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecordsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return RecordsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return records.size
    }

    override fun onBindViewHolder(holder: RecordsViewHolder, position: Int) {
        return holder.bind(records[position])
    }
}

class RecordsViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
    private val photo:ImageView = itemView.findViewById(R.id.mugshot)
    //private val bookdate:TextView = itemView.findViewById(R.id.bookdate)
    private val charges:TextView = itemView.findViewById(R.id.charges)
    private val info: TextView = itemView.findViewById(R.id.info)

    fun bind(record: Record) {
        Glide.with(itemView.context).load(record.mugshot).into(photo)
        //bookdate.text = "Book Date: "+ record.bookDate
        charges.text = "Charges: " + record.charges
        info.text = "More Info: "+ record.moreInfoUrl
    }

}