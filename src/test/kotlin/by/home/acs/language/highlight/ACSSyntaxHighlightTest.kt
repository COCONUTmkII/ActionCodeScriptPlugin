package by.home.acs.language.highlight

class ACSSyntaxHighlightTest : ACSHighlightTestBase() {

    fun testGlobalDeclaration() {
        testHighlighting("global int 1 : test;", "global".withType(ACSTextAttributeKeyValue.KEY),
            "int".withType(ACSTextAttributeKeyValue.KEY),"1".withType(ACSTextAttributeKeyValue.INT_VALUE),"test".withType(ACSTextAttributeKeyValue.IDENTIFIER)
        )
    }
}