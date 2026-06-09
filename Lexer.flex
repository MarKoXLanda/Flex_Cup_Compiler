package codigo;
import java_cup.runtime.Symbol;

%%
%class Lexer
%public
%type java_cup.runtime.Symbol
%cup
%full
%line
%char
%column

L=[a-zA-Z_]+
D=[0-9]+
espacio=[ \t\r\n]+

%{
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
%}

%%

/* --- 1. COMENTARIOS (Ignorados) --- */
("//".*) { /* Ignorar comentario linea */ }
("/*" [^/] ~"*/" | "/*" "/"+ "*/") { /* Ignorar bloque */ }

/* --- 2. OPERADORES DOBLES (Prioridad Alta) --- */
"==" { return new Symbol(sym.IgualIgual, yyline, yycolumn, yytext()); }
"!=" { return new Symbol(sym.Diferente, yyline, yycolumn, yytext()); }
"++" { return new Symbol(sym.Incremento, yyline, yycolumn, yytext()); }
"--" { return new Symbol(sym.Decremento, yyline, yycolumn, yytext()); }
"**" { return new Symbol(sym.Potencia, yyline, yycolumn, yytext()); }
"<=" { return new Symbol(sym.MenorIgual, yyline, yycolumn, yytext()); }
">=" { return new Symbol(sym.MayorIgual, yyline, yycolumn, yytext()); }

/* --- 3. TIPOS DE DATOS Y PALABRAS CLAVE --- */
"int"     { return new Symbol(sym.Int, yyline, yycolumn, yytext()); }
"double"  { return new Symbol(sym.Double, yyline, yycolumn, yytext()); }
"string"  { return new Symbol(sym.Cadena, yyline, yycolumn, yytext()); }
"boolean" { return new Symbol(sym.Boolean, yyline, yycolumn, yytext()); }
"if"      { return new Symbol(sym.If, yyline, yycolumn, yytext()); }
"else"    { return new Symbol(sym.Else, yyline, yycolumn, yytext()); }
"while"   { return new Symbol(sym.While, yyline, yycolumn, yytext()); }
"for"     { return new Symbol(sym.For, yyline, yycolumn, yytext()); }
"main"    { return new Symbol(sym.Main, yyline, yycolumn, yytext()); }
"return"  { return new Symbol(sym.Return, yyline, yycolumn, yytext()); }

/* --- 4. FUNCIONES MATEMÁTICAS --- */
"sqrt"      { return new Symbol(sym.Sqrt, yyline, yycolumn, yytext()); }
"sin"       { return new Symbol(sym.Sin, yyline, yycolumn, yytext()); }
"cos"       { return new Symbol(sym.Cos, yyline, yycolumn, yytext()); }
"tan"       { return new Symbol(sym.Tan, yyline, yycolumn, yytext()); }
"factorial" { return new Symbol(sym.Factorial, yyline, yycolumn, yytext()); }
"fibonacci" { return new Symbol(sym.Fibonacci, yyline, yycolumn, yytext()); }
"formula_general" { return new Symbol(sym.FormulaGeneral, yyline, yycolumn, yytext()); }

/* --- 5. VALORES BOOLEANOS --- */
"true"    { return new Symbol(sym.True, yyline, yycolumn, yytext()); }
"false"   { return new Symbol(sym.False, yyline, yycolumn, yytext()); }

/* --- 6. OPERADORES Y SIGNOS --- */
"(" { return new Symbol(sym.ParParentesis_a, yyline, yycolumn, yytext()); }
")" { return new Symbol(sym.ParParentesis_c, yyline, yycolumn, yytext()); }
"{" { return new Symbol(sym.Llave_a, yyline, yycolumn, yytext()); }
"}" { return new Symbol(sym.Llave_c, yyline, yycolumn, yytext()); }
";" { return new Symbol(sym.P_coma, yyline, yycolumn, yytext()); }
"," { return new Symbol(sym.Coma, yyline, yycolumn, yytext()); }
"=" { return new Symbol(sym.Igual, yyline, yycolumn, yytext()); }
"+" { return new Symbol(sym.Suma, yyline, yycolumn, yytext()); }
"-" { return new Symbol(sym.Resta, yyline, yycolumn, yytext()); }
"*" { return new Symbol(sym.Multiplicacion, yyline, yycolumn, yytext()); }
"/" { return new Symbol(sym.Division, yyline, yycolumn, yytext()); }
"<" { return new Symbol(sym.Menor, yyline, yycolumn, yytext()); }
">" { return new Symbol(sym.Mayor, yyline, yycolumn, yytext()); }

/* --- 7. IDENTIFICADORES, NUMEROS Y TEXTO --- */
{L}({L}|{D})* { return new Symbol(sym.Identificador, yyline, yycolumn, yytext()); }
("(-"{D}+")")|{D}+ { return new Symbol(sym.Numero, yyline, yycolumn, yytext()); }
("(-"{D}+"."{D}+")")|({D}+"."{D}+) { return new Symbol(sym.NumeroDecimal, yyline, yycolumn, yytext()); }
(\"[^\"]*\") { return new Symbol(sym.CadenaLiteral, yyline, yycolumn, yytext().substring(1, yytext().length()-1)); }

/* --- 8. ERRORES --- */
{espacio} {/*Ignore*/}
. { return new Symbol(sym.ERROR, yyline, yycolumn, yytext()); }