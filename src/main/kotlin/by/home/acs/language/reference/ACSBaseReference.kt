package by.home.acs.language.reference

import com.intellij.openapi.util.TextRange
import com.intellij.psi.*
import com.intellij.psi.impl.source.resolve.ResolveCache

abstract class ACSBaseReference(val psiElement: PsiElement, range: TextRange) :
    PsiReferenceBase<PsiElement?>(psiElement, range), PsiPolyVariantReference {

    protected abstract fun resolveInner(incompleteCode: Boolean): List<PsiElement>

    override fun multiResolve(incompleteCode: Boolean): Array<ResolveResult> {
        return ResolveCache.getInstance(psiElement.project).resolveWithCaching(
            this, { acsBaseReference, _ ->
                acsBaseReference.resolveInner(false)
                    .map { PsiElementResolveResult(it) }
                    .toTypedArray()
            }, true, false
        )
    }

    override fun resolve(): PsiElement? {
        val resolveResults = multiResolve(false)
        return if (resolveResults.size == 1) resolveResults[0].element else null
    }
}