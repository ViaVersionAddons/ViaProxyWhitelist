package net.lenni0451.whitelist;

import net.lenni0451.optconfig.ConfigLoader;
import net.lenni0451.optconfig.annotations.Description;
import net.lenni0451.optconfig.annotations.OptConfig;
import net.lenni0451.optconfig.annotations.Option;
import net.lenni0451.optconfig.provider.ConfigProvider;
import net.raphimc.viaproxy.util.logging.Logger;

import java.io.File;
import java.util.List;

@OptConfig
public class WhitelistConfig {

    @Option("KickMessage")
    @Description("The message that will be displayed when a player is not whitelisted")
    public static String kickMessage = "You are not whitelisted on this server!";

    @Option("Whitelist")
    @Description("The list of players that are allowed to join the server")
    public static List<String> whitelist = List.of("Player1", "Player2");

    public static void load() {
        try {
            ConfigLoader<WhitelistConfig> configLoader = new ConfigLoader<>(WhitelistConfig.class);
            configLoader.getConfigOptions().setResetInvalidOptions(true);
            configLoader.loadStatic(ConfigProvider.file(new File("whitelist.yml")));
        } catch (Throwable t) {
            Logger.LOGGER.error("Failed to load the whitelist configuration!", t);
            System.exit(-1);
        }
    }

}
