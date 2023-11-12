package pp.rsmmm.domain.consumer.dto;

import lombok.Builder;
import lombok.Getter;
import pp.rsmmm.domain.consumer.entity.ConsumerInfo;

@Builder
@Getter
public class ConsumerResponseDto {

    private ConsumerInfo consumerInfo;
    private Integer status;
    private String message;

}
