package by.home.acs.language.formatter

import by.home.acs.language.ACSLanguage
import by.home.acs.language.ACSTypes
import com.intellij.formatting.*
import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiFile
import com.intellij.psi.codeStyle.CodeStyleSettings


class ACSFormattingModelBuilder : FormattingModelBuilder {

    private fun createSpaceBuilder(settings: CodeStyleSettings): SpacingBuilder {
        return SpacingBuilder(settings, ACSLanguage)
            .after(ACSTypes.SEMICOLON).lineBreakInCode()
    }

    override fun createModel(formattingContext: FormattingContext): FormattingModel {
        val codeStyleSettings = formattingContext.codeStyleSettings
        return FormattingModelProvider
            .createFormattingModelForPsiFile(
                formattingContext.containingFile,
                ACSBlock(
                    formattingContext.node,
                    null,
                    null,
                    createSpaceBuilder(codeStyleSettings)
                ),
                codeStyleSettings
            )
    }

    override fun getRangeAffectingIndent(file: PsiFile?, offset: Int, elementAtOffset: ASTNode?): TextRange? = null
}
