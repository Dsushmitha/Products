package com.example.products.store

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

interface RemoteKeyValueStore {
    fun getSyncString(input: String, completion: (String) -> Unit)
    fun getSyncLong(input: String, completion: (Long) -> Unit)
}

class FirebaseStore : RemoteKeyValueStore{

    override fun getSyncString(input: String, completion: (String) -> Unit) {

        val nodeRef = FirebaseDatabase.getInstance().getReference(input)
        nodeRef.addListenerForSingleValueEvent(object: ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                completion(dataSnapshot.getValue(String::class.java).toString())
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // ...
            }
        })
    }

    override fun getSyncLong(input: String, completion: (Long) -> Unit) {

        val nodeRef = FirebaseDatabase.getInstance().getReference(input)
        nodeRef.addListenerForSingleValueEvent(object: ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                dataSnapshot.getValue(Long::class.java)?.let { completion(it) }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // ...
            }
        })
    }
}