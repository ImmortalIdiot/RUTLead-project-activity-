package com.immortalidiot.rutlead.ui.theme

import androidx.compose.ui.graphics.Color

val darkWhite = Color(0xFFC7D2E5)

val primaryDarkBlue = Color(0xFF1E4A99)
val darkBlue = Color(0xFF2552A3)
val lightBlue = Color(0xFF2A5EBD)

val darkBlack = Color(0xFF1C1B1B)
val lightBlack = Color(0xFF232323)


sealed class ThemeColors(
    val surface: Color,
    val primary: Color,
    val outline: Color,
    val text: Color,
    val container: Color,
    val label: Color,
    val buttonOutline: Color,
    val textSelection: Color,
    val handle: Color
) {
    object Light : ThemeColors(
        surface = Color.White,
        primary = lightBlue,
        outline = Color.Transparent,
        text = lightBlue,
        container = Color.White,
        label = Color.White,
        buttonOutline = Color.White,
        textSelection = darkWhite,
        handle = darkBlue
    )

    object Dark : ThemeColors(
        surface = darkBlack,
        primary = lightBlack,
        outline = primaryDarkBlue,
        text = darkWhite,
        container = lightBlack,
        label = darkWhite,
        buttonOutline = darkBlue,
        textSelection = primaryDarkBlue,
        handle = darkWhite
    )
}
