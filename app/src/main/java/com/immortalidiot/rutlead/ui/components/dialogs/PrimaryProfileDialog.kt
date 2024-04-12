package com.immortalidiot.rutlead.ui.components.dialogs

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.immortalidiot.rutlead.ui.theme.ClassicGray
import com.immortalidiot.rutlead.ui.theme.LocalDimensions

@Composable
fun PrimaryProfileDialog(
    modifier: Modifier,
    properties: DialogProperties,
    headerText: String,
    headerTextStyle: TextStyle,
    headerTextColor: Color,
    onCancelled: () -> Unit,
    content: @Composable () -> Unit,
) {
    val dimensions = LocalDimensions.current
    val scheme = MaterialTheme.colorScheme

    val roundedShape = RoundedCornerShape(dimensions.shapeXLarge)

    Dialog(
        onDismissRequest = { onCancelled() },
        properties = properties
    ) {
        Column(
            modifier = modifier
                .heightIn(max = 200.dp)
                .widthIn(max = 300.dp)
                .fillMaxWidth()
                .fillMaxHeight()
                .clip(roundedShape)
                .background(color = scheme.onBackground)
                .border(
                    width = LocalDimensions.current.borderXSSmall,
                    color = ClassicGray,
                    shape = roundedShape
                ),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = headerText,
                style = headerTextStyle,
                color = headerTextColor
            )
            content()
        }
    }
}