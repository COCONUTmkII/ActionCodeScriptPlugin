package by.home.acs.language.parser

import com.intellij.testFramework.ParsingTestCase

abstract class ACSParserTestBase(path: String) :
    ParsingTestCase("by/home/acs/language/parser/$path", "acs", true, ACSParserDefinition()) {

    override fun getTestDataPath(): String = "src/test/resources"

    fun doTest() = doTest(true)
}
