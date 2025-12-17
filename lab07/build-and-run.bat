@echo off
REM Compila todos os .java em lab07 e executa MenuMediateca
cd /d "%~dp0"
if not exist out mkdir out
if not exist data mkdir data
if not exist media mkdir media

echo Compilando classes...
javac -encoding UTF-8 -d out src\main\java\pt\escnaval\exercicios\mediateca\modelo\*.java src\main\java\pt\escnaval\exercicios\mediateca\servicos\*.java src\main\java\pt\escnaval\exercicios\mediateca\utils\*.java src\main\java\pt\escnaval\exercicios\mediateca\*.java

if errorlevel 1 (
  echo Erro de compilacao. Verifique mensagens acima.
  pause
  exit /b 1
)

echo Compilacao OK.
echo.
echo Executando MenuMediateca...
echo.
chcp 65001 >nul
java -cp out pt.escnaval.exercicios.mediateca.MenuMediateca
pause
