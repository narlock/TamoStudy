<!-- Author: @narlock -->

<!-- Main Header -->
<p align="center">
  <img src="./README%20Assets/TamoStudyCard.gif" width="40%"/>
</p>

<p align="center">
by <a href="https://github.com/narlock">narlock</a>
</p>

<!-- GitHub Shields-->
<p align="center">
  <a href="https://github.com/narlock/TamoStudy/releases/"><img src="https://img.shields.io/github/downloads/narlock/TamoStudy/total.svg"></a>
  <a href="https://github.com/narlock/TamoStudy/releases/"><img src="https://img.shields.io/github/v/release/narlock/TamoStudy"></a>
  <a href="https://github.com/narlock/TamoStudy/commits/main"><img src="https://img.shields.io/github/last-commit/narlock/TamoStudy"></a>
  <a href="https://discord.gg/eEbEYbXaNS"><img src="https://discordapp.com/api/guilds/821757961830793236/widget.png?style=shield"></a>
</p>

<!-- Social Links -->
<p align="center">
  <a href="https://youtube.com/narlock" style="padding:10px;"><img src="https://i.imgur.com/5npSWBq.png" alt="YouTube"></a>
  <a href="https://instagram.com/narlockdev" style="padding:10px;"><img src="https://i.imgur.com/DCFiEHr.png" alt="Instagram"></a>
  <a href="https://patreon.com/narlock" style="padding:10px;"><img src="https://i.imgur.com/iXAguWQ.png" alt="Patreon"></a>
  <a href="https://twitter.com/narlockDev" style="padding:10px;"><img src="https://i.imgur.com/W8iSkd5.png"></a>
<p>

<hr>

**TamoStudy** - A work and study productivity timer that implements a fun, virtual pet to help you stay driven to focus!

