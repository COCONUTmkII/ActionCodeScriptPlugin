package by.home.acs.language.stub.type.`var`

import by.home.acs.language.ACSTypes
import by.home.acs.language.psi.ACSPsiVariable
import by.home.acs.language.psi.impl.ACSVariableDeclarationImpl
import by.home.acs.language.stub.index.ACSVariableNameIndex
import by.home.acs.language.stub.type.ACSNamedStubElementType
import com.intellij.lang.LighterAST
import com.intellij.lang.LighterASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LightTreeUtil
import com.intellij.psi.stubs.StubElement
import com.intellij.psi.stubs.StubInputStream
import com.intellij.psi.stubs.StubOutputStream

class ACSVariableElementType(debugName: String) : ACSNamedStubElementType<ACSVariableStub, ACSPsiVariable>(debugName) {

    override val nameKey by lazy { ACSVariableNameIndex.key }

    override fun createStub(psi: ACSPsiVariable, parentStub: StubElement<out PsiElement>?): ACSVariableStub =
        ACSVariableStub(parentStub, this, psi.name)


    override fun createStub(tree: LighterAST, node: LighterASTNode, parentStub: StubElement<*>): ACSVariableStub {
        val globalVarNode = LightTreeUtil.firstChildOfType(tree, node, ACSTypes.VARIABLE_NAME)
        val globalVarName = globalVarNode?.let { intern(tree.charTable, it) }
        return ACSVariableStub(parentStub, this, globalVarName)
    }

    override fun createPsi(stub: ACSVariableStub): ACSPsiVariable =
        ACSVariableDeclarationImpl(stub, this)

    override fun serialize(stub: ACSVariableStub, dataStream: StubOutputStream) {
        dataStream.writeName(stub.name)
    }

    override fun deserialize(dataStream: StubInputStream, parentStub: StubElement<*>?): ACSVariableStub =
        ACSVariableStub(parentStub, this, dataStream.readName())

    override fun getExternalId(): String = super.getExternalId() + ".VARIABLE_DECLARATION"
}
