# BackupTool

Ein minimalistisches CLI BackupTool in Java.

## Installation

GitHub Repository klonen

````bash
git clone https://github.com/iMilchshake/BackupTool.git
````

Mit Maven das Projekt bauen

````bash
mvn package 
````


## Verwendung

```bash
java -jar BackupTool-0.2a.jar <command> <arg1> <arg2> ..
```

## Befehle
````
- joblist
    - prints a list of existing jobs

- addjob [jobname] [source_path] [target_path]
    - creates a new job

- removejob [jobname]
    - removes an existing job

- run [jobname]
    - runs an existing job, copies entire content of source-directory into target-directory

- help
    - shows this message
````

## Beispiel

Als Beispiel wird ein Job `BackupImages` eingerichtet um Bilder aus dem Pfad `G:\Images` nach `D:\Backup\Images` zu sichern. Anschließend lässt sich dieser Job immer wieder ausführen.
````
java -jar BackupTool-0.2a.jar addjob BackupImages G:\Images\ D:\Backup\Images
java -jar BackupTool-0.2a.jar joblist
>> [0] - name='BackupImages', source='G:\Images\', target='D:\Backup\Images\'
java -jar BackupTool-0.2a.jar run BackupImages
>> [BackupImages] - Copying Files from 'G:\Images\' to 'D:\Backup\Images\2021_10_12__23_55'
>> [BackupImages] - Job finished.
````