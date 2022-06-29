package by.home.acs.language.reference

import by.home.acs.language.psi.ACSFunctionDeclaration

class ACSReferenceTest : ACSReferenceTestBase() {
    fun `test function declaration reference`() = testReference("function.acs") {
        it is ACSFunctionDeclaration && it.name == "foo"
    }
}