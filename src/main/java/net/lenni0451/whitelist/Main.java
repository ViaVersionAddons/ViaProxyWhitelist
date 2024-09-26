package net.lenni0451.whitelist;

import net.lenni0451.lambdaevents.EventHandler;
import net.raphimc.viaproxy.ViaProxy;
import net.raphimc.viaproxy.plugins.ViaProxyPlugin;
import net.raphimc.viaproxy.plugins.events.ConnectEvent;
import net.raphimc.viaproxy.plugins.events.ViaProxyLoadedEvent;
import net.raphimc.viaproxy.util.logging.Logger;

public class Main extends ViaProxyPlugin {

    @Override
    public void onEnable() {
        WhitelistConfig.load();
        ViaProxy.EVENT_MANAGER.register(this);
    }

    @EventHandler
    public void onViaProxyLoaded(final ViaProxyLoadedEvent event) {
        if (!ViaProxy.getConfig().isProxyOnlineMode()) {
            Logger.LOGGER.error("Proxy online mode is disabled, please enable it to use the whitelist plugin!");
            Logger.LOGGER.error("Without online mode the whitelist plugin would be effectively useless");
            Logger.LOGGER.error("Shutting down...");
            System.exit(0);
        }
    }

    @EventHandler(priority = Integer.MIN_VALUE)
    public void onConnect(final ConnectEvent event) {
        event.getProxyConnection().getPacketHandlers().add(0, new LoginListener(event.getProxyConnection()));
    }

}
