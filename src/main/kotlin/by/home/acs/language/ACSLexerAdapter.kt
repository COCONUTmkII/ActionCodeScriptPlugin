package by.home.acs.language

import com.intellij.lexer.FlexAdapter
import by.home.acs.language.lexer.ACSLexer

class ACSLexerAdapter : FlexAdapter(ACSLexer(null))
