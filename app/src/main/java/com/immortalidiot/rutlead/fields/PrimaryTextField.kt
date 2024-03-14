package com.immortalidiot.rutlead.fields

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.VisualTransformation
import com.immortalidiot.rutlead.ui.theme.LocalDimensions

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrimaryTextField(
    modifier: Modifier,
    value: String = "",
    isSingleLine: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    colors: TextFieldColors,
    minTextLength: Int? = null,
    maxTextLength: Int? = null,
    label: @Composable (() -> Unit)? = {},
    trailingIcon: @Composable (() -> Unit)? = null, // TODO: change to trailingIcon: Painter? = null
    onTextChange: (String) -> Unit,
    onTrailingIconClicked: () -> Unit = {}
) {
    val dimensions = LocalDimensions.current
    val colorScheme = MaterialTheme.colorScheme

    val customCursorHandleColor = TextSelectionColors(
        handleColor = colorScheme.scrim,
        backgroundColor = colorScheme.onBackground
    )

    CompositionLocalProvider(LocalTextSelectionColors provides customCursorHandleColor) {
        TextField(
            modifier = modifier,
            value = value,
            onValueChange = { text ->
                if (text.length <= (maxTextLength ?: (text.length + 1))) {
                    onTextChange(text)
                }
            },
            label = label,
            trailingIcon = trailingIcon,
            singleLine = isSingleLine,
            keyboardOptions = keyboardOptions,
            visualTransformation = visualTransformation,
            colors = colors,
            shape = RoundedCornerShape(dimensions.shapeXLarge)
        )
    }
}