package by.home.acs.language.highlight

import by.home.acs.language.ACSTestBase

class ACSHighlightTest : ACSTestBase() {

    fun testHighlight() {
        val myFile = "by/home/acs/language/parser/variables/fileVar.acs"
        myFixture.testHighlighting(myFile)
    }

}