@echo off
REM push-projeto.bat
REM Script to push the 'projeto' folder to a GitHub repo (HTTPS).

:: Move to projeto folder
cd /d "%~dp0projeto"

necho This script will push the 'projeto' folder to a GitHub repository.
echo You must have Git installed and be able to authenticate to GitHub (PAT or credentials).

nset /p REPOURL=Enter the GitHub repo HTTPS URL (e.g. https://github.com/GoncaloSantos19/POO-2025.git): 
if "%REPOURL%"=="" (
  echo No URL provided. Exiting.
  pause
  exit /b 1
)

nwhere git >nul 2>&1
if errorlevel 1 (
  echo Git not found on PATH. Install Git and retry.
  pause
  exit /b 1
)

nif not exist .git (
  echo Initializing git repository...
  git init
  echo target/>>.gitignore
  echo *.class>>.gitignore
  echo *.log>>.gitignore
  echo .idea/>>.gitignore
  echo .vscode/>>.gitignore
  echo projeto/output.txt>>.gitignore
  git add .
  git commit -m "Initial commit: projeto"
) else (
  echo Existing git repository detected in projeto/. Skipping init.
)

nREM (re)configure remote origin to the provided URL
git remote remove origin 2>nul
git remote add origin %REPOURL%
git branch -M main
echo Pushing to %REPOURL% ...
git push -u origin main

necho Done. Press any key to close.
pause
