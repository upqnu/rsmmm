package pp.rsmmm.domain.consumer.entity;

import lombok.Getter;

@Getter
public enum Authority {
    ROLE_MEMBER("회원"),
    ROLE_ADMIN("관리자");

    private final String authority;

    Authority(String authority) {
        this.authority = authority;
    }
}
