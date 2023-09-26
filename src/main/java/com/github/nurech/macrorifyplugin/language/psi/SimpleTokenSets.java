package com.github.nurech.macrorifyplugin.language.psi;

import com.intellij.psi.tree.TokenSet;

public interface SimpleTokenSets {

  TokenSet IDENTIFIERS = TokenSet.create(SimpleTypes.KEY);

  TokenSet COMMENTS = TokenSet.create(SimpleTypes.COMMENT);

}
