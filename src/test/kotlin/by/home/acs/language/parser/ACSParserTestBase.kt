package by.home.acs.language.parser

import by.home.acs.language.myBasePath
import com.intellij.testFramework.ParsingTestCase

abstract class ACSParserTestBase(path: String) :
    ParsingTestCase(myBasePath +"parser/" + path, "acs", true, ACSParserDefinition()) {
    override fun getTestDataPath(): String = "src/test/resources"

    fun doParserTest() = doTest(true)

    override fun includeRanges(): Boolean = true

}
