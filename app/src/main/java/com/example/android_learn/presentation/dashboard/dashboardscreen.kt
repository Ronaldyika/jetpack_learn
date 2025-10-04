package com.example.android_learn.presentation.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.android_learn.Domain.model.Subject
import com.example.android_learn.R
import com.example.android_learn.presentation.components.CountCard
import com.example.android_learn.presentation.components.SubjectCard

@Composable
fun DashboardScreen(modifier: Modifier = Modifier) {

    val subjects = listOf(
        Subject("History",10f, Subject.subjectCardColors[0] ),
        Subject("geology",10f, Subject.subjectCardColors[0] ),
        Subject("maths",10f, Subject.subjectCardColors[0] ),
        Subject("physics",10f, Subject.subjectCardColors[0] ),

    )

    Scaffold (topBar =
        {
            DashboardScreenTopBar()
        }){
        paddingValues ->
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)) {
            item {
                CountCardSection(modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                    subjectcount = 3,
                    studiedhours = "10",
                    goalHours = "15")
            }
            item {
                SubjectCardSction(modifier = modifier.fillMaxWidth()
                    , subjectList = subjects)
            }

        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DashboardScreenTopBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title ={
            Text(
                text = "StudySmart",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    )

}

@Composable
private fun CountCardSection(
    modifier: Modifier,
    subjectcount:Int,
    studiedhours: String,
    goalHours:String
) {
    Row {
        CountCard(modifier = Modifier.weight(1f),headingText = "Subject Count", count = "$subjectcount")
        Spacer(Modifier.height(10.dp))
        CountCard(modifier = Modifier.weight(1f),headingText = "Studied Hour", count = "$studiedhours")
        Spacer(Modifier.height(10.dp))
        CountCard(modifier = Modifier.weight(1f),headingText = "Goal Study Hour ", count = "$goalHours")
    }

}

@Composable
private fun SubjectCardSction(modifier: Modifier = Modifier,
                              subjectList: List<Subject>,
                              emptylistText:String = "you dont have any subjects. \n click the + button to add new subject"
) {
    Column(modifier= Modifier) {
        Row (modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween){
            Text(
                text = "SUBJECTS",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 12.dp)
            )
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add subject"
                )
            }
        }
        if(subjectList.isEmpty()){
            Image(modifier= Modifier.size(120.dp)
                .align(Alignment.CenterHorizontally),
                painter = painterResource(R.drawable.img_books),
                contentDescription = "$emptylistText")
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "$emptylistText",
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray,
                textAlign = TextAlign.Center
            )
        }
        LazyRow (horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(start = 12.dp, end = 12.dp)
        ){
            items(subjectList){
                subject->SubjectCard(
                    subjectName = "${subject.name}",
                    gradientColor = "${subject.colors}",
                    onClik = {}
                )
            }
        }
    }

}