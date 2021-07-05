package com.example.infoapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.infoapp.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.row.view.*


class MyAdapter(val arrayList: ArrayList<Model>, val context:Context):
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

//    class ViewHolder(val binding: ActivityMainBinding): RecyclerView.ViewHolder(binding.root) {
//        fun bindItems(model:Model) {
//            binding.titleTv.text = model.title
//            binding.descriptionTv.text = model.des
//            binding.imageTv.setImageResource(model.image)
//        }
//    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindItems(model:Model) {
            itemView.titleTv.text = model.title
            itemView.descriptionTv.text = model.des
            itemView.imageTv.setImageResource(model.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(arrayList.get(position))

        holder.itemView.setOnClickListener {
            if (position == 0) {
                Toast.makeText(
                    context, "You Clicked on Newsfeed",
                    Toast.LENGTH_LONG
                ).show()
            }
            if (position == 1) {
                Toast.makeText(
                    context, "You Clicked on Business",
                    Toast.LENGTH_LONG
                ).show()
            }
            if (position == 2) {
                Toast.makeText(
                    context, "You Clicked on People",
                    Toast.LENGTH_LONG
                ).show()
            }
            if (position == 3) {
                Toast.makeText(
                    context, "You Clicked on Notes",
                    Toast.LENGTH_LONG
                ).show()
            }
            if (position == 4) {
                Toast.makeText(
                    context, "You Clicked on Feedback",
                    Toast.LENGTH_LONG
                ).show()
            }

            val model = arrayList.get(position)

            var aTitle: String = model.title

            var aDescription: String = model.des

            var aImageView: Int = model.image

            val intent = Intent(context, FullDisplayActivity::class.java)

            intent.putExtra("iTitle", aTitle)
            intent.putExtra("iDescription", aDescription)
            intent.putExtra("iImageView", aImageView)

            context.startActivity(intent)

        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
}