package by.home.acs.language.stub.type.function

import by.home.acs.language.ACSTypes
import by.home.acs.language.psi.ACSPsiFunction
import by.home.acs.language.psi.impl.ACSFunctionDeclarationImpl
import by.home.acs.language.stub.index.ACSFunctionNameIndex
import by.home.acs.language.stub.type.ACSNamedStubElementType
import com.intellij.lang.LighterAST
import com.intellij.lang.LighterASTNode
import com.intellij.lang.LighterASTTokenNode
import com.intellij.psi.impl.source.tree.LightTreeUtil
import com.intellij.psi.stubs.StubElement
import com.intellij.psi.stubs.StubInputStream
import com.intellij.psi.stubs.StubOutputStream
import com.intellij.util.CharTable

class ACSFunctionElementType(debugName: String) :
    ACSNamedStubElementType<ACSFunctionStub, ACSPsiFunction>(debugName) {

    override val nameKey by lazy { ACSFunctionNameIndex.key }

    override fun createStub(psi: ACSPsiFunction, parentStub: StubElement<*>?): ACSFunctionStub =
        ACSFunctionStub(parentStub, this, psi.name)

    override fun createStub(tree: LighterAST, node: LighterASTNode, parentStub: StubElement<*>): ACSFunctionStub {
        val functionNode = LightTreeUtil.firstChildOfType(tree, node, ACSTypes.FUNCTION_NAME)
        val functionName = functionNode?.let { intern(tree.charTable, it) }
        return ACSFunctionStub(parentStub, this, functionName)
    }

    override fun createPsi(stub: ACSFunctionStub): ACSPsiFunction =
        ACSFunctionDeclarationImpl(stub, this)


    override fun serialize(stub: ACSFunctionStub, dataStream: StubOutputStream) {
        dataStream.writeName(stub.name)
    }

    override fun deserialize(dataStream: StubInputStream, parentStub: StubElement<*>): ACSFunctionStub {
        val name = dataStream.readName()
        return ACSFunctionStub(parentStub, this, name)
    }

    override fun getExternalId(): String = super.getExternalId() + ".FUNCTION"

    private fun intern(charTable: CharTable, functionNode: LighterASTNode): String {
        assert(functionNode is LighterASTTokenNode) { functionNode }
        return charTable.intern((functionNode as LighterASTTokenNode).text).toString()
    }
}
