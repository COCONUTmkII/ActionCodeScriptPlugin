package by.home.acs.language.psi

import by.home.acs.language.ACSLanguage
import by.home.acs.language.stub.type.`var`.global.ACSGlobalVarElementType
import by.home.acs.language.stub.type.function.ACSFunctionElementType
import by.home.acs.language.stub.type.`var`.ACSVariableElementType
import com.intellij.psi.tree.IElementType

class ACSElementType(debugName: String?) : IElementType(debugName.toString(), ACSLanguage) {

    companion object {
        @JvmStatic
        fun createTypes(type: String): IElementType {
            return when(type) {
                "FUNCTION_DECLARATION" -> ACSFunctionElementType(type)
                "GLOBAL_VAR_STATEMENT" -> ACSGlobalVarElementType(type)
                "VARIABLE_DECLARATION" -> ACSVariableElementType(type)
                else -> ACSElementType(type)
            }
        }
    }

}
