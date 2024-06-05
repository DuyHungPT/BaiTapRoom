//package com.duyle.roomdbex3
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.activity.enableEdgeToEdge
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.material3.Button
//import androidx.compose.material3.Divider
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.runtime.*
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.room.Room
//import com.duyle.roomdbex3.ui.theme.RoomDBEx3Theme
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            RoomDBEx3Theme {
//                Scaffold(modifier = Modifier.safeDrawingPadding().fillMaxSize().padding(16.dp)) { innerPadding ->
//                    Greeting(
//                        name = "Quản ly Sinh vien",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//
//    val context = LocalContext.current
//    val db = Room.databaseBuilder(
//        context,
//        StudentDB::class.java, "student-db"
//    ).allowMainThreadQueries().build()
//
//    var listStudents by remember {
//        mutableStateOf(db.studentDAO().getAll())
//    }
//
//    Column (Modifier.fillMaxWidth()){
//        Text(
//            text = "Quan ly Sinh vien",
//            style = MaterialTheme.typography.titleLarge
//        )
//
//        // Add Student Button
//        Button(onClick = {
//            db.studentDAO().insert(StudentModel(hoten = "Tuan Tran", mssv = "PH13311", diemTB = 9.5f, daratruong = true))
//            listStudents = db.studentDAO().getAll()
//        }) {
//            Text(text = "Thêm SV")
//        }
//
//        LazyColumn {
//            items(listStudents) { student ->
//                Row (
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(16.dp)
//                ){
//                    Text(modifier = Modifier.weight(1f), text = student.uid.toString())
//                    Text(modifier = Modifier.weight(1f), text = student.hoten.toString())
//                    Text(modifier = Modifier.weight(1f), text = student.mssv.toString())
//                    Text(modifier = Modifier.weight(1f), text = student.diemTB.toString())
//                    Text(modifier = Modifier.weight(1f), text = student.daratruong.toString())
//
//                    // Update Button
//                    Button(onClick = {
//                        db.studentDAO().update(student.uid, "Updated Name", student.mssv ?: "", student.diemTB ?: 0f, student.daratruong ?: false)
//                        listStudents = db.studentDAO().getAll()
//                    }) {
//                        Text(text = "Update")
//                    }
//
//                    // Delete Button
//                    Button(onClick = {
//                        db.studentDAO().delete(student)
//                        listStudents = db.studentDAO().getAll()
//                    }) {
//                        Text(text = "Delete")
//                    }
//                }
//                Divider()
//            }
//        }
//    }
//}

package com.duyle.roomdbex3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.duyle.roomdbex3.ui.theme.RoomDBEx3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RoomDBEx3Theme {
                Scaffold(modifier = Modifier.safeDrawingPadding().fillMaxSize().padding(16.dp)) { innerPadding ->
                    StudentManagerScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
