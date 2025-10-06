package com.example.android_learn.presentation.components


import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.android_learn.Domain.model.Session
import com.example.android_learn.R

fun LazyListScope.StudySessionList(
    sectionTitle: String,
    session: List<Session>,
    emptylistText:String,
    onDeleteIconCLick: (Session)-> Unit
){
    item {
        Text(
            text = sectionTitle,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(12.dp)
        )
    }
    if(session.isEmpty()){
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
    items(session){
            session->
        StudySessionCard(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
            session = session,
            onDeleteClick = { onDeleteIconCLick(session) }
        )
    }
}

@Composable
private fun StudySessionCard(modifier: Modifier = Modifier,
                     session: Session,
                             onDeleteClick:()-> Unit
) {
    Card () {
        Row (modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically){
            Spacer(modifier.width(10.dp))
            Column (modifier.padding(start = 12.dp)){
                Text(
                    text = session.relatedSubject,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.titleMedium,
                )
                Text(text = "${session.date}",
                    style = MaterialTheme.typography.bodySmall
                )
            }
            Spacer(modifier.weight(1f))
            Text(
                text = "${session.duration} hr",
                style = MaterialTheme.typography.titleMedium
            )

            IconButton(onClick = onDeleteClick) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete Session"
                )
            }
        }
    }
}