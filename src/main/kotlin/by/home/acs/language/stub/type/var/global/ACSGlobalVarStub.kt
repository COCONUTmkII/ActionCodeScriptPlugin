package by.home.acs.language.stub.type.`var`.global

import by.home.acs.language.psi.ACSPsiGlobalVar
import by.home.acs.language.stub.ACSNamedStub
import com.intellij.psi.stubs.ILightStubElementType
import com.intellij.psi.stubs.StubElement
import com.intellij.util.io.StringRef

class ACSGlobalVarStub : ACSNamedStub<ACSPsiGlobalVar?> {
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
