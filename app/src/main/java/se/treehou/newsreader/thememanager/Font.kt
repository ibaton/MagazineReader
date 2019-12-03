package se.treehou.newsreader.thememanager

import androidx.annotation.FontRes
import se.treehou.newsreader.R

enum class Font(val fontId: Int, @FontRes val fontRes: Int) {
    ROBOTO(1, R.font.roboto_regular),
    PLAYFAIR(2, R.font.playfair_display_regular),
    MONTSERRAT(3, R.font.montserrat_regular),
    OPENSANS(4, R.font.opensans_regular)
}