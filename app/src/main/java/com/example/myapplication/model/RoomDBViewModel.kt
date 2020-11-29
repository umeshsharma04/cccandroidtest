package com.example.myapplication.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.local.DatabaseHelper
import com.example.myapplication.local.entity.Estimate
import com.example.myapplication.local.entity.Person
import com.example.myapplication.utils.Resource
import com.google.gson.Gson
import kotlinx.coroutines.launch

class RoomDBViewModel(private val dbHelper: DatabaseHelper) :
    ViewModel() {

    var personString="{\n" +
            "                       \"id\": \"85a57f85-a52d-4137-a0d1-62e61362f716\",\n" +
            "                       \"first_name\": \"Joseph\",\n" +
            "                       \"last_name\": \"Sham\",\n" +
            "                       \"email\": \"joseph.sham@fake.fake\",\n" +
            "                       \"phone_number\": \"123-456-7890\"\n" +
            "           }"


    var estimationString="{\n" +
            "                       \"company\": \"Placebo Secondary School\",\n" +
            "                       \"address\": \"32 Commissioners Road East\",\n" +
            "                       \"number\": 32,\n" +
            "                       \"revision_number\": 3,\n" +
            "                       \"created_date\": \"2020-08-22 15:23:54\",\n" +
            "                       \"created_by\": \"85a57f85-a52d-4137-a0d1-62e61362f716\",\n" +
            "                       \"requested_by\": \"85a57f85-a52d-4137-a0d1-62e61362f716\",\n" +
            "                       \"contact\": \"85a57f85-a52d-4137-a0d1-62e61362f716\"\n" +
            "           }"

    private val person = MutableLiveData<Resource<List<Person>>>()
    private var estimate = MutableLiveData<Resource<List<Estimate>>>()

    init {
        fetchUsers()
        fetchEstimations()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            person.postValue(Resource.loading(null))
            try {
                val usersFromDb = dbHelper.getPerson()
                if (usersFromDb.isEmpty()) {

                    val gson = Gson()
                    val personModel = gson.fromJson(personString.toString(), PersonModel::class.java);

                    val personModelToInsertInDB = mutableListOf<Person>()

                    val persons = Person(
                            personModel.id_person,
                            personModel.id,
                            personModel.first_name,
                            personModel.last_name,
                            personModel.email,
                            personModel.phone_number
                    )

                    personModelToInsertInDB.add(persons)

                    dbHelper.insertAllPersons(personModelToInsertInDB)

                    person.postValue(Resource.success(personModelToInsertInDB))

                } else {
                    person.postValue(Resource.success(usersFromDb))
                }


            } catch (e: Exception) {
                print(e.message)
                person.postValue(Resource.error("Something Went Wrong", null))
            }
        }

    }

    private fun fetchEstimations() {
        viewModelScope.launch {
            estimate.postValue(Resource.loading(null))
            try {
                var estimateFromDb = dbHelper.getEstimate();
                if (estimateFromDb.isEmpty()) {

                    val gson = Gson()
                    val estimateModel = gson.fromJson(estimationString.toString(), EstimateModel::class.java);

                    val estimateModelToInsertInDB = mutableListOf<Estimate>()

                    val estimates = Estimate(
                            estimateModel.id,
                            estimateModel.company,
                            estimateModel.address,
                            estimateModel.number,
                            estimateModel.revision_number,
                            estimateModel.created_date,
                            estimateModel.created_by,
                            estimateModel.requested_by,
                            estimateModel.contact
                    )

                    estimateModelToInsertInDB.add(estimates)

                    dbHelper.insertAllEstimate(estimateModelToInsertInDB)

                    estimate.postValue(Resource.success(estimateModelToInsertInDB))

                } else {

                    estimate.postValue(Resource.success(estimateFromDb))
                }


            } catch (e: Exception) {
                print(e.message)
                estimate.postValue(Resource.error("Something Went Wrong", null))
            }
        }
    }

    fun getPersons(): LiveData<Resource<List<Person>>> {
        return person
    }
    var contatId:String =""

    fun getEstimate():LiveData<Resource<List<Estimate>>> {

        return estimate
    }

}