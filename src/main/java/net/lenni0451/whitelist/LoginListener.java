package net.lenni0451.whitelist;

import io.netty.channel.ChannelFutureListener;
import net.raphimc.netminecraft.packet.Packet;
import net.raphimc.netminecraft.packet.impl.login.C2SLoginHelloPacket;
import net.raphimc.viaproxy.proxy.packethandler.PacketHandler;
import net.raphimc.viaproxy.proxy.session.ProxyConnection;

import java.util.List;

public class LoginListener extends PacketHandler {

    public LoginListener(final ProxyConnection proxyConnection) {
        super(proxyConnection);
    }

    @Override
    public boolean handleC2P(Packet packet, List<ChannelFutureListener> listeners) {
        if (packet instanceof C2SLoginHelloPacket loginHello) {
            if (!WhitelistConfig.whitelist.contains(loginHello.name)) {
                this.proxyConnection.kickClient(WhitelistConfig.kickMessage);
            }
        }
        return true;
    }

}
