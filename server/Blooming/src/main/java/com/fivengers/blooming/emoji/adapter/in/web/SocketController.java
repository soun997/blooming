package com.fivengers.blooming.emoji.adapter.in.web;

import com.fivengers.blooming.config.stomp.SocketAuthUser;
import com.fivengers.blooming.emoji.adapter.in.web.dto.EmojiSendRequest;
import com.fivengers.blooming.emoji.adapter.in.web.dto.EmojiSendResponse;
import com.fivengers.blooming.emoji.application.port.in.SocketEmojiUseCase;
import com.fivengers.blooming.emoji.domain.Emoji;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;


@Slf4j
@Controller
@RequiredArgsConstructor
public class SocketController {

    private final SimpMessageSendingOperations messagingTemplate;
    private final SocketEmojiUseCase socketEmojiUseCase;

    @MessageMapping("/lives/emoji")
    public void sendEmoji(@Header("simpUser") SocketAuthUser user,
            @Payload EmojiSendRequest emojiSendRequest) {
        String sessionId = user.getSessionId();
        // TODO : memberId로 해당 라이브에 참여한 유저인지 검증 서비스 추후 구현 예정
        Emoji emoji = socketEmojiUseCase.searchEmojiByMotion(emojiSendRequest);

        messagingTemplate.convertAndSend(
                "/topic/lives/" + sessionId + "/emoji",
                EmojiSendResponse.from(user, emoji));
    }

}
