package by.home.acs.language.annotator

import com.intellij.testFramework.fixtures.LightJavaCodeInsightFixtureTestCase

class ACSAnnotatorTest : LightJavaCodeInsightFixtureTestCase() {

    override fun getTestDataPath(): String {
        return "by/home/acs/language/annotator"
    }

    fun testBadScriptNumberAnnotator() {
        myFixture.configureByFile("badScriptNumber.acs")
    }

}
