package by.home.acs.language

import by.home.acs.language.parser.ACSParser
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet

class ACSParserDefinition : ParserDefinition {

    private val whitespaces = TokenSet.create(TokenType.WHITE_SPACE)
    private val comments = TokenSet.create(ACSTypes.COMMENT)
    private val file: IFileElementType = IFileElementType(ACSLanguage) //TODO change this to stubs

    override fun createLexer(project: Project?): Lexer {
        return ACSLexerAdapter()
    }

    override fun getWhitespaceTokens(): TokenSet {
        return whitespaces
    }

    override fun getCommentTokens(): TokenSet {
        return comments
    }

    override fun getStringLiteralElements(): TokenSet {
        return TokenSet.EMPTY
    }

    override fun createParser(project: Project?): PsiParser {
        return ACSParser()
    }

    override fun getFileNodeType(): IFileElementType {
        return file
    }

    override fun spaceExistenceTypeBetweenTokens(left: ASTNode?, right: ASTNode?): ParserDefinition.SpaceRequirements {
        return ParserDefinition.SpaceRequirements.MAY
    }

    override fun createElement(node: ASTNode?): PsiElement {
        return ACSTypes.Factory.createElement(node)
    }

    override fun createFile(viewProvider: FileViewProvider): PsiFile {
        return ACSFile(viewProvider)
    }

}