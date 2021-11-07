# BackupTool

A minimalistic CLI backup tool made with Java.

## Installation

### 1) Download the newest [Release](https://github.com/iMilchshake/BackupTool/releases/tag/v0.2a)

### 2) Build it yourself

Clone the GitHub Repository

````bash
git clone https://github.com/iMilchshake/BackupTool.git
````

Build the Project using 

````bash
mvn package 
````


## Usage

```bash
java -jar BackupTool-0.2a.jar <command> <arg1> <arg2> ..
```

## Commands
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

## Example

As an example, a job `BackupImages` is set up to backup images from the path `G:\Images` to `D:\Backup\Images`. Afterwards, this job can be run over and over again.

````
java -jar BackupTool-0.2a.jar addjob BackupImages G:\Images\ D:\Backup\Images
java -jar BackupTool-0.2a.jar joblist
>> [0] - name='BackupImages', source='G:\Images\', target='D:\Backup\Images\'
java -jar BackupTool-0.2a.jar run BackupImages
>> [BackupImages] - Copying Files from 'G:\Images\' to 'D:\Backup\Images\2021_10_12__23_55'
>> [BackupImages] - Job finished.
````
