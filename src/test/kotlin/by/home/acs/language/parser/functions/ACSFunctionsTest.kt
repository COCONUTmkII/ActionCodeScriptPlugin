package by.home.acs.language.parser.functions

import by.home.acs.language.parser.ACSParserTestBase

class ACSFunctionsTest : ACSParserTestBase("functions") {

    fun testFunctionDeclarations() = doParserTest()
    fun testFunctionInvocations() = doParserTest()

}