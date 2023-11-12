package pp.rsmmm.domain.consumer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pp.rsmmm.domain.consumer.dto.ConsumerResponseDto;
import pp.rsmmm.domain.consumer.dto.ConsumerSignUpRequestDto;
import pp.rsmmm.domain.consumer.entity.Consumer;
import pp.rsmmm.domain.consumer.repository.ConsumerRepository;

@RequiredArgsConstructor
@Service
public class ConsumerService {

    private final ConsumerRepository consumerRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * 회원 가입
     */
    @Transactional
    public ConsumerResponseDto signUp(ConsumerSignUpRequestDto consumerSignUpRequestDto) {
        // 아이디 중복 체크
        if (consumerRepository.existsByName(consumerSignUpRequestDto.getName())) {
            return ConsumerResponseDto.builder()
                    .status(HttpStatus.BAD_REQUEST.value())
                    .message("존재하는 사용자명입니다. 다른 이름으로 가입해주세요.")
                    .build();
        }

        // 회원 정보 저장
        consumerRepository.save(Consumer.builder()
                .name(consumerSignUpRequestDto.getName())
                .password(passwordEncoder.encode(consumerSignUpRequestDto.getPassword()))
                .email(consumerSignUpRequestDto.getEmail())
                .authority(consumerSignUpRequestDto.getAuthority())
                .build()
        );

        // 회원 가입 성공을 통보
        return ConsumerResponseDto.builder()
                .status(HttpStatus.CREATED.value())
                .message("회원가입에 성공했습니다.")
                .build();
    }
}
