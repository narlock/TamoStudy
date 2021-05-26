PROBLEMS-README

Depending on how Java and your computer work together, you may experience a common issue when trying to launch TamoStudy.

Essentially, you will see a TamoStudy window that is blank, with no options or anything - just a blank screen.

Luckily, there is a FIX for this!

###################

Windows Tutorial - credit: narlock
GOAL: Create a .bat command file that will launch TamoStudy through Command Prompt

1. Find and Copy the path where your TamoStudy.jar, assets folder, and profiles folder are. (The folder you found this in should also be the same path!)
2. Right-click on "example-fix-windows.bat" and open with text editor
3. Replace the path in the first line with the path that you copied.

From here, you can now open the .bat command and TamoStudy should work perfectly. You will have to use the bat file in order to make this work - use it instead of the .jar file itself.

You can rename the bat file to whatever you want, if you want to make it easier, rename it to "Open TamoStudy"

###################

macOS - credit: oodsofnoodles
NOTE: Once a better solution is available, it will be shown here.

How to run TamoStudy through terminal on MacOS:
1. Make sure you have Java and the latest version of TamoStudy downloaded.
2. Open Terminal (you can find it if you do a Spotlight Search using command + space bar)
3. Find where the folder where TamoStudy is. Right click (or click with 2 fingers since you’re on a Mac) and then hold the Option key. Hit Copy “TamoStudy [version number]” as path name. For Mac, it may look something like /Users/name/Desktop/TamoStudy a0.5.0
4. Go back to Terminal and type in the following
cd [the path name you just copied]
If there is a space, put a \ before the space. For example,
/Users/name/Desktop/TamoStudy\ a0.5.0
5. On the next line, type the following
java -jar TamoStudy.jar
6. Voila! TamoStudy should work on your Mac. Just make sure to not close Terminal until you want to close the app. I can’t figure out how to run a .sh file through Terminal but this method still works. You will have to repeat this every time you wanna run TamoStudy. It’s not perfect but I hope this helps!! :))

###################

If you experience any problems with TamoStudy with these directions, please join our community Discord server. It is the easiest place to reach us and fix these issues!
- tinyurl.com/TamoDiscord