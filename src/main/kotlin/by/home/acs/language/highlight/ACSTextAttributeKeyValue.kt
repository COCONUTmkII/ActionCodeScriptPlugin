package by.home.acs.language.highlight

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey

object ACSTextAttributeKeyValue {
    val IDENTIFIER =
        TextAttributesKey.createTextAttributesKey("ACS_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER)
    val STRING_VALUE =
        TextAttributesKey.createTextAttributesKey("ACS_STRING_VALUE", DefaultLanguageHighlighterColors.STRING)
    val INT_VALUE = TextAttributesKey.createTextAttributesKey("ACS_INT_VALUE", DefaultLanguageHighlighterColors.NUMBER)
    val COMMENT =
        TextAttributesKey.createTextAttributesKey("ACS_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
    val KEY = TextAttributesKey.createTextAttributesKey("ACS_KEY", DefaultLanguageHighlighterColors.KEYWORD)
    val SCRIPT_TYPE =
        TextAttributesKey.createTextAttributesKey("ACS_SCRIPT_TYPE", DefaultLanguageHighlighterColors.METADATA)
}