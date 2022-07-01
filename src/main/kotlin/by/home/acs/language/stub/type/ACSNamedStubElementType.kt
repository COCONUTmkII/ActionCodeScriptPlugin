package by.home.acs.language.stub.type

import by.home.acs.language.psi.ACSNamedElement
import com.intellij.lang.LighterASTNode
import com.intellij.lang.LighterASTTokenNode
import com.intellij.psi.stubs.IndexSink
import com.intellij.psi.stubs.NamedStubBase
import com.intellij.psi.stubs.StubIndexKey
import com.intellij.util.CharTable

abstract class ACSNamedStubElementType<StubT : NamedStubBase<*>, PsiT : ACSNamedElement?>(debugName: String) :
    ACSStubElementType<StubT, PsiT>(debugName) {

    protected abstract val nameKey: StubIndexKey<String, in PsiT>

    override fun indexStub(stub: StubT, sink: IndexSink) {
        val name = stub.name
        if (name != null) {
            sink.occurrence(nameKey, name)
        }
    }

    protected fun intern(charTable: CharTable, nodeWithName: LighterASTNode): String {
        assert(nodeWithName is LighterASTTokenNode) { nodeWithName }
        return charTable.intern((nodeWithName as LighterASTTokenNode).text).toString()
    }
}