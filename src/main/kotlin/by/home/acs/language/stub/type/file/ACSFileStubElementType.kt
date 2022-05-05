package by.home.acs.language.stub.type.file

import by.home.acs.language.ACSLanguage
import com.intellij.psi.stubs.StubElement
import com.intellij.psi.stubs.StubInputStream
import com.intellij.psi.stubs.StubOutputStream
import com.intellij.psi.tree.IStubFileElementType

class ACSFileStubElementType(language: ACSLanguage): IStubFileElementType<ACSFileStub>(language) {
        override fun serialize(stub: ACSFileStub, dataStream: StubOutputStream) = Unit

    override fun deserialize(dataStream: StubInputStream, parentStub: StubElement<*>?): ACSFileStub =
        ACSFileStub(null)

    override fun getExternalId(): String = super.getExternalId() + ".ACS_FILE"
}
