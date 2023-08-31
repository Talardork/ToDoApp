package com.example.todoappwithmvvm.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

// entity represents the table in the database
// table named note_table is created in our database
// this table consists two columns title and description
// primary key is id with default value 0
//id for each row will be generated automatically.

//after this we will create dao.
// dao is a unit that mediates between user and the database

@Entity(tableName = "note_table")
class Note(val title : String , val description : String) {

    @PrimaryKey(autoGenerate = true)
    var id = 0


}