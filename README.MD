# ViaProxyWhitelist
Only allow specified players to join the ViaProxy server.

## Usage
### Installation
Download the latest release from the [releases page](https://github.com/ViaVersionAddons/ViaProxyWhitelist/releases) and place it in the `plugins` folder of the ViaProxy server.\
The minimum required version of ViaProxy is `3.3.4`.

### Configuration
You must enable the `proxy-online-mode` option in the config!\
The plugin does not work without this option enabled.

After starting the server with the plugin, a `whitelist.yml` file will be created in the server folder.\
It contains the kick message and the list of players that are allowed to join the server.

```yaml
#The message that will be displayed when a player is not whitelisted
KickMessage: You are not whitelisted on this server!

#The list of players that are allowed to join the server
Whitelist:
- Player1
- Player2
```
