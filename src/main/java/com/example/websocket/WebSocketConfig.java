package com.example.websocket;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;



//설정 파일이고, 스프링이 앱을 실행시킬때 자동으로 로드됨
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic"); // /topic으로 시작되는 메시지가 브로커를 통해서 클라이언트에 전달됨
        config.setApplicationDestinationPrefixes("/app"); //클라이언트가 /app으로 시작하는 곳에 보내면 @MessageMapping에서 찾아서 거기로 라우팅
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").withSockJS(); //withSockJS를 사용해서 websocket을 사용하지 않는 브라우저에서도 통신을 지원함
    }
}
