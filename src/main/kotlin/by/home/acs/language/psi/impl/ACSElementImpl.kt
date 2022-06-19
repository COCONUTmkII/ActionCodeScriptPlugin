package by.home.acs.language.psi.impl

import by.home.acs.language.psi.ACSElement
import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode

open class ACSElementImpl(node: ASTNode) : ASTWrapperPsiElement(node), ACSElement {
    override fun toString(): String = node.elementType.toString()
}
