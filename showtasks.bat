call runcrud.bat
if "%ERRORLEVEL%" == "0" goto start
echo There were errors

:start
start "chrome.exe" http://localhost:8080/crud/v1/task/getTasks