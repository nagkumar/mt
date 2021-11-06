@echo off
for /D /r %%G in (*bin) do @rmdir /s /q %%G
for /d /r %%i in (*obj) do @rmdir /s /q %%i
for /d /r %%i in (*StrykerOutput) do @rmdir /s /q %%i
set PATH=%PATH%;%~dp0;%~dp0fix\test;%~dp0kata\test;