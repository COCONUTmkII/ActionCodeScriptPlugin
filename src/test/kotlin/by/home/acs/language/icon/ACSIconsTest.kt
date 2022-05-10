package by.home.acs.language.icon

import com.intellij.openapi.util.IconLoader
import org.junit.Assert.assertNotNull
import org.junit.Test
import javax.swing.Icon

class ACSIconsTest {

    @Test
    fun `get file icon`() {
        val icon: Icon = IconLoader.getIcon("/icons/acs_icon.png", ACSIcons.javaClass)
        assertNotNull(icon)
    }
}