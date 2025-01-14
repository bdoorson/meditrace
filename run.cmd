@echo off

REM Perform git pull and check if there are any changes
echo Pulling latest changes from Git...
git pull > gitpull.log
findstr /c:"Already up to date." gitpull.log >nul
if %ERRORLEVEL% equ 0 (
    echo No changes pulled from Git.
    REM Check if the JAR file exists
    if exist target\meditrace-1.0-SNAPSHOT.jar (
        echo JAR file exists. Skipping Maven package step.
    ) else (
        echo JAR file does not exist. Building project...
    )
) else (
    echo Changes pulled from Git. Building project...
)
goto RUN_APP

REM Run Maven package command
mvn clean package -Pproduction

:RUN_APP
REM Run the JAR file
java -jar target\meditrace-1.0-SNAPSHOT.jar

REM Clean up the temporary git pull log
del gitpull.log
