package by.home.acs.language.reference

import by.home.acs.language.util.ACSResolverUtil
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement

//TODO use reference
class ACSVariableReference(element: PsiElement) : ACSBaseReference(element, TextRange(0, element.textLength)) {

    override fun resolveInner(incompleteCode: Boolean): List<PsiElement> {
        val owner = elementOwner
        if (owner != null) {
            return listOf(owner)
        }
        val references = findReferences(incompleteCode).toMutableList()
        if (references.isNotEmpty() && !incompleteCode) {
            return references
        }
        references.addAll(ACSResolverUtil.findVariablesFromUsage(psiElement, incompleteCode))
        return references
    }

    private fun findReferences(incompleteCode: Boolean): List<PsiElement> {
        TODO("Not yet implemented")
    }
}