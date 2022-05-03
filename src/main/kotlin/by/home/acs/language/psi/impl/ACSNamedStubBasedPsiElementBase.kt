package by.home.acs.language.psi.impl

import by.home.acs.language.icon.ACSIcons
import by.home.acs.language.psi.ACSNamedElement
import com.intellij.extapi.psi.StubBasedPsiElementBase
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.stubs.ILightStubElementType
import com.intellij.psi.stubs.StubElement
import javax.swing.Icon

abstract class ACSNamedStubBasedPsiElementBase<T : StubElement<*>> : StubBasedPsiElementBase<T>, ACSNamedElement {
    constructor(stub: T, nodeType: ILightStubElementType<*, *>) : super(stub, nodeType)

    constructor(node: ASTNode) : super(node)

    override fun setName(name: String): PsiElement = apply {
        nameIdentifier?.reference?.handleElementRename(name)
    }

    override fun getNavigationElement(): PsiElement = nameIdentifier ?: this

    override fun getTextOffset(): Int {
        val nameIdentifier = nameIdentifier
        return if (nameIdentifier != null && nameIdentifier !== this) {
            nameIdentifier.textOffset
        } else {
            super.getTextOffset()
        }
    }

    override fun toString(): String = node.elementType.toString()

    override fun getIcon(flags: Int): Icon? = ACSIcons.FILE
}