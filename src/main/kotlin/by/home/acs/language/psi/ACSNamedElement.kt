package by.home.acs.language.psi

import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiNameIdentifierOwner

interface ACSNamedElement : ACSElement, NavigatablePsiElement, PsiNameIdentifierOwner
