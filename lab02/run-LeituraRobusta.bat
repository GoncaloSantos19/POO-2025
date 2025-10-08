@echo off
REM Compila e executa LeituraRobusta.java com o package correto
cd /d "%~dp0..\..\..\.."
cd src\main\java
javac pt\escnaval\exercicios\LeituraRobusta.java
if %errorlevel% neq 0 (
  echo Erro na compilação.
  pause
  exit /b %errorlevel%
)
java pt.escnaval.exercicios.LeituraRobusta
pause
