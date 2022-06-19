package by.home.acs.language.psi.mixin

import by.home.acs.language.psi.impl.ACSElementImpl
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiReference

open class ACSFunctionNameMixin(node: ASTNode) : ACSElementImpl(node) {
    override fun getReference(): PsiReference? {
        return super.getReference()
    }
}