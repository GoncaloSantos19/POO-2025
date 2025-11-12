# PowerShell: compila e executa MenuAlunos
Set-Location -Path $PSScriptRoot
if (-not (Test-Path out)) { New-Item -ItemType Directory -Path out | Out-Null }
Get-ChildItem -Recurse src -Filter *.java | ForEach-Object { & javac -d out $_.FullName }
if ($LASTEXITCODE -ne 0) { Write-Host "Erro de compilacao. Verifique as mensagens acima."; exit 1 }
Write-Host "Compilacao OK.`nExecutando..."
java -cp out pt.escnaval.exercicios.MenuAlunos
Read-Host -Prompt "Pressione ENTER para fechar"
