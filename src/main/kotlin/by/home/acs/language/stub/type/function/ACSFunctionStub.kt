package by.home.acs.language.stub.type.function

import by.home.acs.language.psi.ACSPsiFunction
import by.home.acs.language.stub.ACSNamedStub
import com.intellij.psi.stubs.ILightStubElementType
import com.intellij.psi.stubs.StubElement
import com.intellij.util.io.StringRef

class ACSFunctionStub : ACSNamedStub<ACSPsiFunction?> {
    constructor(
        parent: StubElement<*>?,
        elementType: ILightStubElementType<*, *>,
        name: String?
    ) : super(parent, elementType, name)

    constructor(
        parent: StubElement<*>?,
        elementType: ILightStubElementType<*, *>,
        name: StringRef?
    ) : super(parent, elementType, name)

}