@echo off
REM Compila todos os .java em lab06 e executa MenuBanco
cd /d "%~dp0"
if not exist out mkdir out

echo Compilando classes...
javac -encoding UTF-8 -d out src\main\java\pt\escnaval\exercicios\exceptions\*.java src\main\java\pt\escnaval\exercicios\modelo\*.java src\main\java\pt\escnaval\exercicios\servicos\*.java src\main\java\pt\escnaval\exercicios\utils\*.java src\main\java\pt\escnaval\exercicios\*.java

if errorlevel 1 (
  echo Erro de compilacao. Verifique mensagens acima.
  pause
  exit /b 1
)

echo Compilacao OK.
echo.
echo Executando MenuBanco...
echo.
chcp 65001 >nul
java -cp out pt.escnaval.exercicios.MenuBanco
pause
