package by.home.acs.language.annotator

import by.home.acs.language.ACSTypes
import by.home.acs.language.psi.ACSScriptName
import com.intellij.codeInspection.ProblemHighlightType
import com.intellij.lang.ASTNode
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType
import java.math.BigInteger

object ACSScriptNumberAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element !is ACSScriptName) {
            return
        }
        val acsScriptScriptName: ACSScriptName = element
        if (acsScriptScriptName.firstChild.elementType == ACSTypes.NUMBER) {
            checkScript(acsScriptScriptName.node, holder)
        }
    }

    private fun checkScript(astNode: ASTNode, holder: AnnotationHolder) {
        val maxScriptNumber = BigInteger.valueOf(32767)
        val scriptNumber = BigInteger(astNode.text)
        if (scriptNumber < BigInteger.ONE || scriptNumber > maxScriptNumber) {
            createScriptNumberErrorAnnotator(astNode, holder)
        }
    }

    private fun createScriptNumberErrorAnnotator(astNode: ASTNode, holder: AnnotationHolder) {
        val textRange = TextRange(astNode.startOffset, astNode.textRange.endOffset)
        holder.newAnnotation(HighlightSeverity.ERROR, "Script number can be only > 1 and < 32767 inclusive")
            .range(textRange)
            .highlightType(ProblemHighlightType.ERROR)
            .create()
    }
}