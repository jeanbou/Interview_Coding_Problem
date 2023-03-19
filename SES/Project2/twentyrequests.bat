@echo off
for /l %%x in (1, 1, 20) do (
   echo START CHARGING No. %%x
   curl.exe http://localhost:8000/api/v1.1/satellite/MP01
   echo  END OF CHARGING No. %%x 
)