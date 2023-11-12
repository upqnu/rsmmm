package pp.rsmmm.domain.consumer.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import pp.rsmmm.domain.consumer.entity.Authority;

@Getter
@Setter
public class ConsumerSignUpRequestDto {

    @NotBlank
    private String name;

    @NotBlank
    private String password;

    private String email;

    @NotNull
    private Authority authority = Authority.ROLE_MEMBER;
}
