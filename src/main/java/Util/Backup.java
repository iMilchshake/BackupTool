package Util;

import Configuration.Job;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.apache.commons.io.FileUtils.copyDirectory;

public class Backup {
    public static void backup(Job job) throws Exception {

        // test input
        File sourcePath = new File(job.getSource());
        File targetPath = new File(job.getTarget());

        if (!sourcePath.isAbsolute() || !targetPath.isAbsolute())
            throw new IOException(String.format("The given paths need to be absolute! (job=%s)", job.getName()));

        if (!sourcePath.exists() || !targetPath.exists())
            throw new IOException("The given path doesn't exist!");

        if (!sourcePath.isDirectory() || !targetPath.isAbsolute())
            throw new IOException(String.format("The given paths need to point to a directory (job=%s)", job.getName()));

        String date = new SimpleDateFormat("yyyy_MM_dd__HH_mm").format(new Date());
        File targetPathSubDate = new File(targetPath.getAbsolutePath() + File.separator + date);

        boolean success = targetPathSubDate.mkdir();
        if (!success)
            throw new Exception(String.format("subdir '%s' could not be created!", date));

        System.out.printf("[%s] - Copying Files from '%s' to '%s' \n", job.getName(), sourcePath, targetPathSubDate);
        copyDirectory(sourcePath, targetPathSubDate);
        System.out.printf("[%s] - Job finished. \n", job.getName());
    }
}