package by.home.acs.language.stub.type.`var`.global

import by.home.acs.language.ACSTypes
import by.home.acs.language.psi.ACSPsiGlobalVar
import by.home.acs.language.psi.impl.ACSGlobalVarStatementImpl
import by.home.acs.language.stub.index.ACSGlobalVarNameIndex
import by.home.acs.language.stub.type.ACSNamedStubElementType
import com.intellij.lang.LighterAST
import com.intellij.lang.LighterASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LightTreeUtil
import com.intellij.psi.stubs.StubElement
import com.intellij.psi.stubs.StubInputStream
import com.intellij.psi.stubs.StubOutputStream

class ACSGlobalVarElementType(debugName: String) :
    ACSNamedStubElementType<ACSGlobalVarStub, ACSPsiGlobalVar>(debugName) {

    override val nameKey by lazy { ACSGlobalVarNameIndex.key }

    override fun createStub(psi: ACSPsiGlobalVar, parentStub: StubElement<out PsiElement>?): ACSGlobalVarStub =
        ACSGlobalVarStub(parentStub, this, psi.name)


    override fun createStub(tree: LighterAST, node: LighterASTNode, parentStub: StubElement<*>): ACSGlobalVarStub {
        val globalVarNode = LightTreeUtil.firstChildOfType(tree, node, ACSTypes.VARIABLE_NAME)
        val globalVarName = globalVarNode?.let { intern(tree.charTable, it) }
        return ACSGlobalVarStub(parentStub, this, globalVarName)
    }

    override fun createPsi(stub: ACSGlobalVarStub): ACSPsiGlobalVar =
        ACSGlobalVarStatementImpl(stub, this)

    override fun serialize(stub: ACSGlobalVarStub, dataStream: StubOutputStream) {
        dataStream.writeName(stub.name)
    }

    override fun deserialize(dataStream: StubInputStream, parentStub: StubElement<*>?): ACSGlobalVarStub =
        ACSGlobalVarStub(parentStub, this, dataStream.readName())


    override fun getExternalId(): String = super.getExternalId() + ".GLOBAL_VAR"

}
