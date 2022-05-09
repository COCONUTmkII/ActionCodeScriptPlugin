package by.home.acs.language.highlight

import com.intellij.testFramework.fixtures.LightJavaCodeInsightFixtureTestCase

class ACSHighlightTest : LightJavaCodeInsightFixtureTestCase() {

    fun testHighlight() {
        val myFile = "by/home/acs/language/parser/variables/fileVar.acs"
        myFixture.testHighlighting(myFile)
    }

    override fun getTestDataPath()  = "src/test/resources"

}