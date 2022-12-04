package by.home.acs.language.psi.mixin

import by.home.acs.language.psi.impl.ACSElementImpl
import by.home.acs.language.reference.ACSBaseReference
import by.home.acs.language.util.ACSResolverUtil
import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference

open class ACSGlobalVarNameMixin(node: ASTNode) : ACSElementImpl(node) {
    override fun getReference(): PsiReference? {
        return object : ACSBaseReference(this, TextRange(0, textLength)) {
            override fun resolveInner(incompleteCode: Boolean): List<PsiElement> {
                return ACSResolverUtil.findGlobalVarsByName(project, node.text)
            }
        }
    }
}
