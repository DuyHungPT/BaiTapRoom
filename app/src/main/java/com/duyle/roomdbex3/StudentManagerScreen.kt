package com.duyle.roomdbex3



import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.room.Room

@Composable
fun StudentManagerScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val db = Room.databaseBuilder(
        context,
        StudentDB::class.java, "student-db"
    ).allowMainThreadQueries().build()

    var listStudents by remember {
        mutableStateOf(db.studentDAO().getAll())
    }

    var showDialog by remember { mutableStateOf(false) }
    var currentStudent by remember { mutableStateOf<StudentModel?>(null) }

    Column (Modifier.fillMaxWidth()){
        Text(
            text = "Quản lý Sinh viên",
            style = MaterialTheme.typography.titleLarge
        )

        Button(onClick = {
            currentStudent = null
            showDialog = true
        }) {
            Text(text = "Thêm SV")
        }

        LazyColumn {
            items(listStudents) { student ->
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ){
                    Text(modifier = Modifier.weight(1f), text = student.uid.toString())
                    Text(modifier = Modifier.weight(1f), text = student.hoten.toString())
                    Text(modifier = Modifier.weight(1f), text = student.mssv.toString())
                    Text(modifier = Modifier.weight(1f), text = student.diemTB.toString())
                    Text(modifier = Modifier.weight(1f), text = student.daratruong.toString())

                    // Update Button
                    Button(onClick = {
                        currentStudent = student
                        showDialog = true
                    }) {
                        Text(text = "Update")
                    }

                    // Delete Button
                    Button(onClick = {
                        db.studentDAO().delete(student)
                        listStudents = db.studentDAO().getAll()
                    }) {
                        Text(text = "Delete")
                    }
                }
                Divider()
            }
        }

        if (showDialog) {
            StudentDialog(
                student = currentStudent,
                onDismiss = { showDialog = false },
                onSave = { student ->
                    if (student.uid == 0) {
                        db.studentDAO().insert(student)
                    } else {
                        db.studentDAO().update(student.uid, student.hoten!!, student.mssv!!, student.diemTB!!, student.daratruong!!)
                    }
                    listStudents = db.studentDAO().getAll()
                    showDialog = false
                }
            )
        }
    }
}
