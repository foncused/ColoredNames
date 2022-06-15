# SBNameTags

### Description:
"SBNameTags" adds color to player names above their heads and in the tablist (optional via config) by using the scoreboard API. It should be noted here that this may cause problems if you are using other plugins that use the scoreboard API.

### Installation:
1. Copy SBNameTags.jar into your /plugins directory
2. Assign permissions
3. Start your server

### Permissions:
- sbnametags.all (parent permission, should only be used as described below)
- sbnametags.black
- sbnametags.dark_blue
- sbnametags.dark_green
- sbnametags.dark_aqua
- sbnametags.dark_red
- sbnametags.dark_purple
- sbnametags.gold
- sbnametags.gray
- sbnametags.dark_gray
- sbnametags.blue
- sbnametags.green
- sbnametags.aqua
- sbnametags.red
- sbnametags.light_purple
- sbnametags.yellow
- sbnametags.white
- sbnametags.obfuscated
- sbnametags.bold
- sbnametags.strikethrough
- sbnametags.underline
- sbnametags.italic

Please be aware that using '*' as a permission for a user or group will assign all colors to that user or group. You will need to assign a color the following way if you are using '*':
```yaml
permissions:
- sbnametags.green
- -sbnametags.all
- '*'
```

### Configuration:
- tablist - boolean if you want names to be colored in the tablist
- refresh - integer (ticks) at which to refresh nametags

https://github.com/foncused/SBNameTags/blob/master/src/main/resources/config.yml

### Support:
If you run into any server performance problems, or if the plugin is not working as advertised (console errors, bugs, etc.), please do not hesitate to contact me, post in the discussion thread, or open an issue on GitHub.

### Links:
- Spigot: https://www.spigotmc.org/resources/sbnametags.4914/
- Donate: https://paypal.me/foncused
