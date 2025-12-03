# PowerShell: compila e executa MenuBanco
Set-Location -Path $PSScriptRoot
if (-not (Test-Path out)) { New-Item -ItemType Directory -Path out | Out-Null }

Write-Host "Compilando classes..."
Get-ChildItem -Recurse src -Filter *.java | ForEach-Object { & javac -encoding UTF-8 -d out $_.FullName }

if ($LASTEXITCODE -ne 0) { 
    Write-Host "Erro de compilacao. Verifique as mensagens acima."; 
    Read-Host -Prompt "Pressione ENTER para sair"
    exit 1 
}

Write-Host "Compilacao OK.`n"
Write-Host "Executando MenuBanco...`n"
[Console]::OutputEncoding = [System.Text.Encoding]::UTF8
java -cp out pt.escnaval.exercicios.MenuBanco
Read-Host -Prompt "`nPressione ENTER para fechar"
