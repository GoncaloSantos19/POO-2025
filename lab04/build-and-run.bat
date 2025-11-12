@echo off
REM Compila todos os .java em lab04 e executa MenuAlunos
cd /d "%~dp0"
if not exist out mkdir out
javac -d out src\main\java\pt\escnaval\exercicios\*.java
if errorlevel 1 (
  echo Erro de compilacao. Verifique mensagens acima.
  pause
  exit /b 1
)
echo Compilacao OK.
java -cp out pt.escnaval.exercicios.MenuAlunos
pause
