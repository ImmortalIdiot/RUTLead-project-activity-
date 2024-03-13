package com.immortalidiot.rutlead.ui.theme

import androidx.compose.ui.graphics.Color

val DarkWhite = Color(0xFFC7D2E5)
val ClassicWhite = Color.White

val PrimaryDarkBlue = Color(0xFF1E4A99)
val DarkBlue = Color(0xFF2552A3)
val LightBlue = Color(0xFF2A5EBD)

val ClassicGray = Color.Gray
val DarkGray = Color.DarkGray
val LightGray = Color.LightGray

val DarkBlack = Color(0xFF1C1B1B)
val LightBlack = Color(0xFF232323)


sealed class ThemeColors(
    val header: Color,
    val surface: Color,
    val primary: Color,
    val content: Color,
    val outline: Color,
    val text: Color,
    val containerText: Color,
    val container: Color,
    val label: Color,
    val labelText: Color,
    val cursor: Color,
    val buttonOutline: Color,
    val textSelection: Color,
    val handle: Color,
    val handleBackground: Color
) {
    object Light : ThemeColors(
        header = ClassicWhite,
        surface = Color.Transparent,
        primary = LightBlue,
        content = LightBlue,
        outline = Color.Transparent,
        text = ClassicWhite,
        container = ClassicWhite,
        containerText = LightBlue,
        label = ClassicWhite,
        labelText = LightBlue,
        cursor = LightBlue,
        buttonOutline = Color.White,
        textSelection = DarkWhite,
        handle = LightGray,
        handleBackground = LightGray
    )

    object Dark : ThemeColors(
        header = DarkWhite,
        surface = DarkBlack,
        primary = LightBlack,
        content = DarkWhite,
        outline = PrimaryDarkBlue,
        text = DarkWhite,
        container = LightBlack,
        containerText = DarkWhite,
        label = DarkWhite,
        labelText = DarkWhite,
        cursor = DarkBlue,
        buttonOutline = DarkBlue,
        textSelection = PrimaryDarkBlue,
        handle = DarkWhite,
        handleBackground = LightBlue
    )
}
