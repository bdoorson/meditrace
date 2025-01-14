@echo off

REM Pull the latest changes from Git
echo Checking for updates from Git...
git pull > git_pull_output.txt

REM Check if Git pull resulted in any changes
findstr "Already up to date." git_pull_output.txt >nul
if %errorlevel% equ 0 (
    echo Git is up-to-date.
    REM Check if the target JAR file exists
    if exist target\meditrace-1.0-SNAPSHOT.jar (
        echo JAR file already exists. Skipping Maven build.
    ) else (
        echo JAR file not found. Executing Maven build...
        mvn clean package -Pproduction
    )
) else (
    echo Changes pulled from Git. Executing Maven build...
    mvn clean package -Pproduction
)

REM Cleanup
del git_pull_output.txt

REM Execute the JAR file
java -jar target\meditrace-1.0-SNAPSHOT.jar


