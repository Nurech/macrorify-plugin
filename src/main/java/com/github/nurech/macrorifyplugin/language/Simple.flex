// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package com.github.nurech.macrorifyplugin.language;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;

%%

%class SimpleLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

CRLF=\R
WHITE_SPACE=[\ \n\t\f]
FIRST_VALUE_CHARACTER=[^ \n\f\\] | "\\"{CRLF} | "\\".
VALUE_CHARACTER=[^\n\f\\] | "\\"{CRLF} | "\\".
END_OF_LINE_COMMENT=("#"|"!")[^\r\n]*
SEPARATOR=[:=]
COMMENT="//"
NUMBER=[0-9]+
BOOLEAN="true"|"false"
StringLiteral = \" ( \\\" | [^\"\n\r] )* \"
IDENTIFIER="var"
KEY=[a-zA-Z_][a-zA-Z0-9_]*
OPERATOR="="
SEMICOLON=";"

%state WAITING_VALUE
%state VAR_DECLARED

%%

<YYINITIAL> {
  {SEMICOLON}                     { yybegin(YYINITIAL); return SimpleTypes.SEMICOLON; }
  {IDENTIFIER}                    { yybegin(YYINITIAL); return SimpleTypes.IDENTIFIER; }
  {OPERATOR}                      { yybegin(YYINITIAL); return SimpleTypes.OPERATOR; }
  {BOOLEAN}                       { yybegin(YYINITIAL); return SimpleTypes.BOOLEAN; }
  {SEPARATOR}                     { yybegin(WAITING_VALUE); return SimpleTypes.SEPARATOR; }
  {StringLiteral}                 { yybegin(YYINITIAL); return SimpleTypes.STRING; }
  ({CRLF}|{WHITE_SPACE})+         { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
  {KEY}                           { yybegin(YYINITIAL); return SimpleTypes.KEY; }
  {END_OF_LINE_COMMENT}           { yybegin(YYINITIAL); return SimpleTypes.COMMENT; }
  {NUMBER}                        { yybegin(YYINITIAL); return SimpleTypes.NUMBER; }
  [^]                             { return TokenType.BAD_CHARACTER; }
  {COMMENT}.*                     { return SimpleTypes.COMMENT; }
  {COMMENT}.+                     { return SimpleTypes.COMMENT; }
  {COMMENT}\n                     { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
      }

<WAITING_VALUE> {
{CRLF}({CRLF}|{WHITE_SPACE})+              { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
{WHITE_SPACE}+                             { yybegin(WAITING_VALUE); return TokenType.WHITE_SPACE; }
{FIRST_VALUE_CHARACTER}{VALUE_CHARACTER}*  { yybegin(YYINITIAL); return SimpleTypes.VALUE; }
}
