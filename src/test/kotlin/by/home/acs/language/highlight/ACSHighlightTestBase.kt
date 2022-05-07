package by.home.acs.language.highlight

import by.home.acs.language.ACSFileType
import by.home.acs.language.ACSTestBase
import com.intellij.codeInsight.daemon.impl.HighlightInfo
import com.intellij.openapi.editor.colors.TextAttributesKey
import org.assertj.core.api.Assertions

abstract class ACSHighlightTestBase : ACSTestBase() {
    protected fun testHighlighting(acsText: String, vararg expectedHighlight: Pair<String, TextAttributesKey>) {
        myFixture.configureByText(ACSFileType, acsText)
        val highlightInfo = myFixture.doHighlighting()
        assertThat(highlightInfo).containsExactly(*expectedHighlight)
    }

    private fun assertThat(highlightInfos: List<HighlightInfo>) =
        Assertions.assertThat(highlightInfos)
            .extracting<Pair<String, TextAttributesKey>> { Pair(it.text, it.forcedTextAttributesKey) }

    protected fun String.withType(type: TextAttributesKey): Pair<String, TextAttributesKey> = Pair(this, type)
}