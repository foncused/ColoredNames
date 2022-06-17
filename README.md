# ColoredNames

### Description:
"ColoredNames" adds color to player names above their heads and in the tablist (optional via config) by using the scoreboard API. It should be noted here that this may cause problems if you are using other plugins that use the scoreboard API.

### Installation:
1. Copy ColoredNames.jar into your /plugins directory
2. Assign permissions
3. Start your server

### Permissions:
- colorednames.all (parent permission, should only be used as described below)
- colorednames.black
- colorednames.dark_blue
- colorednames.dark_green
- colorednames.dark_aqua
- colorednames.dark_red
- colorednames.dark_purple
- colorednames.gold
- colorednames.gray
- colorednames.dark_gray
- colorednames.blue
- colorednames.green
- colorednames.aqua
- colorednames.red
- colorednames.light_purple
- colorednames.yellow
- colorednames.white
- colorednames.obfuscated
- colorednames.bold
- colorednames.strikethrough
- colorednames.underline
- colorednames.italic

Please be aware that using '*' as a permission for a user or group will assign all colors to that user or group. You will need to assign a color the following way if you are using '*':
```yaml
permissions:
- colorednames.green
- -colorednames.all
- '*'
```

### Configuration:
- tablist - boolean if you want names to be colored in the tablist
- refresh - integer (ticks) at which to refresh nametags

https://github.com/foncused/ColoredNames/blob/master/src/main/resources/config.yml

### Support:
If you run into any server performance problems, or if the plugin is not working as advertised (console errors, bugs, etc.), please do not hesitate to contact me, post in the discussion thread, or open an issue on GitHub.

### Links:
- Spigot: https://www.spigotmc.org/resources/colorednames.4914/
- Donate: https://paypal.me/foncused
