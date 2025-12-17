# PowerShell: compila e executa MenuMediateca
Set-Location -Path $PSScriptRoot
if (-not (Test-Path out)) { New-Item -ItemType Directory -Path out | Out-Null }
if (-not (Test-Path data)) { New-Item -ItemType Directory -Path data | Out-Null }
if (-not (Test-Path media)) { New-Item -ItemType Directory -Path media | Out-Null }

Write-Host "Compilando classes..."
Get-ChildItem -Recurse src -Filter *.java | ForEach-Object { & javac -encoding UTF-8 -d out $_.FullName }

if ($LASTEXITCODE -ne 0) { 
    Write-Host "Erro de compilacao. Verifique as mensagens acima."; 
    Read-Host -Prompt "Pressione ENTER para sair"
    exit 1 
}

Write-Host "Compilacao OK.`n"
Write-Host "Executando MenuMediateca...`n"
[Console]::OutputEncoding = [System.Text.Encoding]::UTF8
java -cp out pt.escnaval.exercicios.mediateca.MenuMediateca
Read-Host -Prompt "`nPressione ENTER para fechar"
