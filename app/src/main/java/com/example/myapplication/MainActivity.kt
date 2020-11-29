package com.example.myapplication

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.local.DatabaseBuilder
import com.example.myapplication.local.DatabaseHelperImpl
import com.example.myapplication.local.entity.Person
import com.example.myapplication.model.RoomDBViewModel
import com.example.myapplication.utils.Status
import com.example.myapplication.utils.ViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: RoomDBViewModel

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewModel();
        setupObserver();
    }


    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(
                DatabaseHelperImpl(DatabaseBuilder.getInstance(applicationContext))
            )
        ).get(RoomDBViewModel::class.java)

    }


    private fun setupObserver() {
        viewModel.getPersons().observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    it.data?.let { persons ->
                        setViewData(persons[0]);
                        getEstimateData();

                    }

                }
                Status.LOADING -> {

                }
                Status.ERROR -> {
                    //Handle Error

                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }


    private fun setViewData(person: Person){

        val username =person.first_name +" "+person.last_name

        binding.createdBy.text = username
        binding.requester.text = username
        binding.contact.text = username


    }


    private fun getEstimateData() {
        viewModel.getEstimate().observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    it.data?.let { estimate ->
                        val estimate = estimate[0]

                        binding.address.text = estimate.address
                        binding.company.text = estimate.company
                        binding.estnumber.text = estimate.number.toString()
                        binding.revisionNum.text = estimate.revision_number.toString()

                        binding.created.text=estimate.created_date


                    }

                }
                Status.LOADING -> {

                }
                Status.ERROR -> {
                    //Handle Error

                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }



}