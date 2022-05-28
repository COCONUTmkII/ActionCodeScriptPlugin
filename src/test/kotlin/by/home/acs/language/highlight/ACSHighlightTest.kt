package by.home.acs.language.highlight

import by.home.acs.language.ACSTestBase

class ACSHighlightTest : ACSTestBase() {
    private val pathToFolder = getPathToFolder("/parser/variables")

    fun testHighlight() {
        val myFile = "$pathToFolder/fileVar.acs"
        myFixture.testHighlighting(myFile)
    }

}