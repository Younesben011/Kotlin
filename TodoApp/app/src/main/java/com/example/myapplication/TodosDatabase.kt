package com.example.myapplication

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.DeleteTable
import androidx.room.RoomDatabase
import androidx.room.migration.AutoMigrationSpec

@Database(
    entities = [Todo::class],
    version=2,
    autoMigrations = [AutoMigration(
        from = 1, to = 2 )],
    exportSchema = true
)
abstract class TodosDatabase:RoomDatabase() {
    abstract fun todoDao():TodoDao

}