# PowerShell: compila e executa as demos
Set-Location -Path $PSScriptRoot
if (-not (Test-Path out)) { New-Item -ItemType Directory -Path out | Out-Null }
Get-ChildItem -Recurse src -Filter *.java | ForEach-Object { & javac -d out $_.FullName }
if ($LASTEXITCODE -ne 0) { Write-Host "Erro de compilacao. Verifique as mensagens acima."; exit 1 }
Write-Host "Compilacao OK.`n"

Write-Host "=== Executando MainDemo ==="
java -cp out pt.escnaval.exercicios.MainDemo
Write-Host "`n=== Executando DemoIdentidade ==="
java -cp out pt.escnaval.exercicios.DemoIdentidade
Write-Host "`n=== Executando DemoArmadilhas ==="
java -cp out pt.escnaval.exercicios.DemoArmadilhas
Write-Host "`n=== Executando DemoHerancaInterface ==="
java -cp out pt.escnaval.exercicios.DemoHerancaInterface

Read-Host -Prompt "`nPressione ENTER para fechar"
