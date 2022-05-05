package by.home.acs.language.psi.impl



import by.home.acs.language.psi.ACSFunctionDeclaration
import by.home.acs.language.psi.ACSFunctionParameters
import by.home.acs.language.psi.ACSFunctionReturnType
import by.home.acs.language.psi.ACSPsiFunction
import by.home.acs.language.stub.type.function.ACSFunctionStub
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.stubs.IStubElementType
import com.intellij.psi.stubs.StubElement

abstract class ACSPsiFunctionImpl : ACSNamedStubBasedPsiElementBase<ACSFunctionStub>, ACSPsiFunction,
    ACSFunctionDeclaration {
    constructor(node: ASTNode) : super(node)

    constructor(stub: ACSFunctionStub, nodeType: IStubElementType<StubElement<*>, PsiElement>) : super(stub, nodeType)

    override fun getReturnType(): ACSFunctionReturnType? = functionReturnType

    override fun getName(): String = functionName?.text ?: nameIdentifier?.text ?: text

    override fun getNameIdentifier(): PsiElement? = functionName?.identifier

    override fun getParameterList(): ACSFunctionParameters? = functionParameters

    override fun isTypeCastFunction(): Boolean = false

    override fun isMultiCastFunction(): Boolean = false
}