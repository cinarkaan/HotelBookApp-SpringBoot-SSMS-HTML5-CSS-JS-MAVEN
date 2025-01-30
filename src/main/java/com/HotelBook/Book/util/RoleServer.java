package com.HotelBook.Book.util;
import com.HotelBook.Book.controller.LoginController;
import org.java_websocket.server.WebSocketServer;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;

import java.net.InetSocketAddress;
import java.util.Objects;

public class RoleServer extends WebSocketServer {

    public RoleServer(int port) {
        super(new InetSocketAddress(port));
        start();
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        System.out.println("✅ Yeni bağlantı: " + conn.getRemoteSocketAddress());
        if (Objects.equals(LoginController.Role, "Yonetici"))
            conn.send("Admin"); // İstemciye mesaj gönder
        else
            conn.send("Staff"); // İstemciye mesaj gönder
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        System.out.println("❌ Bağlantı kapandı: " + conn.getRemoteSocketAddress());
    }

    @Override
    public void onMessage(WebSocket conn, String message) {
        System.out.println("📩 Alınan mesaj: " + message);
        conn.send("Mesajınız alındı: " + message);
    }

    @Override
    public void onError(WebSocket conn, Exception ex) {
        System.out.println("⚠️ Hata oluştu: " + ex.getMessage());
    }

    @Override
    public void onStart() {
        System.out.println("🚀 WebSocket sunucusu başlatıldı!");
    }

}
