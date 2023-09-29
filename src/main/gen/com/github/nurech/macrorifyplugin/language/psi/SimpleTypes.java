// This is a generated file. Not intended for manual editing.
package com.github.nurech.macrorifyplugin.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.nurech.macrorifyplugin.language.psi.impl.*;

public interface SimpleTypes {

  IElementType PROPERTY = new SimpleElementType("PROPERTY");
  IElementType VAR_DECLARATION = new SimpleElementType("VAR_DECLARATION");

  IElementType BOOLEAN = new SimpleTokenType("BOOLEAN");
  IElementType COMMENT = new SimpleTokenType("COMMENT");
  IElementType CRLF = new SimpleTokenType("CRLF");
  IElementType IDENTIFIER = new SimpleTokenType("IDENTIFIER");
  IElementType KEY = new SimpleTokenType("KEY");
  IElementType KEYWORD = new SimpleTokenType("KEYWORD");
  IElementType NUMBER = new SimpleTokenType("NUMBER");
  IElementType OPERATOR = new SimpleTokenType("OPERATOR");
  IElementType SEMICOLON = new SimpleTokenType("SEMICOLON");
  IElementType SEPARATOR = new SimpleTokenType("SEPARATOR");
  IElementType STRING = new SimpleTokenType("STRING");
  IElementType VALUE = new SimpleTokenType("VALUE");
  IElementType VARIABLE = new SimpleTokenType("VARIABLE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == PROPERTY) {
        return new SimplePropertyImpl(node);
      }
      else if (type == VAR_DECLARATION) {
        return new SimpleVarDeclarationImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
