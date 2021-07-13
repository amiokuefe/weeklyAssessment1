package com.example.persistenceclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.persistenceclone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var myContactAdapter: ContactAdapter
    private lateinit var myContactList: MutableList<ContactModel>
    private lateinit var viewModel: ContactViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[ContactViewModel::class.java]

        myContactList = mutableListOf()

        myContactAdapter = ContactAdapter(myContactList){
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("firstName", it.firstName)
            //putExtra(stringType)
            startActivity(intent)
        }
        binding.recyclerView.adapter = myContactAdapter

        val db = Room.databaseBuilder(
            applicationContext,
            ContactDatabase::class.java, "contact-database"
        ).allowMainThreadQueries().build()


        viewModel.getAllContactItems(db).observe(this, {
            myContactAdapter = ContactAdapter(it){
                val intent = Intent(this, DetailsActivity::class.java)
                intent.putExtra("firstName", it.firstName)
                intent.putExtra("lastName", it.lastName)
                intent.putExtra("phoneNumber", it.phoneO)
                //putExtra(stringType)
                startActivity(intent)
            }
            binding.recyclerView.adapter = myContactAdapter
            myContactAdapter.notifyDataSetChanged()
        })

        binding.button.setOnClickListener {
            val firstName : String = binding.editText.text.toString()
            val lastName : String = binding.editText2.text.toString()
            val phoneO : String = binding.editText3.text.toString()


            val contactItem = ContactModel(firstName, lastName, phoneO)
            viewModel.addContactItem(contactItem, db)

            myContactAdapter.notifyDataSetChanged()
        }
    }
}