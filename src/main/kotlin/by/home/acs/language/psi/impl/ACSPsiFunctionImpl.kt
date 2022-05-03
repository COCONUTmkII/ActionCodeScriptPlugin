package by.home.acs.language.psi.impl


import by.home.acs.language.psi.ACSPsiFunction
import by.home.acs.language.psi.ACScriptFunctionParameterList
import by.home.acs.language.psi.ACScriptType
import by.home.acs.language.stub.type.function.ACSFunctionStub
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiModifierList
import com.intellij.psi.javadoc.PsiDocComment
import com.intellij.psi.stubs.ILightStubElementType

//TODO change this to mixin
class ACSPsiFunctionImpl : ACSNamedStubBasedPsiElementBase<ACSFunctionStub>, ACSPsiFunction {
    constructor(node: ASTNode) : super(node)

    constructor(stub: ACSFunctionStub, nodeType: ILightStubElementType<*, *>) : super(stub, nodeType)

    override fun getReturnType(): ACScriptType {
        TODO("Need to provide a return type")
    }

    override fun getName(): String = greenStub?.name ?: nameIdentifier?.text ?: text

    override fun getNameIdentifier(): PsiElement? {
        TODO("Not yet implemented")
    }

    override fun getModifierList(): PsiModifierList? {
        TODO("Not yet implemented")
    }

    override fun hasModifierProperty(name: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun getContainingClass(): PsiClass? {
        TODO("Not yet implemented")
    }

    override fun getParameterList(): ACScriptFunctionParameterList? {
        TODO("Need to implement parameters")
    }

    override fun isTypeCastFunction(): Boolean = false

    override fun isMultiCastFunction(): Boolean = false

    override fun getDocComment(): PsiDocComment? = null

    override fun isDeprecated(): Boolean = false
}