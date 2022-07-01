package by.home.acs.language.psi.mixin

import by.home.acs.language.psi.ACSGlobalVarStatement
import by.home.acs.language.psi.ACSPsiGlobalVar
import by.home.acs.language.psi.ACSType
import by.home.acs.language.psi.impl.ACSNamedStubBasedPsiElementBase
import by.home.acs.language.stub.type.`var`.global.ACSGlobalVarStub
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.stubs.IStubElementType
import com.intellij.psi.stubs.StubElement

abstract class ACSPsiGlobalVarMixin : ACSNamedStubBasedPsiElementBase<ACSGlobalVarStub>,
    ACSPsiGlobalVar, ACSGlobalVarStatement {

    constructor(node: ASTNode) : super(node)

    constructor(stub: ACSGlobalVarStub, nodeType: IStubElementType<StubElement<*>, PsiElement>) : super(stub, nodeType)

    override fun getNameIdentifier(): PsiElement? = globalVarName.identifier

    override fun getName(): String? = globalVarName.text ?: nameIdentifier?.text ?: text

    override fun getGlobalVarType(): ACSType = type

}
