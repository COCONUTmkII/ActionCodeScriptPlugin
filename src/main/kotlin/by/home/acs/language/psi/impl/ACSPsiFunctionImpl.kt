package by.home.acs.language.psi.impl



import by.home.acs.language.psi.ACSFunctionDefinition
import by.home.acs.language.psi.ACSFunctionParameters
import by.home.acs.language.psi.ACSFunctionReturnType
import by.home.acs.language.psi.ACSPsiFunction
import by.home.acs.language.stub.type.function.ACSFunctionStub
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.stubs.IStubElementType
import com.intellij.psi.stubs.StubElement

abstract class ACSPsiFunctionImpl : ACSNamedStubBasedPsiElementBase<ACSFunctionStub>, ACSPsiFunction,
    ACSFunctionDefinition {
    constructor(node: ASTNode) : super(node)

    constructor(stub: ACSFunctionStub, nodeType: IStubElementType<StubElement<*>, PsiElement>) : super(stub, nodeType)

    override fun getReturnType(): ACSFunctionReturnType? = functionReturnType

    override fun getName(): String = greenStub?.name ?: nameIdentifier?.text ?: text

    override fun getNameIdentifier(): PsiElement? = node.psi ?: null

    override fun getParameterList(): ACSFunctionParameters? = functionParameters

    override fun isTypeCastFunction(): Boolean = false

    override fun isMultiCastFunction(): Boolean = false
}