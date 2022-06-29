package by.home.acs.language.reference

import com.intellij.psi.PsiElement

class ACSNamedElementReference(psiElement: PsiElement) : ACSBaseReference(psiElement, psiElement.textRange) {
    override fun resolveInner(incompleteCode: Boolean): List<PsiElement> = listOf(psiElement)
}