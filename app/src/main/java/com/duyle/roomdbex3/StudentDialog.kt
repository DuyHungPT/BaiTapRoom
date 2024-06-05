package com.duyle.roomdbex3



import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.TextFieldValue

@Composable
fun StudentDialog(
    student: StudentModel?,
    onDismiss: () -> Unit,
    onSave: (StudentModel) -> Unit
) {
    var name by remember { mutableStateOf(TextFieldValue(student?.hoten ?: "")) }
    var mssv by remember { mutableStateOf(TextFieldValue(student?.mssv ?: "")) }
    var diemTB by remember { mutableStateOf(TextFieldValue(student?.diemTB?.toString() ?: "")) }
    var daratruong by remember { mutableStateOf(student?.daratruong ?: false) }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(text = if (student == null) "Thêm Sinh Viên" else "Cập Nhật Sinh Viên") },
        text = {
            Column {
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Họ tên") }
                )
                OutlinedTextField(
                    value = mssv,
                    onValueChange = { mssv = it },
                    label = { Text("Mã số sinh viên") }
                )
                OutlinedTextField(
                    value = diemTB,
                    onValueChange = { diemTB = it },
                    label = { Text("Điểm trung bình") }
                )
                Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                    Checkbox(
                        checked = daratruong,
                        onCheckedChange = { daratruong = it }
                    )
                    Text(text = "Đã ra trường")
                }
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    val studentModel = StudentModel(
                        uid = student?.uid ?: 0,
                        hoten = name.text,
                        mssv = mssv.text,
                        diemTB = diemTB.text.toFloatOrNull(),
                        daratruong = daratruong
                    )
                    onSave(studentModel)
                }
            ) {
                Text("Lưu")
            }
        },
        dismissButton = {
            Button(onClick = onDismiss) {
                Text("Hủy")
            }
        }
    )
}
