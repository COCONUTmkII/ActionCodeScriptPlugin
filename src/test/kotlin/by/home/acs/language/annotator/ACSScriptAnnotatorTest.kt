package by.home.acs.language.annotator

class ACSScriptAnnotatorTest : ACSAnnotatorTestBase() {

    fun testBadScriptNumberAnnotator() {
        testAnnotator("annotator/badScriptNumber.acs")
    }
}