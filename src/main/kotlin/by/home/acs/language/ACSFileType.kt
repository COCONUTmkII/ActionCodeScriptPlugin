package by.home.acs.language

import by.home.acs.language.icon.ACSIcons
import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

object ACSFileType : LanguageFileType(ACSLanguage) {

    override fun getName(): String {
        return "ACS Script file"
    }

    override fun getDescription(): String {
        return "ACS Script language file"
    }

    override fun getDefaultExtension(): String {
        return "acs"
    }

    override fun getIcon(): Icon {
        return ACSIcons.FILE
    }
}
