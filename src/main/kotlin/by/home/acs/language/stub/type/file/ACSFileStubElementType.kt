package by.home.acs.language.stub.type.file

import by.home.acs.language.ACSLanguage
import com.intellij.psi.stubs.StubElement
import com.intellij.psi.stubs.StubInputStream
import com.intellij.psi.stubs.StubOutputStream
import com.intellij.psi.tree.IStubFileElementType

class ACSFileStubElementType(language: ACSLanguage) : IStubFileElementType<ACSFileStub>(language) {
    override fun getStubVersion(): Int = VERSION

    override fun serialize(stub: ACSFileStub, dataStream: StubOutputStream) = Unit

    override fun deserialize(dataStream: StubInputStream, parentStub: StubElement<*>?): ACSFileStub =
        ACSFileStub(null)

    companion object {
        @JvmField
        val INSTANCE = ACSFileStubElementType(ACSLanguage)

        private const val VERSION = 6
    }

    override fun getExternalId(): String = super.getExternalId() + "acs.FILE"
}