- [Website](http://tamostudy.com/)
- [Features](#features)
- [Setup TamoStudy](#setup-tamostudy)
- [Original Concept Idea](#original-concept-idea)
- [Contributors](#contributors)

## **Features**

### **Focus Timer**

A simple, customizable countdown timer for deep focus work.

![Focus Timer](./README%20Assets/FocusTime.png)
- *Custom Interval Countdown*: Customize the number of minutes and the number of a seconds in a single focus session.
- *5-Interval Countdown*: Easily choose a focus time from a selection of factors of 5 minutes.
- *Pomodoro*: The popular *[pomodoro technique](https://en.wikipedia.org/wiki/Pomodoro_Technique)* that breaks work into intervals. For a number of sessions, focus for a specified amount of time, then take a break for a specified amount of time.

Upon completing focus sessions, you will receive Tamo Tokens! With Tamo Tokens, you can purchase food for your virtual pet and additional customization! To keep your Tamo happy, you must complete your desired focus sessions!

### **Shop**

A shop for purchasing food to feed the user's virtual pet. Additionally, the user can purchase cosmetic customization items!

<p align="center">
  <img src="./README%20Assets/Shop.png" width="70%"/>
</p>
- Beside the Tamo Token lies the price of the specified item. Adjacent to the price for food is the amount of food points the selected food item will give the virtual pet.
- Purchasing a food item will automatically satisfy the hunger of the user's virtual pet.
- Purchasing a background will add the background to the user's inventory.

### **Themes**

Customize the look of the TamoStudy interface through the use of colored themes!

<p align="center">
  <img src="./README%20Assets/Themes.png" width="70%"/>
</p>

- Select one of the themes by pressing the "Select" button next to the theme.

### **Inventory**

The user's inventory allows for items to be stored and used when the user desires. As of TamoStudy Beta v4.2, the inventory supports backgrounds. The user can utilize the "Select" button next to the background of their choice to apply the background to their Tamo!

<p align="center">
  <img src="./README%20Assets/Inventory.png" width="70%"/>
</p>

### **Statistics**

- View your statistics while using TamoStudy!

<p align="center">
  <img src="./README%20Assets/Statistics.png" width="70%"/>
</p>

### **Achievements**

- Unlock achievements during your use of TamoStudy!

<p align="center">
  <img src="./README%20Assets/Achievements.png" width="70%"/>
</p>

### **Settings**

- Change the settings of TamoStudy to match your preferences!

<p align="center">
  <img src="./README%20Assets/Settings.png" width="70%"/>
</p>

### Discord Rich Presence
This implementation utilizes the [DiscordRPC JAR](https://github.com/Vatuu/discord-rpc). As of Beta v4.2, Discord Rich Presence is only supported on Windows devices.

- Each Idle screen has its own presence. An example is below:

<p align="center">
  <img src="https://i.imgur.com/tNxSE5K.png" width="20%"/>
</p>

- During Focus sessions, the time and a display that the user is focusing is displayed:

<p align="center">
  <img src="https://i.imgur.com/3JZmbyw.png" width="20%"/>
</p>

- During Pomodoro Breaks, a break display is shown:

<p align="center">
  <img src="https://i.imgur.com/2CkQ7na.png" width="20%"/>
</p>


## **Setup TamoStudy**

### Requirements

1. Supported Operating Systems

      TamoStudy has been tested on the following operating systems:
      - Windows XP, 10, 11
      - Linux (Ubuntu 20.04 LTS)
      - macOS (Monterary, Ventura)

2. Java Runtime Environment

    TamoStudy was developed utilizing the Java programming language. An installation of the Java Runtime Environment is required to run Java applications. TamoStudy runs on Java 8. A download for Java can be found [here](https://www.java.com/en/download/).

3. Downloading TamoStudy

    To download TamoStudy, read through the download page [here](https://github.com/narlock/TamoStudy/releases) and select the TamoStudy JAR file to download from this page. This file contains the entire application and can be opened utilizing the Java Runtime Environment.

    > **Note**
    > Depending on your operating system, there may be certain permissions you must authorize TamoStudy to in order to execute the program.
    - For Linux distributions, permissions to execute the application must be granted.
    - For macOS, depending on the installation, the user may need to launch the application through the command line (assuming the application already has permissions). To run through the command line, navigate the terminal to the directory of TamoStudy, then type the command `java -jar TamoStudy.jar`. The application will now function properly.

- Installation Tutorial
<p align="center">
  <a href="https://www.youtube.com/watch?v=8JeMkaXIQOY"><img src="https://i.imgur.com/nVWKkXF.jpg" width="50%"></a>
</p>

## Original Concept Idea

I wanted a way to record the amount of time I spent focused every day. At the time, I was cleaning through my room and found my Tamagotchi that I used to play with when I was very young. I thought that implementing a Tamagotchi-like pet into a focus timer would be a good idea. The more I focus and get my work done, the more upgrades and new things I can do with the virtual pet (in my project, it's called a Tamo).

Project plans to include a GUI in which a user can create a username and password along with give a name for their Tamo. The user can re-load this information so they can load where they left off in their studies. (Keeping the total amount of time they have focused, and their previous Tamo alive)

The Focus GUI will have a set timer (minutes and seconds) the user can choose. When the user begins the Focus session, the timer will count down (this is the time where the user will work). After the timer is up, the session will be completed, and the Tamo will gain experience and happiness, and the user will gain money.

## Contributors
- [Shorent](http://github.com/Shorent) - 2 Commits (Web)
- [Alyksett](http://github.com/Alyksett) - 1 Commit (Main)

<hr>
<p align="center">
TamoStudy was created on January 30th, 2021 • Developed by <a href="https://github.com/narlock">narlock</a><br>
<i>TamoStudy software applications reached over 1,000 total downloads on August 29th, 2022</i> <br>
&copy; 2021-2023 TamoStudy, <a href="http://tamostudy.com">tamostudy.com</a>
</p>
