package pp.rsmmm.domain.consumer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pp.rsmmm.domain.consumer.dto.ConsumerResponseDto;
import pp.rsmmm.domain.consumer.dto.ConsumerSignUpRequestDto;
import pp.rsmmm.domain.consumer.service.ConsumerService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/consumer")
public class ConsumerController {

    private final ConsumerService consumerService;

    /**
     * 회원 가입
     */
    @PostMapping("/sing-up")
    public ResponseEntity<ConsumerResponseDto> signUp(@RequestBody ConsumerSignUpRequestDto consumerSignUpRequestDto) {
        ConsumerResponseDto consumerResponseDto = consumerService.signUp(consumerSignUpRequestDto);
        return ResponseEntity.status(consumerResponseDto.getStatus()).body(consumerResponseDto);
    }
}
