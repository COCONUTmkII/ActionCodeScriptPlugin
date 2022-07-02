package by.home.acs.language.psi.mixin

import by.home.acs.language.psi.ACSPsiVariable
import by.home.acs.language.psi.ACSType
import by.home.acs.language.psi.ACSVariableDeclaration
import by.home.acs.language.psi.impl.ACSNamedStubBasedPsiElementBase
import by.home.acs.language.stub.type.`var`.ACSVariableStub
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.stubs.IStubElementType
import com.intellij.psi.stubs.StubElement

abstract class ACSPsiVariableMixin : ACSNamedStubBasedPsiElementBase<ACSVariableStub>,
    ACSPsiVariable, ACSVariableDeclaration {

    constructor(node: ASTNode) : super(node)

    constructor(stub: ACSVariableStub, nodeType: IStubElementType<StubElement<*>, PsiElement>) : super(stub, nodeType)

    override fun getVariableType(): ACSType = type

    override fun isStaticType(): Boolean = false

    override fun isArrayType(): Boolean = false

    override fun getNameIdentifier(): PsiElement? = repeatableVariable.variableName.identifier

    override fun getName(): String? = repeatableVariable.variableName.text
}
