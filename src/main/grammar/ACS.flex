package by.home.acs.language.lexer;

import by.home.acs.language.ACSTypes;
import by.home.acs.language.psi.ACSTokenType;
import com.intellij.lexer.FlexLexer;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
%%

%{
  public ACSLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class ACSLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode
%eof{
return;
%eof}

CRLF = \R
IDENTIFIER= [a-zA-Z_][a-zA-Z0-9_]*
STRING= \"([^\\\"]|\\.)*\"
CHARACTER = (\')([^\\'\n]|(\\n) | (\\t) | (\\0) | (\\{2}) | (\\u[0-9]{4}))(\')
NUMBER = (0[xX][0-9a-fA-F]+)|(-?[0-9]+)
WHITE_SPACE=[ \t\n\x0B\f\r]+
END_LINE_COMMENT=("//")[^\r\n]*
MULTIPLE_LINE_COMMENT="/*"( [^*] | (\*+[^*/]) )*\*+\/
FLOAT = -?\d+(\.\d+)?
EQUALS_SYMBOL = "="
DOT_SYMBOL = "."
COMMA_SYMBOL = ","
OPEN_BRACE =  "{"
CLOSE_BRACE = "}"
OPEN_BRACKET = "("
CLOSE_BRACKET = ")"
OPEN_SQUARE_BRACKET = "["
CLOSE_SQUARE_BRACKET = "]"
SEMICOLON_SYMBOL = ";"
COLON_SYMBOL = ":"
%caseless
FUNCTION = "function"
SCRIPT = "script"
VOID = "void"
INT = "int"
STR = "str"
BOOL = "bool"
OPEN="OPEN"
ENTER="ENTER"
RETURN="RETURN"
RESPAWN="RESPAWN"
DEATH="DEATH"
LIGHTNING="LIGHTNING"
UNLOADING="UNLOADING"
DISCONNECT="DISCONNECT"
KILL="KILL"
REOPEN="REOPEN"
PICKUP="PICKUP"
REDRETURN="REDRETURN"
BLUERETURN="BLUERETURN"
WHITERETURN="WHITERETURN"
CLIENTSIDE="CLIENTSIDE"
NET="NET"

%states WAITING_VALUE, TEST_ONE_VALUE
%xstate TEST_VALUE
%%
  "#include"                                                {yybegin(YYINITIAL); return ACSTypes.INCLUDE;}
  "#import"                                                 {yybegin(YYINITIAL); return ACSTypes.IMPORT;}
  "#define"                                                 {yybegin(YYINITIAL); return ACSTypes.DEFINE;}
  "#library"                                                {yybegin(YYINITIAL); return ACSTypes.LIBRARY;}
  "global"                                                  {yybegin(YYINITIAL); return ACSTypes.GLOBAL;}
  "static"                                                  {yybegin(YYINITIAL); return ACSTypes.STATIC;}
  "world"                                                   {yybegin(YYINITIAL); return ACSTypes.WORLD;}
  "special"                                                 {yybegin(YYINITIAL); return ACSTypes.SPECIAL;}
  {OPEN_BRACKET}                                            {yybegin(YYINITIAL); return ACSTypes.LPAR;}
  {CLOSE_BRACKET}                                           {yybegin(YYINITIAL); return ACSTypes.RPAR;}
  {OPEN_BRACE}                                              {yybegin(YYINITIAL); return ACSTypes.LBRACE;}
  {CLOSE_BRACE}                                             {yybegin(YYINITIAL); return ACSTypes.RBRACE;}
  {VOID}                                                    {yybegin(YYINITIAL); return ACSTypes.VOID;}
  {BOOL}                                                    {yybegin(YYINITIAL); return ACSTypes.BOOL;}
  {INT}                                                     {yybegin(YYINITIAL); return ACSTypes.INT;}
  {STR}                                                     {yybegin(YYINITIAL); return ACSTypes.STR;}
  {FUNCTION}                                                {yybegin(YYINITIAL); return ACSTypes.FUNCTION;}
  {SCRIPT}                                                  {yybegin(YYINITIAL); return ACSTypes.SCRIPT;}
  ({CRLF}|{WHITE_SPACE})+                                   {yybegin(YYINITIAL); return TokenType.WHITE_SPACE;}
  "switch"                                                  {yybegin(YYINITIAL); return ACSTypes.SWITCH;}
  "case"                                                    {yybegin(YYINITIAL); return ACSTypes.CASE;}
  "for"                                                     {yybegin(YYINITIAL); return ACSTypes.FOR;}
  "while"                                                   {yybegin(YYINITIAL); return ACSTypes.WHILE;}
  "until"                                                   {yybegin(YYINITIAL); return ACSTypes.UNTIL;}
  "do"                                                      {yybegin(YYINITIAL); return ACSTypes.DO;}
  "break"                                                   {yybegin(YYINITIAL); return ACSTypes.BREAK;}
  "default"                                                 {yybegin(YYINITIAL); return ACSTypes.DEFAULT;}
  "if"                                                      {yybegin(YYINITIAL); return ACSTypes.IF;}
  "else"                                                    {yybegin(YYINITIAL); return ACSTypes.ELSE;}
  "return"                                                  {yybegin(YYINITIAL); return ACSTypes.RETURN;}
  "terminate"                                               {yybegin(YYINITIAL); return ACSTypes.TERMINATE;}
  "suspend"                                                 {yybegin(YYINITIAL); return ACSTypes.SUSPEND;}
  {NUMBER}                                                  {yybegin(YYINITIAL); return ACSTypes.NUMBER;}
  {STRING}                                                  {yybegin(YYINITIAL); return ACSTypes.STRING;}
  {END_LINE_COMMENT}                                        {yybegin(YYINITIAL); return ACSTypes.COMMENT;}
  {MULTIPLE_LINE_COMMENT}                                   {yybegin(YYINITIAL); return ACSTypes.COMMENT;}
  {CHARACTER}                                               {yybegin(YYINITIAL); return ACSTypes.CHARACTER;}
  {FLOAT}                                                   {yybegin(YYINITIAL); return ACSTypes.FLOAT;}
  {EQUALS_SYMBOL}                                           {yybegin(YYINITIAL); return ACSTypes.ASSIGN;}
  {COMMA_SYMBOL}                                            {yybegin(YYINITIAL); return ACSTypes.COMMA;}
  {OPEN}                                                    {yybegin(YYINITIAL); return ACSTypes.OPEN;}
  {ENTER}                                                   {yybegin(YYINITIAL); return ACSTypes.ENTER;}
  {RETURN}                                                  {yybegin(YYINITIAL); return ACSTypes.RETURN;}
  {RESPAWN}                                                 {yybegin(YYINITIAL); return ACSTypes.RESPAWN;}
  {DEATH}                                                   {yybegin(YYINITIAL); return ACSTypes.DEATH;}
  {LIGHTNING}                                               {yybegin(YYINITIAL); return ACSTypes.LIGHTNING;}
  {UNLOADING}                                               {yybegin(YYINITIAL); return ACSTypes.UNLOADING;}
  {DISCONNECT}                                              {yybegin(YYINITIAL); return ACSTypes.DISCONNECT;}
  {KILL}                                                    {yybegin(YYINITIAL); return ACSTypes.KILL;}
  {REOPEN}                                                  {yybegin(YYINITIAL); return ACSTypes.REOPEN;}
  {PICKUP}                                                  {yybegin(YYINITIAL); return ACSTypes.PICKUP;}
  {REDRETURN}                                               {yybegin(YYINITIAL); return ACSTypes.REDRETURN;}
  {WHITERETURN}                                             {yybegin(YYINITIAL); return ACSTypes.WHITERETURN;}
  {BLUERETURN}                                              {yybegin(YYINITIAL); return ACSTypes.BLUERETURN;}
  {CLIENTSIDE}                                              {yybegin(YYINITIAL); return ACSTypes.CLIENTSIDE;}
  {NET}                                                     {yybegin(YYINITIAL); return ACSTypes.NET;}
  {OPEN_SQUARE_BRACKET}                                     {yybegin(YYINITIAL); return ACSTypes.LBRACKET;}
  {CLOSE_SQUARE_BRACKET}                                    {yybegin(YYINITIAL); return ACSTypes.RBRACKET;}
  {SEMICOLON_SYMBOL}                                        {yybegin(YYINITIAL); return ACSTypes.SEMICOLON;}
  {COLON_SYMBOL}                                            {yybegin(YYINITIAL); return ACSTypes.COLON;}
  "*="                                                      {yybegin(YYINITIAL); return ACSTypes.MUL_ASSIGN; }
  "/="                                                      {yybegin(YYINITIAL); return ACSTypes.DIV_ASSIGN; }
  "%="                                                      {yybegin(YYINITIAL); return ACSTypes.DIV_MOD_ASSIGN; }
  "+="                                                      {yybegin(YYINITIAL); return ACSTypes.P_ASSIGN; }
  "-="                                                      {yybegin(YYINITIAL); return ACSTypes.M_ASSIGN; }
  "<<="                                                     {yybegin(YYINITIAL); return ACSTypes.LB_SHIFT_ASSIGN; }
  ">>="                                                     {yybegin(YYINITIAL); return ACSTypes.RB_SHIFT_ASSIGN; }
  "&="                                                      {yybegin(YYINITIAL); return ACSTypes.BIT_AND_ASSIGN; }
  "^="                                                      {yybegin(YYINITIAL); return ACSTypes.BIT_XOR_ASSIGN; }
  "|="                                                      {yybegin(YYINITIAL); return ACSTypes.BIT_OR_ASSIGN; }
  ">="                                                      {yybegin(YYINITIAL); return ACSTypes.MEQ; }
  "<="                                                      {yybegin(YYINITIAL); return ACSTypes.LEQ; }
  ">"                                                       {yybegin(YYINITIAL); return ACSTypes.MT; }
  "<"                                                       {yybegin(YYINITIAL); return ACSTypes.LT; }
  "=="                                                      {yybegin(YYINITIAL); return ACSTypes.EQ; }
  "!="                                                      {yybegin(YYINITIAL); return ACSTypes.NEQ; }
  "++"                                                      {yybegin(YYINITIAL); return ACSTypes.INC; }
  "--"                                                      {yybegin(YYINITIAL); return ACSTypes.DEC; }
  "+"                                                       {yybegin(YYINITIAL); return ACSTypes.PLUS; }
  "-"                                                       {yybegin(YYINITIAL); return ACSTypes.MINUS; }
  "/"                                                       {yybegin(YYINITIAL); return ACSTypes.DIVIDE; }
  "%"                                                       {yybegin(YYINITIAL); return ACSTypes.MODULOUS; }
  "*"                                                       {yybegin(YYINITIAL); return ACSTypes.MUL; }
  "&&"                                                      {yybegin(YYINITIAL); return ACSTypes.BIT_AND; }
  "||"                                                      {yybegin(YYINITIAL); return ACSTypes.BIT_OR; }
  "!"                                                       {yybegin(YYINITIAL); return ACSTypes.BIT_NOT; }
  "<<"                                                      {yybegin(YYINITIAL); return ACSTypes.L_SHIFT; }
  ">>"                                                      {yybegin(YYINITIAL); return ACSTypes.R_SHIFT; }
  "&"                                                       {yybegin(YYINITIAL); return ACSTypes.UN_AND; }
  "|"                                                       {yybegin(YYINITIAL); return ACSTypes.UN_OR; }
  "^"                                                       {yybegin(YYINITIAL); return ACSTypes.UN_XOR; }
  "~"                                                       {yybegin(YYINITIAL); return ACSTypes.UN_NOT; }
  {IDENTIFIER}                                              {yybegin(YYINITIAL); return ACSTypes.IDENTIFIER; }
// If the character sequence does not match any of the above rules, we return BAD_CHARACTER which indicates that
// there is an error in the character sequence. This is used to highlight errors.
[^] { return TokenType.BAD_CHARACTER; }
