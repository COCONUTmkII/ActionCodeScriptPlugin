package by.home.acs.language.reference

import by.home.acs.language.psi.ACSFunctionDeclaration
import by.home.acs.language.psi.ACSGlobalVarStatement

class ACSReferenceTest : ACSReferenceTestBase() {
    fun `test function declaration reference`() = testReference("function.acs") {
        it is ACSFunctionDeclaration && it.name == "foo"
    }

    fun `test global variable reference`() = testReference("global_var.acs") {
        it is ACSGlobalVarStatement && it.name == "a"
    }

    fun `test world variable reference`() = testReference("world_var.acs") {
        it is ACSGlobalVarStatement && it.name == "a"
    }
}