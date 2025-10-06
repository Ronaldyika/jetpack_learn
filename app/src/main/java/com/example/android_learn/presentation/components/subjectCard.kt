package com.example.android_learn.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.BrushPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.android_learn.R

@Composable
fun SubjectCard(
    modifier: Modifier = Modifier,
    subjectName: String,
    gradientColor: String,
    onClik: () -> Unit
) {
    Box(modifier = modifier
        .size(150.dp)
        .clickable { onClik() }
//        .background(
//        brush = Brush.verticalGradient(gradientColor),
//        shape = MaterialTheme.shapes.medium
    ){
            Column(modifier = modifier.padding(12.dp),
                verticalArrangement = Arrangement.Center) {

                Image(painter = painterResource(R.drawable.img_books),
                    contentDescription = "", modifier = Modifier.size(80.dp))
                Text(text = "$subjectName",
                    style = MaterialTheme.typography.headlineMedium,
                    color = Color.White)

            }
        }

}
@Composable
fun SubjectDemoCard(
    modifier: Modifier = Modifier,
    subjectName:String,
    gradientColor: String,
    subjectImage: Int,
    onClik: () -> Unit

) {
    Box(
        modifier = Modifier.size(150.dp)
            .clickable{
                onClik()
            }
            .background(
                shape = RectangleShape,
                brush = Brush.verticalGradient()
            )

    ){
        Column (modifier.padding(5.dp),
            verticalArrangement = Arrangement.Center){
            Image(painter = painterResource(subjectImage), contentDescription = "")
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "$subjectName",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.DarkGray
            )

        }
    }

}