@echo off
REM Compila todos os .java em lab05 e executa as demos
cd /d "%~dp0"
if not exist out mkdir out
javac -d out src\main\java\pt\escnaval\exercicios\*.java
if errorlevel 1 (
  echo Erro de compilacao. Verifique mensagens acima.
  pause
  exit /b 1
)
echo Compilacao OK.
echo.
echo === Executando MainDemo ===
java -cp out pt.escnaval.exercicios.MainDemo
echo.
echo === Executando DemoIdentidade ===
java -cp out pt.escnaval.exercicios.DemoIdentidade
echo.
echo === Executando DemoArmadilhas ===
java -cp out pt.escnaval.exercicios.DemoArmadilhas
echo.
echo === Executando DemoHerancaInterface ===
java -cp out pt.escnaval.exercicios.DemoHerancaInterface
pause
