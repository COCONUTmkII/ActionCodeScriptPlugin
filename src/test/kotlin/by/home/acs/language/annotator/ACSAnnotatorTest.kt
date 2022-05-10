package by.home.acs.language.annotator

import by.home.acs.language.ACSTestBase
class ACSAnnotatorTest : ACSTestBase() {

    fun testBadScriptNumberAnnotator() {
        testAnnotator("annotator/badScriptNumber.acs")
    }

}
