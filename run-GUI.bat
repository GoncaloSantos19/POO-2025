@echo off
REM Lightweight launcher for the JavaFX GUI of the POO_2025 project.
REM Usage: double-click this file in Windows Explorer.

REM Change to projeto folder (script directory -> projeto)
cd /d "%~dp0projeto"

:: Check if mvn is available
where mvn >nul 2>&1
if errorlevel 1 (
    echo Maven (mvn) not found on PATH. Please install Maven or run the application from an environment where 'mvn' is available.
    pause
    exit /b 1
)

necho Starting JavaFX application (this will build if needed)...
mvn javafx:run -Djavafx.platform=win

necho Application exited. Press any key to close.
pause
