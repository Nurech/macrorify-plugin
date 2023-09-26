// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package com.github.nurech.macrorifyplugin.language;

import com.github.nurech.macrorifyplugin.language.psi.SimpleProperty;
import com.intellij.lang.refactoring.RefactoringSupportProvider;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SimpleRefactoringSupportProvider extends RefactoringSupportProvider {

  @Override
  public boolean isMemberInplaceRenameAvailable(@NotNull PsiElement elementToRename, @Nullable PsiElement context) {
    return (elementToRename instanceof SimpleProperty);
  }

}
