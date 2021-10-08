package Util;

public class Constants {

    private Constants() {
    }

    public static final String HELP_TEXT = "BackupTool v0.1a\n" +
            "\n" +
            "Commands:\n" +
            "\n" +
            "- joblist\n" +
            "    - prints a list of existing jobs\n" +
            "\n" +
            "- addjob [jobname] [source_path] [target_path]\n" +
            "    - creates a new job\n" +
            "\n" +
            "- removejob [jobname]\n" +
            "    - removes an existing job\n" +
            "\n" +
            "- run [jobname]\n" +
            "    - runs an existing job, copies entire content of source-directory into target-directory\n" +
            "\n" +
            "- help\n" +
            "    - shows this message";
}
