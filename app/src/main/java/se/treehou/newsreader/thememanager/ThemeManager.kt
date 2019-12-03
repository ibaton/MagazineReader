package se.treehou.newsreader.thememanager

import android.R
import android.content.Context
import android.graphics.Typeface
import androidx.core.content.res.ResourcesCompat


class ThemeManager(val context: Context) {

    private val fontMap: MutableMap<Font, Typeface> = mutableMapOf()

    /**
     * Set the font used in reader
     */
    fun setFont(font: Font) {
        val edit = context.getSharedPreferences(PREF_THEME, Context.MODE_PRIVATE).edit()
        edit.putInt(KEY_FONT, font.fontId)
        edit.apply()
    }

    /**
     * Get the font used in reader.
     * Defaults to use Robboto
     */
    fun getFont(): Font {
        val pref = context.getSharedPreferences(PREF_THEME, Context.MODE_PRIVATE)
        val fontId = pref.getInt(KEY_FONT, Font.ROBOTO.fontId)

        return Font.values().find {
            it.fontId == fontId
        } ?: Font.ROBOTO
    }

    /**
     * Get the typeface used in reader.
     * Defaults to use Robboto
     */
    fun getTypeface(): Typeface? {
        val font = getFont()

        if (!fontMap.containsKey(font)){
            val typeface = ResourcesCompat.getFont(context, font.fontRes)
            if(typeface != null) {
                fontMap[font] = typeface
            }
        }
        return fontMap[font]
    }

    companion object {
        const val PREF_THEME = "Theme"
        const val KEY_FONT = "Font"
    }
}