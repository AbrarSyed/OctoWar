This is a sample deployment of a simple libGDX application. It works.
All of the JARs are from the libGDX nightly zip, except the main app one.
To switch it out with your app, just edit the index.html file, and change
"desktop-1.0.jar" to your main app jar. You also need to run sign.rb to
sign all the JARs (otherwise LWJGL won't run -- see Java sandbox).
