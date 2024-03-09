package com.immortalidiot.rutlead.buttons.login

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.immortalidiot.rutlead.ui.theme.LocalDimensions
import com.immortalidiot.rutlead.ui.theme.boldLato20

@Composable
fun SignInButton() {
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxHeight(0.3f)
            .fillMaxWidth(0.55f)
            .border(
                width = LocalDimensions.current.borderXSWidth,
                shape = RoundedCornerShape(LocalDimensions.current.shapeXLRound),
                color = MaterialTheme.colorScheme.onSecondaryContainer
            ),
        shape = RoundedCornerShape(LocalDimensions.current.shapeXLRound),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(
                text = "Войти",
                style = boldLato20,
                color = MaterialTheme.colorScheme.onTertiary
            )
        }
    }
}