// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package com.github.nurech.macrorifyplugin.language;

import com.github.nurech.macrorifyplugin.language.psi.SimpleTypes;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class SimpleSyntaxHighlighter extends SyntaxHighlighterBase {

    public static final TextAttributesKey SEPARATOR = createTextAttributesKey("SIMPLE_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey KEY = createTextAttributesKey("SIMPLE_KEY", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey STRING = createTextAttributesKey("SIMPLE_VALUE", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey COMMENT = createTextAttributesKey("SIMPLE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey BAD_CHARACTER = createTextAttributesKey("SIMPLE_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);
    public static final TextAttributesKey NUMBER = createTextAttributesKey("SIMPLE_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey IDENTIFIER = createTextAttributesKey("SIMPLE_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER);
    public static final TextAttributesKey VARIABLE = createTextAttributesKey("SIMPLE_VARIABLE", DefaultLanguageHighlighterColors.IDENTIFIER);
    public static final TextAttributesKey OPERATOR = createTextAttributesKey("SIMPLE_OPERATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey SEMICOLON = createTextAttributesKey("SIMPLE_SEMICOLON", DefaultLanguageHighlighterColors.SEMICOLON);

    public static final Map<String, TextAttributesKey> ATTRIBUTE_MAP = new HashMap<>();

    static {
        for (Field field : SimpleSyntaxHighlighter.class.getDeclaredFields()) {
            try {
                if (TextAttributesKey.class.isAssignableFrom(field.getType())) {
                    ATTRIBUTE_MAP.put(field.getName(), (TextAttributesKey) field.get(null));
                }
            } catch (IllegalAccessException e) {
                // handle exception
            }
        }
    }

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new SimpleLexerAdapter();
    }

    private static final Map<IElementType, TextAttributesKey[]> TOKEN_TYPE_TO_KEY_MAP = Map.of(
            SimpleTypes.SEPARATOR, new TextAttributesKey[]{SEPARATOR},
            SimpleTypes.KEY, new TextAttributesKey[]{KEY},
            SimpleTypes.VALUE, new TextAttributesKey[]{STRING},
            SimpleTypes.COMMENT, new TextAttributesKey[]{COMMENT},
            TokenType.BAD_CHARACTER, new TextAttributesKey[]{BAD_CHARACTER},
            SimpleTypes.IDENTIFIER, new TextAttributesKey[]{IDENTIFIER},
            SimpleTypes.OPERATOR, new TextAttributesKey[]{OPERATOR},
            SimpleTypes.SEMICOLON, new TextAttributesKey[]{SEMICOLON},
            SimpleTypes.VARIABLE, new TextAttributesKey[]{VARIABLE},
            SimpleTypes.NUMBER, new TextAttributesKey[]{NUMBER}
    );

    @NotNull
    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        return TOKEN_TYPE_TO_KEY_MAP.getOrDefault(tokenType, new TextAttributesKey[0]);
    }
}

