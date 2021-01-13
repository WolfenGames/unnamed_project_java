Write-Host "Builidng"
mvn clean install
Write-Host "Done building\nExecuting"
java.exe -jar target/project_files-0.0.0-SNAPSHOT-jar-with-dependencies.jar