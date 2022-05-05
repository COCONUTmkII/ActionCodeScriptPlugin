package by.home.acs.language.psi

import by.home.acs.language.ACSLanguage
import by.home.acs.language.stub.type.function.ACSFunctionElementType
import com.intellij.psi.tree.IElementType

class ACSElementType(debugName: String?) : IElementType(debugName.toString(), ACSLanguage) {

    companion object {
        @JvmStatic
        fun createTypes(type: String): IElementType {
            return when(type) {
                "FUNCTION_DECLARATION" -> ACSFunctionElementType(type)
                else -> ACSElementType(type)
            }
        }
    }

}
