package by.home.acs.language.stub

import by.home.acs.language.psi.ACSNamedElement
import com.intellij.psi.stubs.ILightStubElementType
import com.intellij.psi.stubs.NamedStubBase
import com.intellij.psi.stubs.StubElement
import com.intellij.util.io.StringRef

open class ACSNamedStub<T : ACSNamedElement?> : NamedStubBase<T> {
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