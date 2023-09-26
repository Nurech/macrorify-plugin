package com.github.nurech.macrorifyplugin.language.parser;

import com.github.nurech.macrorifyplugin.language.SimpleLanguage;
import com.github.nurech.macrorifyplugin.language.SimpleLexerAdapter;
import com.github.nurech.macrorifyplugin.language.parser.SimpleParser;
import com.github.nurech.macrorifyplugin.language.psi.SimpleFile;
import com.github.nurech.macrorifyplugin.language.psi.SimpleTokenSets;
import com.github.nurech.macrorifyplugin.language.psi.SimpleTypes;
import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;

public class SimpleParserDefinition implements ParserDefinition {

  public static final IFileElementType FILE = new IFileElementType(SimpleLanguage.INSTANCE);

  @NotNull
  @Override
  public SimpleLexerAdapter createLexer(Project project) {
    return new SimpleLexerAdapter();
  }

  @NotNull
  @Override
  public TokenSet getCommentTokens() {
    return SimpleTokenSets.COMMENTS;
  }

  @NotNull
  @Override
  public TokenSet getStringLiteralElements() {
    return TokenSet.EMPTY;
  }

  @NotNull
  @Override
  public PsiParser createParser(final Project project) {
    return new SimpleParser();
  }

  @NotNull
  @Override
  public IFileElementType getFileNodeType() {
    return FILE;
  }

  @NotNull
  @Override
  public PsiFile createFile(@NotNull FileViewProvider viewProvider) {
    return new SimpleFile(viewProvider);
  }

  @NotNull
  @Override
  public PsiElement createElement(ASTNode node) {
    return SimpleTypes.Factory.createElement(node);
  }

}
