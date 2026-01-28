$scriptPath = Join-Path $PSScriptRoot 'run-GUI.bat'
if (-not (Test-Path $scriptPath)) {
    Write-Error "run-GUI.bat not found in $PSScriptRoot. Run this script from the repository root where run-GUI.bat exists."
    exit 1
}
$desktop = [Environment]::GetFolderPath('Desktop')
$w = New-Object -ComObject WScript.Shell
$lnk = $w.CreateShortcut((Join-Path $desktop 'POO_2025 - Run GUI.lnk'))
$lnk.TargetPath = $scriptPath
$lnk.WorkingDirectory = Split-Path $scriptPath
$lnk.WindowStyle = 1
$lnk.Save()
Write-Output "Shortcut created on Desktop: POO_2025 - Run GUI.lnk" 
