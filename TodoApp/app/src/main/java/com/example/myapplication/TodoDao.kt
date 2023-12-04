package com.example.myapplication

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {
    @Query("SELECT * FROM todo")
    suspend fun getAllTodos():List<Todo>

    @Query("SELECT * FROM todo WHERE tid=:tid")
    suspend fun findById(tid:Int):Todo

    @Query("UPDATE todo  SET checked=:checked WHERE tid=:tid")
    suspend fun toggleTodo(checked:Boolean,tid:Int)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTodo(todo: Todo)

    @Delete
    suspend fun deleteTodo(todo: Todo)

}