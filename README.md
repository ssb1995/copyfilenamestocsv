# CopyFileNamesToCsv

Spring app to copy the filenames into a csv file

Command line VM args to run the app below. Replace the argument with the folder name the filenames copy should be started. The app will recursively read all the valid filenames in the given parent directory.

Default output file will be in C:\data\Filenames.csv

parent.folder.path="C:\"

To run the app from command line,

java -jar copyfilenamestoexcel.jar -Dparent.folder.path="C:\"