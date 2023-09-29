// This is a generated file. Not intended for manual editing.
package com.github.nurech.macrorifyplugin.language;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.github.nurech.macrorifyplugin.language.psi.SimpleTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class SimpleParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return simpleFile(b, l + 1);
  }

  /* ********************************************************** */
  // var_declaration | property | KEYWORD | COMMENT | CRLF | STRING | BOOLEAN | NUMBER | IDENTIFIER | KEY | OPERATOR | SEMICOLON
  static boolean item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = var_declaration(b, l + 1);
    if (!r) r = property(b, l + 1);
    if (!r) r = consumeToken(b, KEYWORD);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, CRLF);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, BOOLEAN);
    if (!r) r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, KEY);
    if (!r) r = consumeToken(b, OPERATOR);
    if (!r) r = consumeToken(b, SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (KEY? SEPARATOR VALUE?) | KEY
  public static boolean property(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PROPERTY, "<property>");
    r = property_0(b, l + 1);
    if (!r) r = consumeToken(b, KEY);
    exit_section_(b, l, m, r, false, SimpleParser::recover_property);
    return r;
  }

  // KEY? SEPARATOR VALUE?
  private static boolean property_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = property_0_0(b, l + 1);
    r = r && consumeToken(b, SEPARATOR);
    r = r && property_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // KEY?
  private static boolean property_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_0_0")) return false;
    consumeToken(b, KEY);
    return true;
  }

  // VALUE?
  private static boolean property_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_0_2")) return false;
    consumeToken(b, VALUE);
    return true;
  }

  /* ********************************************************** */
  // !(KEY|SEPARATOR|COMMENT)
  static boolean recover_property(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_property")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !recover_property_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // KEY|SEPARATOR|COMMENT
  private static boolean recover_property_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_property_0")) return false;
    boolean r;
    r = consumeToken(b, KEY);
    if (!r) r = consumeToken(b, SEPARATOR);
    if (!r) r = consumeToken(b, COMMENT);
    return r;
  }

  /* ********************************************************** */
  // item_*
  static boolean simpleFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simpleFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!item_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "simpleFile", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // VARIABLE IDENTIFIER KEY OPERATOR (STRING|NUMBER|BOOLEAN) SEMICOLON
  public static boolean var_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_declaration")) return false;
    if (!nextTokenIs(b, VARIABLE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, VAR_DECLARATION, null);
    r = consumeTokens(b, 0, VARIABLE, IDENTIFIER, KEY, OPERATOR);
    r = r && var_declaration_4(b, l + 1);
    p = r; // pin = 5
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // STRING|NUMBER|BOOLEAN
  private static boolean var_declaration_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_declaration_4")) return false;
    boolean r;
    r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, BOOLEAN);
    return r;
  }

}
