package by.home.acs.language.highlight

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey

object ACSTextAttributeKeyValue {
    val IDENTIFIER =
        TextAttributesKey.createTextAttributesKey("ACS_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER)
    val STRING_VALUE =
        TextAttributesKey.createTextAttributesKey("ACS_STRING_VALUE", DefaultLanguageHighlighterColors.STRING)
    val INT_VALUE = TextAttributesKey.createTextAttributesKey("ACS_INT_VALUE", DefaultLanguageHighlighterColors.NUMBER)
    val COMMENT =
        TextAttributesKey.createTextAttributesKey("ACS_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
    val BAD_CHARACTER = TextAttributesKey.createTextAttributesKey("ACS_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER)
    val KEY = TextAttributesKey.createTextAttributesKey("ACS_KEY", DefaultLanguageHighlighterColors.KEYWORD)
    val SCRIPT_TYPE =
        TextAttributesKey.createTextAttributesKey("ACS_SCRIPT_TYPE", DefaultLanguageHighlighterColors.METADATA)
    val FUNCTION_CALL =
        TextAttributesKey.createTextAttributesKey("ACS_METHOD_CALL", DefaultLanguageHighlighterColors.FUNCTION_CALL)
    val PARAMETER =
        TextAttributesKey.createTextAttributesKey("ACS_PARAMETER", DefaultLanguageHighlighterColors.PARAMETER)
}