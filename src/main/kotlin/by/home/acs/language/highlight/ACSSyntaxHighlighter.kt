package by.home.acs.language.highlight

import by.home.acs.language.ACSTypes
import by.home.acs.language.highlight.ACSTextAttributeKeyValue.COMMENT
import by.home.acs.language.highlight.ACSTextAttributeKeyValue.IDENTIFIER
import by.home.acs.language.highlight.ACSTextAttributeKeyValue.INT_VALUE
import by.home.acs.language.highlight.ACSTextAttributeKeyValue.KEY
import by.home.acs.language.highlight.ACSTextAttributeKeyValue.SCRIPT_TYPE
import by.home.acs.language.highlight.ACSTextAttributeKeyValue.STRING_VALUE
import by.home.acs.language.lexer.ACSLexerAdapter
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType

object ACSSyntaxHighlighter : SyntaxHighlighterBase() {

    private val elements = hashMapOf(
        ACSTypes.INCLUDE to KEY,
        ACSTypes.IMPORT to KEY,
        ACSTypes.DEFINE to KEY,
        ACSTypes.LIBRARY to KEY,
        ACSTypes.WORLD to KEY,
        ACSTypes.GLOBAL to KEY,
        ACSTypes.STATIC to KEY,
        ACSTypes.SPECIAL to KEY,
        ACSTypes.RETURN to KEY,
        ACSTypes.BREAK to KEY,
        ACSTypes.CONTINUE to KEY,
        ACSTypes.DEFAULT to KEY,
        ACSTypes.IF to KEY,
        ACSTypes.ELSE to KEY,
        ACSTypes.SWITCH to KEY,
        ACSTypes.CASE to KEY,
        ACSTypes.FOR to KEY,
        ACSTypes.WHILE to KEY,
        ACSTypes.DO to KEY,
        ACSTypes.UNTIL to KEY,
        ACSTypes.BOOL to KEY,
        ACSTypes.VOID to KEY,
        ACSTypes.STR to KEY,
        ACSTypes.SCRIPT to KEY,
        ACSTypes.FUNCTION to KEY,
        ACSTypes.TERMINATE to KEY,
        ACSTypes.SUSPEND to KEY,
        ACSTypes.RESTART to KEY,
        ACSTypes.INT to KEY,
        ACSTypes.VARIABLE_DECLARATION to KEY,

        ACSTypes.OPEN to SCRIPT_TYPE,
        ACSTypes.DEATH to SCRIPT_TYPE,
        ACSTypes.ENTER to SCRIPT_TYPE,
        ACSTypes.DISCONNECT to SCRIPT_TYPE,
        ACSTypes.PICKUP to SCRIPT_TYPE,
        ACSTypes.REDRETURN to SCRIPT_TYPE,
        ACSTypes.BLUERETURN to SCRIPT_TYPE,
        ACSTypes.WHITERETURN to SCRIPT_TYPE,
        ACSTypes.CLIENTSIDE to SCRIPT_TYPE,
        ACSTypes.REOPEN to SCRIPT_TYPE,
        ACSTypes.NET to SCRIPT_TYPE,
        ACSTypes.RESPAWN to SCRIPT_TYPE,
        ACSTypes.UNLOADING to SCRIPT_TYPE,
        ACSTypes.LIGHTNING to SCRIPT_TYPE,
        ACSTypes.KILL to SCRIPT_TYPE,

        ACSTypes.EMPTY_STRING to STRING_VALUE,
        ACSTypes.STRING to STRING_VALUE,

        ACSTypes.END_OF_LINE_COMMENT to COMMENT,
        ACSTypes.C_STYLE_BLOCK_COMMENT to COMMENT,

        ACSTypes.IDENTIFIER to IDENTIFIER,

        ACSTypes.NUMBER to INT_VALUE,
        ACSTypes.FLOAT to INT_VALUE,
    )

    override fun getHighlightingLexer(): Lexer = ACSLexerAdapter()

    override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> = pack(elements[tokenType])

}
