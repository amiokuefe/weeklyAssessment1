package com.example.persistenceclone

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.persistenceclone.databinding.ContactItemBinding

class ContactAdapter(
    val contactItems: List<ContactModel>, val clickerFnx: (ContactModel) -> Unit
) : RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ContactItemBinding)
        :RecyclerView.ViewHolder(binding.root){

        fun bind(contactItem :ContactModel){
            binding.firstName.text = contactItem.firstName
            binding.lastName.text = contactItem.lastName
            binding.phoneO.text = contactItem.phoneO
            binding.root.setOnClickListener {
                clickerFnx(contactItem)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ContactItemBinding =
            ContactItemBinding.inflate(LayoutInflater.from(parent.context))

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int): Unit {
        holder.bind(contactItems[position])


    }
    override fun getItemCount() = contactItems.size
}