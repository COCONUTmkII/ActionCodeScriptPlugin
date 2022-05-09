package by.home.acs.language.annotator

import com.intellij.testFramework.fixtures.LightJavaCodeInsightFixtureTestCase

abstract class ACSAnnotatorTestBase : LightJavaCodeInsightFixtureTestCase() {

    override fun getTestDataPath(): String = "src/test/resources"

    fun testAnnotator(path: String) {
        myFixture.configureByFile("by/home/acs/language/$path")
        myFixture.checkHighlighting(false, false, true, true)
        myFixture.checkResultByFile("by/home/acs/language/$path")
    }
}