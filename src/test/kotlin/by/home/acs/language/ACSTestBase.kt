package by.home.acs.language

import com.intellij.testFramework.fixtures.LightJavaCodeInsightFixtureTestCase

const val myBasePath = "by/home/acs/language/"

abstract class ACSTestBase : LightJavaCodeInsightFixtureTestCase() {

    override fun getTestDataPath(): String = "src/test/resources"

    fun getPathToFolder(path: String): String {
        return myBasePath + path
    }
}