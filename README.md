# WatchExample
Connecting watch and phone emulators step-by-step guide:

**Step #1**

Start the Phone Emulator and install the Android Wear Companion app via the following command

`adb install com.google.android.wearable.app-2.apk`

You can download the apk from here.

**Step #2**

Start the Wear-Emulator.

**Step #3**

Open the Android Wear App on the Phone Emulator. Accept the TOS and so on.

**Step #4**

Open your command prompt and make sure both emulators are recognized with the following command

`adb devices`

Output should be something like this:

``` 
List of devices attached
emulator-5554   device
emulator-5556   device
```

Find the phone emulator. You can find this by looking at the Window-Title of the emulator.

**Step 6**

Open your command prompt once again and start a telnet session on the port of your smartphone emulator:

`telnet localhost 5556`

Afterwards it'll try to connect and if it succeeds it'll show a new window saying something like this:

Android Console: type 'help' for a list of commands
OK

Now enter the following command:

`redir add tcp:5601:5601`

Afterwards it should say OK.

**Step 7**

Open the Android-Wear companion app once again and click on the watch-icon in the ActionBar 
and if everything worked it should connect to your Wear-Emulator.
