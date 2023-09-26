// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package com.github.nurech.macrorifyplugin.language;

import com.github.nurech.macrorifyplugin.language.psi.SimpleTypes;
import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

public class SimpleCompletionContributor extends CompletionContributor {

  public SimpleCompletionContributor() {
    extend(CompletionType.BASIC, PlatformPatterns.psiElement(SimpleTypes.VALUE),
        new CompletionProvider<>() {
          public void addCompletions(@NotNull CompletionParameters parameters,
                                     @NotNull ProcessingContext context,
                                     @NotNull CompletionResultSet resultSet) {
            resultSet.addElement(LookupElementBuilder.create("Hello"));
          }
        }
    );
  }

}
