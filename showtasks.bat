call runcrud.bat
if "%ERRORLEVEL%" == "0" goto openbrowser
echo.
echo runcrud script has failed - breaking work
goto fail

:openbrowser
start "" "C:\Program Files (x86)\Google\Chrome\Application\chrome.exe"
if "%ERRORLEVEL%" == "0" goto openwebsite
echo.
echo the browser doesn't run
goto fail

:openwebsite
start "" http://localhost:8080/crud/v1/task/getTasks
if "%ERRORLEVEL%" == "0" goto end
echo.
echo the website cannot be opened
goto fail


:fail
echo.
echo There were some errors.

:end
echo.
echo The work is finished.