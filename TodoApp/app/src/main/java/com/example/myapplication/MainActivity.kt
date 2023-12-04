package com.example.myapplication

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.myapplication.ui.theme.Dark100
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

        var todos= mutableStateOf(emptyList<Todo>())
        var todotext = mutableStateOf("")
        var todoState = mutableStateOf(false)
        var togglelist = mutableStateOf(false)
    fun insertTodo( todo:String,tododao:TodoDao){
        val inserted_todo=Todo(null,todo,false)
        lifecycleScope.launch {
            tododao.insertTodo(inserted_todo)
            tododao.getAllTodos().also { todos.value=it }
            todotext.value=""
        }
    }

    fun checkTodo(cheked:Boolean,tododao:TodoDao,tid:Int){
        lifecycleScope.launch{
            tododao.toggleTodo(!cheked,tid).also {
                tododao.getAllTodos().also { todos.value=it }

            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {

        val db = Room.databaseBuilder(
            applicationContext,
            TodosDatabase::class.java,
            "TodosDatabase"
        ).build()
        val tododao= db.todoDao()


        lifecycleScope.launch {
            val todo1:Todo=Todo(tid = 1, todo = "go to the gym",false)
            val todo2:Todo=Todo(tid = 2, todo = "go home",false)
            val todo3:Todo=Todo(tid = 3, todo = "buy groceries",false)
            tododao.insertTodo(todo1)
            tododao.insertTodo(todo2)
            tododao.insertTodo(todo3)
            tododao.getAllTodos().also { todos.value=it }
//            tododao.findById(1).todo.also { name.value = it }
        }



        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(modifier = Modifier
                    .fillMaxSize()
                    .background(Dark100)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Text(
                            text="TODO LIST",
                            modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                        )
                        Row(

                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.
                            fillMaxWidth()
                            .padding(20.dp)

                        ) {
                            TextField(
                                value = todotext.value,
                                onValueChange = {
                                    todotext.value=it
                                }
                            )
                            Button(
                                onClick = {insertTodo(todotext.value,tododao)}
                            ){
                                Text(text = "ADD")
                            }
                        }
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier=Modifier
                                .padding(5.dp)
                                .fillMaxWidth()
                        ) {
                            if(!togglelist.value)
                                Text(textAlign = TextAlign.Center,text = "show ALL")
                            else
                                Text(textAlign = TextAlign.Center,text = "Hide completed")
                            RadioButton(
                                selected = togglelist.value,
                                onClick = {togglelist.value=!togglelist.value})
                        }
                        LazyColumn {
                            items(todos.value){ todo->
                                Row(modifier = Modifier.
                                fillParentMaxWidth())
                                {
                                    todoState.value=todo.cheked

                                    if(todoState.value==false||togglelist.value){
                                       Row(
                                           horizontalArrangement = Arrangement.SpaceBetween,
                                           modifier = Modifier
                                           .fillParentMaxWidth()
                                           .padding(5.dp)
                                            ) {
                                            Row {
                                                Text(textAlign = TextAlign.Center,text = todo.tid.toString()+"-")
                                                Text(textAlign = TextAlign.Center,text = todo.todo)
                                            }

                                            RadioButton(
                                                selected = todoState.value,
                                                onClick = { todo.tid?.let { checkTodo(todo.cheked,tododao, it) } })
                                       }
                                        Divider(
                                            modifier = Modifier
                                            .fillParentMaxWidth(),
                                            color = Dark100,
                                            thickness = 1.dp
                                        )

                                    }
                                }


                            }
                        }
                    }





                }

            }
        }
    }
}

