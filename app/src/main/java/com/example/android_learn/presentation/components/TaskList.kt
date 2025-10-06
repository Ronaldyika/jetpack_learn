package com.example.android_learn.presentation.components

import android.content.ClipData
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.android_learn.Domain.model.Task
import com.example.android_learn.R
import com.example.android_learn.util.Priority

fun LazyListScope.tasksList(
    sectionTitle: String,
    task: List<Task>,
    emptylistText:String,
    onTaskCardClick:(Int?)-> Unit,
    onCheckBoxClick: (Task) -> Unit
){
    item {
        Text(
            text = sectionTitle,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(12.dp)
        )
    }
    if(task.isEmpty()){
        item {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    modifier = Modifier.size(120.dp),
                    painter = painterResource(R.drawable.img_tasks),
                    contentDescription = "$emptylistText"
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "$emptylistText",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            }
        }
}
    items(task){
            task->TaskCard(
        modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
        task = task,
        onCheckBoxClick = {onCheckBoxClick(task)},
        onClick = {onTaskCardClick(task.taskId)}
    )
    }
}

@Composable
private fun TaskCard(modifier: Modifier = Modifier,
                     task: Task,
                     onCheckBoxClick:()-> Unit,
                     onClick:()-> Unit
) {
    ElevatedCard(modifier=modifier.clickable{}) {
        Row (modifier.fillMaxWidth().padding(8.dp),
            verticalAlignment = Alignment.CenterVertically){
            TaskCheckBox(isComplete = task.isComplete,
                borderColor = Priority.fromInt(task.proirity).color,
                oncheckBoxClick = {}
                )
            Spacer(modifier.width(10.dp))
            Column {
                Text(
                    text = task.title,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis, style = MaterialTheme.typography.titleMedium,
                    textDecoration = if(task.isComplete){
                        TextDecoration.LineThrough
                    }else TextDecoration.None
                )
                Spacer(modifier.height(4.dp))
                Text(text = "$task.dueDate",
                    style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}